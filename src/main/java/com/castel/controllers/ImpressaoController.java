package com.castel.controllers;

import com.castel.models.Pedido;

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
        return "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido " +
                "\n testeeeeeeeeeeeeeeee muito doido ";
    }

//
//    public static List<String> retornaImressoras(){
//        try {
//            List<String> listaImpressoras = new ArrayList<>();
//            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
//            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
//            for (PrintService p : ps) {
//                listaImpressoras.add(p.getName());
//            }
//            return listaImpressoras;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
