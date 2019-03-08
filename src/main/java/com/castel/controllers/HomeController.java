package com.castel.controllers;
import com.castel.models.Role;
import com.castel.models.User;
import com.castel.service.BebidaService;
import com.castel.service.SaborService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController extends BaseController {


    @Resource
    private SaborService saborService;

    @Resource
    private BebidaService bebidaService;


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

        for (Role role: principal.getRoles()){
            if(new String(role.getRole()).equals("ROLE_OWNER") || new String(role.getRole()).equals("ROLE_USER")){
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                model.addAttribute("diaatual", formatter.format(date));
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

    @RequestMapping(value = "/relpedidos" , method = RequestMethod.GET)
    public String relatorioDePedidosPage(){
        return "relpedidos";
    }

    @RequestMapping(value = "/relproblemas" , method = RequestMethod.GET)
    public String relatorioDeProblemasPage(){
        return "relproblemas";
    }

    @RequestMapping(value = "/administracao-valores" , method = RequestMethod.GET)
    public String administracaoDeValoresPage(){
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




    /**
     * Redirects to 403 page
     * @return not authorized page
     */
    @RequestMapping("/403")
    public String notAllowed(){
        return "errors/403";
    }
}



