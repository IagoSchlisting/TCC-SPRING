package com.castel.controllers;

import com.castel.models.Pedido;
import com.castel.models.StatusPedido;
import com.castel.models.User;
import com.castel.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class PedidoController extends BaseController {

    @Resource
    private PedidoService pedidoService;

    @RequestMapping(value = "/pedido/add" , method = RequestMethod.GET)
    public String AdicionarEditarPedidoPage(Model model)
    {

        User session_user = this.getPrincipalUser();
        Pedido ultimoPedido = this.pedidoService.findLastOrderFromUser(session_user.getId());
        if(ultimoPedido == null || ultimoPedido.equals(null) || ultimoPedido.getStatusPedido() != StatusPedido.EM_CRIACAO){
            try {
                Pedido pedido = new Pedido();
                pedido.setUser(this.getPrincipalUser());
                pedido.setStatusPedido(StatusPedido.EM_CRIACAO);
                this.pedidoService.addPedido(pedido);
                model.addAttribute("type", "Criando");

            }catch (Exception e){
                model.addAttribute("error", e.getMessage());
            }
        }


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


}
