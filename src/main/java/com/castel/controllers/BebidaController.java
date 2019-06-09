package com.castel.controllers;

import com.castel.dto.BebidaDTO;
import com.castel.models.Bebida;
import com.castel.service.BebidaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

@Controller
public class BebidaController extends BaseController{

    @Resource
    private BebidaService bebidaService;

    @RequestMapping(value = "/bebida/add", method = RequestMethod.POST)
    public RedirectView addBebida(BebidaDTO bebidaDTO, RedirectAttributes redirectAttributes){
        try{
           this.addBebida(bebidaDTO);
            redirectAttributes.addFlashAttribute("msg", "Bebida adicionada com Sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return new RedirectView("/banco-de-bebidas");
    }

    @RequestMapping(value = "/bebida/remove/{id}", method = RequestMethod.GET)
    public RedirectView removeBebida(@PathVariable("id") int id, RedirectAttributes redirectAttributes){

        try{
            this.bebidaService.removeBebida(id);
            redirectAttributes.addFlashAttribute("msg", "Bebida removida com Sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/banco-de-bebidas");
    }
}
