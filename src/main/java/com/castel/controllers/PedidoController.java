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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PedidoController extends BaseController {

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
                pedido.setValorTotal(0.0);
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
        Pedido pedido;

        try{
            for(int i=0;i<quantidade; i++){
                Item item = new Item();
                item.setPedido(this.pedidoService.getPedidoById(pedido_id));
                item.setIspizza(false);
                item.setBebida(bebida);
                item.setValor(bebida.getValor());
                this.pedidoService.addItem(item);

                pedido = this.pedidoService.getPedidoById(pedido_id);
                Double valorAtualizado = pedido.getValorTotal() + bebida.getValor();
                pedido.setValorTotal(valorAtualizado);
                this.pedidoService.updatePedido(pedido);
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

            Pedido pedido = this.pedidoService.getPedidoById(pedido_id);
            Double valorAtualizado = pedido.getValorTotal() + this.calculateValorPizza(pizza);
            pedido.setValorTotal(valorAtualizado);
            this.pedidoService.updatePedido(pedido);

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

    @RequestMapping(value = "/remove/item/{id}" , method = RequestMethod.GET)
    public RedirectView removeItem(@PathVariable("id") int id, RedirectAttributes redirectAttributes){

        try{

            Item item = this.pedidoService.getItemById(id);
            Pedido pedido = item.getPedido();

            if(pedido.getValorTotal() - item.getValor() < 1){
                pedido.setValorTotal(0.0);
            }else{
                pedido.setValorTotal(pedido.getValorTotal() - item.getValor());
            }

            this.pedidoService.updatePedido(pedido);
            this.pedidoService.removeItem(id);

            redirectAttributes.addFlashAttribute("msg", "Item removido com sucesso.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/pedido/add");
    }



    @RequestMapping(value = "/finaliza/pedido" , method = RequestMethod.POST)
    public RedirectView finalizaPedido(WebRequest request, RedirectAttributes redirectAttributes){

        int pedido_id = Integer.parseInt(request.getParameter("pedido_id"));
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        TipoPedido tipoPedido = TipoPedido.valueOf(request.getParameter("tipoPedido"));
        TipoPagamento tipoPagamento = TipoPagamento.valueOf(request.getParameter("tipoPagamento"));

        try {

            Pedido pedido = this.pedidoService.getPedidoById(pedido_id);
            pedido.setNomeCliente(nome);
            pedido.setTelefone(telefone);
            pedido.setTipoPedido(tipoPedido);

            if(tipoPedido == TipoPedido.TELE)
            {

                String bairro = request.getParameter("bairro");
                String rua = request.getParameter("rua");
                int numero = Integer.parseInt(request.getParameter("numero"));

                Endereco endereco = new Endereco();
                endereco.setBairro(bairro);
                endereco.setRua(rua);
                endereco.setNumero(numero);
                this.pedidoService.addEndereco(endereco);
                pedido.setEndereco(endereco);
            }

            pedido.setTipoPagamento(tipoPagamento);
            if(tipoPagamento == TipoPagamento.CARTAO){
                Bandeira bandeira = Bandeira.valueOf(request.getParameter("bandeira"));
                pedido.setBandeira(bandeira);
            }
            if(tipoPagamento == TipoPagamento.DINHEIRO){
                Double troco = Double.parseDouble(request.getParameter("troco"));
                pedido.setTroco(troco);
            }

            pedido.setStart(LocalDateTime.now());
            pedido.setStatusPedido(StatusPedido.EM_PRODUCAO);
            this.pedidoService.updatePedido(pedido);

            redirectAttributes.addFlashAttribute("msg", "Pedido finalizado com sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/");
    }

    @RequestMapping(value = "/confirma/pedido/{id}" , method = RequestMethod.GET)
    public RedirectView confirmaPedido(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        Pedido pedido = this.pedidoService.getPedidoById(id);
        try{
            pedido.setStatusPedido(StatusPedido.CONFIRMADO);
            pedido.setEnd(LocalDateTime.now());
            redirectAttributes.addFlashAttribute("msg", "Pedido confirmado com sucesso.");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        this.pedidoService.updatePedido(pedido);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/pedido/add/problema", method = RequestMethod.POST)
    public  RedirectView addProblemaPedido(WebRequest request, RedirectAttributes redirectAttributes){
        String descricao_problema = request.getParameter("problemadesc");
        Problema problema = new Problema();
        Pedido pedido = this.pedidoService.getPedidoById(Integer.parseInt(request.getParameter("pedido_id")));
        pedido.setStatusPedido(StatusPedido.PROBLEMA);
        pedido.setEnd(LocalDateTime.now());

        try{
            this.pedidoService.updatePedido(pedido);
            problema.setDescricao(descricao_problema);
            problema.setPedido(pedido);
            this.pedidoService.addProblem(problema);
        }catch(Exception e){ redirectAttributes.addFlashAttribute("error", e.getMessage());}
        return new RedirectView("/");
    }

}
