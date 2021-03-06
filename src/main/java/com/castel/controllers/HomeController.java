package com.castel.controllers;
import com.castel.models.Role;
import com.castel.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;

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

        for (Role role: principal.getRoles()){
            if(new String(role.getRole()).equals("ROLE_OWNER") || new String(role.getRole()).equals("ROLE_MEMBER")){
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

    /**
     * Redirects to 403 page
     * @return not authorized page
     */
    @RequestMapping("/403")
    public String notAllowed(){
        return "errors/403";
    }
}
