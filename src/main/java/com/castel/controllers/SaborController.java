package com.castel.controllers;

import com.castel.dao.SaborDao;
import com.castel.models.Sabor;
import com.castel.service.SaborService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

@Controller
public class SaborController  extends BaseController {

    @Resource
    private SaborService saborService;

    @RequestMapping(value = "/sabor/add", method = RequestMethod.POST)
    public RedirectView adicionaSabor(WebRequest request, RedirectAttributes redirectAttributes){

        try{
            String nsabor = request.getParameter("sabor");
            Boolean especial = request.getParameter("especial").equals("1") ? true : false;

            Sabor sabor = new Sabor();
            sabor.setSabor(nsabor);
            sabor.setEspecial(especial);
            this.saborService.addSabor(sabor);

            redirectAttributes.addFlashAttribute("msg", "Sabor adicionado com Sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/banco-de-sabores");
    }

    @RequestMapping(value = "/sabor/remove/{id}", method = RequestMethod.GET)
    public RedirectView removeSabor(@PathVariable("id") int id, RedirectAttributes redirectAttributes){

        try{
            this.saborService.removeSabor(id);
            redirectAttributes.addFlashAttribute("msg", "Sabor removido com Sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/banco-de-sabores");
    }
}
