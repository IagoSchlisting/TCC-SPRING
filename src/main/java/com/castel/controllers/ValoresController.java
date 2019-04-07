package com.castel.controllers;

import com.castel.models.ValoresAdicionais;
import com.castel.service.ValoresService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

@Controller
public class ValoresController extends BaseController {

    @RequestMapping(value = "/registravalores" , method = RequestMethod.GET)
    public RedirectView registerValues(RedirectAttributes redirectAttributes){

        ValoresAdicionais valoresAdicionais = new ValoresAdicionais();

        try{
            valoresAdicionais.setValorBaseBroto(19.90);
            valoresAdicionais.setValorBaseMedia(39.00);
            valoresAdicionais.setValorBaseGrande(59.00);
            valoresAdicionais.setValorBaseGigante(79.00);
            valoresAdicionais.setValorBordaGrande(6.00);
            valoresAdicionais.setValorBordaGigante(13.00);
            valoresAdicionais.setValorTeleEntrega(5.00);


            valoresAdicionais.setValorEspecialBroto1(20.00);
            valoresAdicionais.setValorEspecialBroto2(10.00);

            valoresAdicionais.setValorEspecialMedia1(27.00);
            valoresAdicionais.setValorEspecialMedia2(13.00);
            valoresAdicionais.setValorEspecialMedia3(9.00);

            valoresAdicionais.setValorEspecialGrande1(48.00);
            valoresAdicionais.setValorEspecialGrande2(24.00);
            valoresAdicionais.setValorEspecialGrande3(16.00);
            valoresAdicionais.setValorEspecialGrande4(12.00);

            valoresAdicionais.setValorEspecialGigante1(72.00);
            valoresAdicionais.setValorEspecialGigante2(36.00);
            valoresAdicionais.setValorEspecialGigante3(24.00);
            valoresAdicionais.setValorEspecialGigante4(18.00);
            this.valoresService.addValores(valoresAdicionais);

            redirectAttributes.addFlashAttribute("msg", "Valores adicionados com sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/login");
    }

    @RequestMapping(value = "/valores/update", method = RequestMethod.POST)
    public RedirectView atualizaValores(RedirectAttributes redirectAttributes, ValoresAdicionais valoresAdicionais){
        try {
            valoresAdicionais.setId(this.valoresService.getFirstLine().getId());
            this.valoresService.updateValores(valoresAdicionais);
            redirectAttributes.addFlashAttribute("msg", "Valores atualizados com sucesso!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return new RedirectView("/administracao-valores");
    }
}
