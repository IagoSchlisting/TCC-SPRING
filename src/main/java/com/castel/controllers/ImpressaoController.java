package com.castel.controllers;

import com.castel.models.*;

import javax.print.*;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImpressaoController {

    ArrayList<String> lines = new ArrayList<String>();

    public List<String> formatText(Pedido pedido){

        lines.add(" -------------------------------- ");
        lines.add(" Pedido Numero: " + pedido.getId());
        lines.add(" -------------------------------- ");
        lines.add("");
        for(Item it : pedido.getItens()){
            if(it.isIspizza()) {
                String borda="";
                if (it.getPizza().isComborda()) {
                    borda = "c/borda";
                }
                lines.add(" Pizza " + it.getPizza().getTamanhoPizza() + " " + borda);

                for (Sabor sabor : it.getPizza().getSabores()) {
                    lines.add(" - " + sabor.getSabor());
                }

                lines.add(" ---------------------------");
            }
        }
        lines.add("");
        for(Item it : pedido.getItens()){
            if(!it.isIspizza()){
                lines.add(" Bebida: " + it.getBebida().getBebida() + "");
            }
        }
        lines.add("");
        lines.add(" -------- Dados do Cliente ------");
        lines.add(" Nome: " + pedido.getNomeCliente());
        lines.add(" Telefone: " + pedido.getTelefone());
        lines.add(" Tipo de Pagamento: " + pedido.getTipoPagamento());

        if(pedido.getTipoPagamento().equals(TipoPagamento.CARTAO)){
            lines.add(" Bandeira: " + pedido.getBandeira());
        }else{
            lines.add(" Troco: " + pedido.getTroco());
        }

        lines.add(" TipoPedido: " + pedido.getTipoPedido());
        if(pedido.getTipoPedido().equals(TipoPedido.TELE)){
            lines.add("");
            lines.add(" -------- Endereco Tele -------");
            lines.add(" Bairro: " + pedido.getEndereco().getBairro());
            lines.add(" Rua: " + pedido.getEndereco().getRua());
            lines.add(" Numero: " + pedido.getEndereco().getNumero());
        }

        lines.add(" ----------------------------");
        lines.add(" Total: R$" + pedido.getValorTotal());
        lines.add("");
        lines.add("");
        lines.add("");
        //String body = str_pizzas + bebidas + dadosCliente + "\n\n\n\n\n\n\n" +(char)27+(char)109;
        return lines;
    }
}
