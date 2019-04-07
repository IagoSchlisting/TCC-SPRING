package com.castel.controllers;

import com.castel.models.*;
import com.castel.service.PedidoService;
import com.castel.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PedidoController extends BaseController {

    @Resource
    private PedidoService pedidoService;

    @Resource
    private PizzaService pizzaService;

    @RequestMapping(value = "/pedido/add" , method = RequestMethod.GET)
    public String AdicionarEditarPedidoPage(Model model)
    {

        User session_user = this.getPrincipalUser();
        Pedido ultimoPedido = this.pedidoService.findLastOrderFromUser(session_user.getId());
        if(ultimoPedido == null || ultimoPedido.getStatusPedido() != StatusPedido.EM_CRIACAO){
            try {
                Pedido pedido = new Pedido();
                pedido.setUser(this.getPrincipalUser());
                pedido.setStatusPedido(StatusPedido.EM_CRIACAO);
                this.pedidoService.addPedido(pedido);
            }catch (Exception e){
                model.addAttribute("error", e.getMessage());
            }
        }
        model.addAttribute("type", "Criando");
        model.addAttribute("pedido", this.pedidoService.findLastOrderFromUser(session_user.getId()));
        return "add-edit-pedido";
    }

    @RequestMapping(value = "/pizza/add/{id}" , method = RequestMethod.GET)
    public String AdicionarPizzaPage(@PathVariable("id") int id, Model model){
        model.addAttribute("pedido_id", id);
        model.addAttribute("sabores", this.saborService.listSabores());
        return "add-pizza";
    }

    @RequestMapping(value = "/bebida/add/{id}" , method = RequestMethod.GET)
    public String AdicionarBebidaPage(@PathVariable("id") int id, Model model){
        model.addAttribute("pedido_id", id);
        model.addAttribute("bebidas", this.bebidaService.listBebidas());
        return "add-bebida";
    }

    @RequestMapping(value = "/pedido/bebida/add" , method = RequestMethod.POST)
    public RedirectView AdicionarBebidaAction(WebRequest request, RedirectAttributes redirectAttributes){

        int pedido_id = Integer.parseInt(request.getParameter("pedido_id"));
        int bebida_id = Integer.parseInt(request.getParameter("bebida"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        Bebida bebida = this.bebidaService.getBebidaById(bebida_id);

        try{
            for(int i=0;i<quantidade; i++){
                Item item = new Item();
                item.setPedido(this.pedidoService.getPedidoById(pedido_id));
                item.setIspizza(false);
                item.setBebida(bebida);
                item.setValor(bebida.getValor());
                this.pedidoService.addItem(item);
            }
            redirectAttributes.addFlashAttribute("msg", "Bebida adicionada com sucesso.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return new RedirectView("/pedido/add");
    }

    @RequestMapping(value = "/pizza/add" , method = RequestMethod.POST)
    public RedirectView AdicionarPizzaAction(WebRequest request, RedirectAttributes redirectAttributes){

        int pedido_id = Integer.parseInt(request.getParameter("pedido_id"));
        TamanhoPizza tamanhopizza = TamanhoPizza.valueOf(request.getParameter("tamanhopizza"));
        boolean borda = request.getParameter("borda") != null ? true : false;
        int sabor1 = Integer.parseInt(request.getParameter("sabor1"));
        int sabor2 = Integer.parseInt(request.getParameter("sabor2"));
        int sabor3 = Integer.parseInt(request.getParameter("sabor3"));
        int sabor4 = Integer.parseInt(request.getParameter("sabor4"));

        try{
            List<Sabor> sabores = new ArrayList<>();
            if(sabor1 != 0){sabores.add(this.saborService.getSaborById(sabor1));}
            if(sabor2 != 0){sabores.add(this.saborService.getSaborById(sabor2));}
            if(sabor3 != 0){sabores.add(this.saborService.getSaborById(sabor3));}
            if(sabor4 != 0){sabores.add(this.saborService.getSaborById(sabor4));}

            Pizza pizza = new Pizza();
            pizza.setTamanhoPizza(tamanhopizza);
            pizza.setComborda(borda);
            pizza.setSabores(sabores);
            this.pizzaService.addPizza(pizza);

            Item item = new Item();
            item.setIspizza(true);
            item.setPizza(pizza);
            item.setValor(this.calculateValorPizza(pizza));
            item.setPedido(this.pedidoService.getPedidoById(pedido_id));
            this.pedidoService.addItem(item);
            redirectAttributes.addFlashAttribute("msg", "Pizza adicionada com sucesso!");

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }


        return new RedirectView("/pedido/add");
    }

    public Double calculateValorPizza(Pizza pizza){

        ValoresAdicionais tabelaValores = this.valoresService.getFirstLine();
        Double valorTotal = 0.0;
        switch (pizza.getTamanhoPizza()){
            case BROTO:
                valorTotal = valorTotal + tabelaValores.getValorBaseBroto();

                if(pizza.getSabores().size() == 1 && pizza.getSabores().get(0).getEspecial()){
                    valorTotal = valorTotal + tabelaValores.getValorEspecialBroto1();
                }else if(pizza.getSabores().size() == 2){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialBroto2();
                        }
                    }
                }

                break;
            case MEDIA:
                valorTotal = valorTotal + tabelaValores.getValorBaseMedia();

                if(pizza.getSabores().size() == 1 && pizza.getSabores().get(0).getEspecial()){
                    valorTotal = valorTotal + tabelaValores.getValorEspecialMedia1();
                }else if(pizza.getSabores().size() == 2){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialMedia2();
                        }
                    }
                }else if(pizza.getSabores().size() == 3){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialMedia3();
                        }
                    }
                }

                break;
            case GRANDE:
                valorTotal = valorTotal + tabelaValores.getValorBaseGrande();
                if(pizza.isComborda()){valorTotal = valorTotal + tabelaValores.getValorBordaGrande();}

                if(pizza.getSabores().size() == 1 && pizza.getSabores().get(0).getEspecial()){
                    valorTotal = valorTotal + tabelaValores.getValorEspecialGrande1();
                }else if(pizza.getSabores().size() == 2){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialGrande2();
                        }
                    }
                }else if(pizza.getSabores().size() == 3){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialGrande3();
                        }
                    }
                }else if(pizza.getSabores().size() == 4){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialGrande4();
                        }
                    }
                }

                break;
            case GIGANTE:
                valorTotal = valorTotal + tabelaValores.getValorBaseGigante();
                if(pizza.isComborda()){valorTotal = valorTotal + tabelaValores.getValorBordaGigante();}

                if(pizza.getSabores().size() == 1 && pizza.getSabores().get(0).getEspecial()){
                    valorTotal = valorTotal + tabelaValores.getValorEspecialGigante1();
                }else if(pizza.getSabores().size() == 2){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialGigante2();
                        }
                    }
                }else if(pizza.getSabores().size() == 3){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialGigante3();
                        }
                    }
                }else if(pizza.getSabores().size() == 4){
                    for(Sabor sabor : pizza.getSabores()){
                        if(sabor.getEspecial()){
                            valorTotal = valorTotal + tabelaValores.getValorEspecialGigante4();
                        }
                    }
                }
                break;
        }
        return valorTotal;
    }

}
