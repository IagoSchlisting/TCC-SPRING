package com.castel.controllers;

import com.castel.models.Pedido;
import com.castel.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class PedidoController extends BaseController {

    @Resource
    private PedidoService pedidoService;

    @RequestMapping(value = "/add-pedido" , method = RequestMethod.GET)
    public String AdicionarEditarPedidoPage(Model model)
    {
        Pedido pedido = new Pedido();
        pedido.setUser(this.getPrincipalUser());
        this.pedidoService.addPedido(pedido);
        Pedido ultimoPedido =  this.pedidoService.findLastOrderFromUser(this.getPrincipalUser().getId());
        model.addAttribute("pedido", ultimoPedido);
        model.addAttribute("type", "Criando");
        return "add-edit-pedido";
    }


}
