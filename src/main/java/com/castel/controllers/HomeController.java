package com.castel.controllers;
import com.castel.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController extends BaseController {


    /**
     * Verify if user is from owner or member type and redirects accordingly
     * @param model
     * @param request
     * @return principal owner's or member's page
     */
    @RequestMapping("/")
    public String initialPage(Model model, WebRequest request){

        User principal = this.getPrincipalUser();
        model.addAttribute("principal", principal);

        if(principal.getRoles() == null){return "login";}

        for (Role role: principal.getRoles()){
            if(new String(role.getRole()).equals("ROLE_OWNER") || new String(role.getRole()).equals("ROLE_USER")){
                SimpleDateFormat formatter = new SimpleDateFormat(  "dd/MM/yyyy");
                Date date = new Date();
                DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dateformatter = DateTimeFormatter.ofPattern("HH:mm");


                model.addAttribute("data_hoje", formatter.format(date));
                model.addAttribute("pedidos", this.pedidoService.listPedidosHome());
                model.addAttribute("formatter", dateformatter);
                model.addAttribute("tele", TipoPedido.TELE);
                model.addAttribute("cartao", TipoPagamento.CARTAO);

                model.addAttribute("total_pedidos", this.pedidoService.getTotalPedidosDoDia());
                model.addAttribute("total_pedidos_producao", this.pedidoService.getTotalPedidosEmProducao());
                model.addAttribute("total_pedidos_confirmados", this.pedidoService.getTotalPedidosConfirmados());
                return "homepage";
            }
        }

        return "login";
    }

    /**
     * Login validation method
     * @param error
     * @param logout
     * @param model
     * @return to corresponding page, login or home
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value = "/relatorio/{type}" , method = RequestMethod.GET)
    public String relatoriosPage(@PathVariable("type") String type, Model model){
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateformatter = DateTimeFormatter.ofPattern("HH:mm");
        int status_id;

        if(type.equals("pedidos")) { status_id = 4; }
        else {
            model.addAttribute("problema", true);
            status_id = 5;
        }

        List<Pedido> pedidos = new ArrayList<>();
        pedidos = this.pedidoService.listPedidosByStatus(status_id,"", 100);


        if(pedidos.isEmpty()){
            return this.retornaRelatorioVazio(model, "");
        }
        Double faturado = 0.0;

        for(Pedido pedido : pedidos){
            faturado = faturado + pedido.getValorTotal();
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String start = pedidos.get(0).getStart().format(df);
        String end = pedidos.get(pedidos.size()-1).getStart().format(df);

        DecimalFormat def = new DecimalFormat();
        def.setMaximumFractionDigits(2);

        model.addAttribute("faturado", def.format(faturado));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("qtdp", pedidos.size());

        model.addAttribute("periodo", "De " + start + " até " + end);

        model.addAttribute("formatter", dateformatter);
        model.addAttribute("tele", TipoPedido.TELE);
        model.addAttribute("cartao", TipoPagamento.CARTAO);
        return "relatorios";
    }



    @RequestMapping(value = "/filtro/relatorio" , method = RequestMethod.GET)
    public String relatoriosPageFiltro(Model model, WebRequest request){

        int status_id;

        if(request.getParameter("problema").equals("true")){
            status_id = 5;
        }else{
            status_id = 4;
        }

        String filtro_dia = request.getParameter("filtro_dia");
        String filtro_mes = request.getParameter("filtro_mes");
        String filtro_ano = request.getParameter("filtro_ano");

        String filter;
        List<Pedido> pedidos;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String periodo = "";

        if(filtro_mes.equals("0")){
            pedidos = this.pedidoService.listPedidosByStatus(status_id, filtro_dia, 0);

            if(pedidos.isEmpty()){
                return this.retornaRelatorioVazio(model, filtro_dia);
            }

            periodo = pedidos.get(0).getStart().format(df);
        }else{
            filter = filtro_ano + "-" + filtro_mes;
            pedidos = this.pedidoService.listPedidosByStatus(status_id, filter, 0);

            if(pedidos.isEmpty()){
                return this.retornaRelatorioVazio(model, filtro_mes + "/" + filtro_ano);
            }

            String start = pedidos.get(0).getStart().format(df);
            String end = pedidos.get(pedidos.size()-1).getStart().format(df);
            periodo = "De " + start + " até " + end;
        }

        Double faturado = 0.0;

        for(Pedido pedido : pedidos){
            faturado = faturado + pedido.getValorTotal();
        }


        DecimalFormat def = new DecimalFormat();
        def.setMaximumFractionDigits(2);

        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateformatter = DateTimeFormatter.ofPattern("HH:mm");

        model.addAttribute("faturado", def.format(faturado));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("qtdp", pedidos.size());
        model.addAttribute("periodo", periodo);
        model.addAttribute("formatter", dateformatter);
        model.addAttribute("tele", TipoPedido.TELE);
        model.addAttribute("cartao", TipoPagamento.CARTAO);

        return "relatorios";
    }

    public String retornaRelatorioVazio(Model model, String periodo){

        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateformatter = DateTimeFormatter.ofPattern("HH:mm");

        model.addAttribute("faturado", 0.0);
        model.addAttribute("pedidos", null);
        model.addAttribute("qtdp", 0);
        model.addAttribute("periodo", periodo);
        model.addAttribute("formatter", dateformatter);
        model.addAttribute("tele", TipoPedido.TELE);
        model.addAttribute("cartao", TipoPagamento.CARTAO);
        return "relatorios";
    }



    @RequestMapping(value = "/administracao-valores" , method = RequestMethod.GET)
    public String administracaoDeValoresPage(Model model){
        model.addAttribute("valoresAdicionais", this.valoresService.getFirstLine());
        return "administracao-valores";
    }

    @RequestMapping(value = "/administracao-usuarios" , method = RequestMethod.GET)
    public String administracaoDeUsuariosPage(Model model){
        model.addAttribute("users", this.userService.listUsers(this.getPrincipalUser().getId()));
        return "administracao-usuarios";
    }

    @RequestMapping(value = "/banco-de-sabores" , method = RequestMethod.GET)
    public String bancoDeSaboresPage(Model model){
        model.addAttribute("sabores", this.saborService.listSabores());
        return "banco-de-sabores";
    }

    @RequestMapping(value = "/banco-de-bebidas" , method = RequestMethod.GET)
    public String bancoDeBebidasPage(Model model){
        model.addAttribute("bebidas", this.bebidaService.listBebidas());
        return "banco-de-bebidas";
    }

    @RequestMapping(value = "/reimprimir/pedido/{id}", method = RequestMethod.GET)
    public RedirectView reimprimePedido(@PathVariable("id") int id){
        ImpressaoController impressaoController = new ImpressaoController();
        impressaoController.detectaImpressoras();
        impressaoController.imprime(this.pedidoService.getPedidoById(id));
        return new RedirectView("/");
    }

    /**
     * Redirects to 403 page
     * @return not authorized page
     */
    @RequestMapping("/403")
    public String notAllowed(){
        return "errors/403";
    }
}



