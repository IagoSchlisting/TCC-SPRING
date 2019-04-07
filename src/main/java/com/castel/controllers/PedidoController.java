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


    @RequestMapping(value = "/pizza/add" , method = RequestMethod.POST)
    public RedirectView AdicionarPizzaAction(WebRequest request, RedirectAttributes redirectAttributes){

        int sabor2 = Integer.parseInt(request.getParameter("sabor2"));
        TamanhoPizza tamanhopizza = TamanhoPizza.valueOf(request.getParameter("tamanhopizza"));
        boolean borda = request.getParameter("borda").equals(1) ? true : false;
        int sabor1 = Integer.parseInt(request.getParameter("sabor1"));
        int sabor3 = Integer.parseInt(request.getParameter("sabor3"));
        int sabor4 = Integer.parseInt(request.getParameter("sabor4"));

        try{
//
//            List<SaborTamanho> sabores = new ArrayList<Sabor>();
//
//            if(sabor1 != 0){sabores.add(this.saborService.getSaborById(sabor1));}
//            if(sabor2 != 0){sabores.add(this.saborService.getSaborById(sabor2));}
//            if(sabor3 != 0){sabores.add(this.saborService.getSaborById(sabor3));}
//            if(sabor4 != 0){sabores.add(this.saborService.getSaborById(sabor4));}
//
//            Pizza pizza = new Pizza();
//            pizza.setComborda(borda.equals("1") ? true : false);
//            pizza.setSabores(sabores);
//
//            Item item = new Item();
//            item.setIspizza(true);
//            item.setPizza();
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }


        return new RedirectView("/pedido/add");
    }


}
