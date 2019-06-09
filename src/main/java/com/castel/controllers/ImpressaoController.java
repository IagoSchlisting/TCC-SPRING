package com.castel.controllers;

import com.castel.models.*;

import javax.print.*;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImpressaoController {

    private static PrintService impressora; // O Atributo citado anteriormente

    public void detectaImpressoras() {  //Passa por parâmetro o nome salvo da impressora
        try {
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p : ps) {
                if(p.getName()!=null && p.getName().contains("MP-4200")){
                    impressora = p;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  boolean imprime(Pedido pedido) {

        String texto = this.formatText(pedido);

        if (impressora == null) {
            JOptionPane.showMessageDialog(null, "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.");
        } else {
            try {
                DocPrintJob dpj = impressora.createPrintJob();
                InputStream stream = new ByteArrayInputStream((texto + "\n").getBytes());
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);
                return true;
            } catch (PrintException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String formatText(Pedido pedido){
        String cabecalho;
        cabecalho = " =========================== ";
        cabecalho += "\n Pedido Numero: " + pedido.getId();
        cabecalho += "\n =========================== ";

        String str_pizza;
        String str_pizzas = "\n\n";
        String bebidas = "\n\n";

        for(Item it : pedido.getItens()){
            if(it.isIspizza()) {
                String borda="";
                if (it.getPizza().isComborda()) {
                    borda = "c/borda";
                }
                str_pizza = " Pizza " + it.getPizza().getTamanhoPizza() + " " + borda;

                for (Sabor sabor : it.getPizza().getSabores()) {
                    str_pizza += "\n - " + sabor.getSabor();
                }

                str_pizza += "\n ---------------------------\n";
                str_pizzas += str_pizza;
            }
        }

        for(Item it : pedido.getItens()){
            if(!it.isIspizza()){
                bebidas += " Bebida: " + it.getBebida().getBebida() + "\n";
            }
        }

        String dadosCliente = "\n\n -------- Dados do Cliente ------";
        dadosCliente += "\n Nome: " + pedido.getNomeCliente();
        dadosCliente += "\n Telefone: " + pedido.getTelefone();
        dadosCliente += "\n Tipo de Pagamento: " + pedido.getTipoPagamento();

        if(pedido.getTipoPagamento().equals(TipoPagamento.CARTAO)){
            dadosCliente += "\n Bandeira: " + pedido.getBandeira();
        }else{
            dadosCliente += "\n Troco: " + pedido.getTroco();
        }

        dadosCliente += "\n TipoPedido: " + pedido.getTipoPedido();
        if(pedido.getTipoPedido().equals(TipoPedido.TELE)){
            dadosCliente += "\n\n -------- Endereco Tele -------";
            dadosCliente += "\n Bairro: " + pedido.getEndereco().getBairro();
            dadosCliente += "\n Rua: " + pedido.getEndereco().getRua();
            dadosCliente += "\n Numero: " + pedido.getEndereco().getNumero();
        }

        dadosCliente += "\n\n ----------------------------";
        dadosCliente += "\n Total: R$" + pedido.getValorTotal();

        String body = str_pizzas + bebidas + dadosCliente + "\n\n\n\n\n\n\n" +(char)27+(char)109;
        return cabecalho + body;
    }
}
