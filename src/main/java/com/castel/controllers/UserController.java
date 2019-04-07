package com.castel.controllers;

import com.castel.models.*;
import com.castel.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController extends BaseController{

    @Resource
    private RoleService roleService;


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public RedirectView adicionarUsuario(Model model, WebRequest request, RedirectAttributes redirectAttributes){
        String username = request.getParameter("username");
        String accessLevel = request.getParameter("accessLevel");

        String error = "";
        if(username.isEmpty()){ error = "Username or password cannot be empty!"; }
        if(userAlreadyExists(username)){ error = "Not possible to register the user in the system! Username already exists."; }
        if(!error.isEmpty()){
            redirectAttributes.addFlashAttribute("error", error);
            return new RedirectView("/login");
        }

        try{
            List<Role> roles = giveRoles(accessLevel.equals("1") ? true : false);
            this.createUser(username, "12345", roles);
            redirectAttributes.addFlashAttribute("msg", "Usuário registrado com sucesso!");
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());        }
        return new RedirectView("/administracao-usuarios");
    }


    /**
     * Responsible for saving users in the database.
     * @param username
     * @param password
     */
    private User createUser(String username, String password, List<Role> roles){
        User user = new User();
        user.setEnabled(true);
        user.setUsername(username);
        user.setPassword(passwordEncoder().encode(password));
        user.setRoles(roles);
        userService.addUser(user);
        return user;
    }

    /**
     * Verify if username already exists
     * @param username
     * @return boolean
     */
    public Boolean userAlreadyExists(String username){
        return userService.getUserByName(username).getUsername() != null;
    }


    /**
     * Method responsible for giving roles to new the new user based on their access variable.
     * @param owner
     * @return list of roles
     */
    public List<Role> giveRoles(Boolean owner){
        List<Role> roles = new ArrayList<Role>();
        List<String> roles_string = Arrays.asList("ROLE_USER", "ROLE_OWNER");
        Role new_role;

        for (String role : roles_string) {
            if (roleService.getRoleById(roles_string.indexOf(role) + 1) == null) {
                new_role = new Role();
                new_role.setRole(role);
                roleService.addRole(new_role);
            }
        }
        roles.add(roleService.getRoleById(1));
        if(owner){roles.add(roleService.getRoleById(2));}
        else{ roles.add(roleService.getRoleById(3));}
        return roles;
    }

    /**
     * Method responsible for deleting user
     * @param id
     * @param redirectAttributes
     */
    @RequestMapping("/user/remove/{id}")
    public RedirectView removeUser(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        try{
            userService.removeUser(id);
            redirectAttributes.addFlashAttribute("msg", "Usuário removido com sucesso.");
        }catch (RuntimeException e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return new RedirectView("/administracao-usuarios");
        }
        return new RedirectView("/administracao-usuarios");
    }


    /**
     * Responsible for edit member type users
     * @param model
     * @param request
     * @return success or error message in the add/edit page
     */
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String saveEditedMember(Model model, WebRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");

        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);

        if (username.isEmpty()) {
            model.addAttribute("error", "Username can't be empty!");
            return "add-edit-user";
        }
        if (!new String(user.getUsername()).equals(username)){
            if (userAlreadyExists(username)) {
                model.addAttribute("error", "Not possible to edit member! Username already exists.");
                return "add-edit-user";
            }
        }
        try
        {
            user.setUsername(username);
            userService.updateUser(user);
            model.addAttribute("msg", "Member edited successfully!");
        }
        catch (Exception e){ model.addAttribute("error", e.getMessage()); }
        return "add-edit-user";
    }

    /**
     * Only redirects to the changepass user's page
     * @return changepass page
     */
    @RequestMapping(value = "/changepass", method = RequestMethod.GET)
    public String changePass(){
        return "changepass";
    }

    /**
     * Allows user to change password when needed
     * @param model
     * @param request
     * @return success or error message in the changepass page
     */
    @RequestMapping(value = "/changepass", method = RequestMethod.POST)
    public String changePassdb(Model model, WebRequest request){

        String oldpass = request.getParameter("old_password");
        String newpass = request.getParameter("new_password");
        String confirmpass = request.getParameter("confirm_password");

        if(oldpass.isEmpty() || newpass.isEmpty() || confirmpass.isEmpty()){
            model.addAttribute("error", "Fields can't be empty!");
            return "changepass";
        }

        User principal = this.getPrincipalUser();
        String userpass = principal.getPassword();

        if(!passwordEncoder().matches(oldpass, userpass)){
            model.addAttribute("error", "Current pass doesn't match!");
            return "changepass";
        }

        if(!new String(newpass).equals(confirmpass)){
            model.addAttribute("error", "Passwords doesn't match!");
            return "changepass";
        }

        try{
            principal.setPassword(passwordEncoder().encode(newpass));
            userService.updateUser(principal);
            model.addAttribute("msg", "Password changed successfully!");
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "changepass";
    }


    @RequestMapping(value = "/registraiago" , method = RequestMethod.GET)
    public RedirectView registerIago(){
        List<Role> roles = giveRoles(true);
        User user = new User();
        user.setEnabled(true);
        user.setUsername("iago");
        user.setPassword(passwordEncoder().encode("123"));
        user.setRoles(roles);
        userService.addUser(user);
        return new RedirectView("/login");
    }

}
