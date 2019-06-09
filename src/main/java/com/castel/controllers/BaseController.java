package com.castel.controllers;
import com.castel.dto.BebidaDTO;
import com.castel.models.Bebida;
import com.castel.models.User;
import com.castel.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class BaseController {

    @Resource
    protected UserService userService;

    @Resource
    protected ValoresService valoresService;

    @Resource
    protected SaborService saborService;

    @Resource
    protected BebidaService bebidaService;

    @Resource
    protected PedidoService pedidoService;

    /**
     * Get current session user
     * @return object User
     */
    protected User getPrincipalUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByName(authentication.getName());
    }


    public void addBebida(BebidaDTO bebidaDTO){
        Bebida bebida = new Bebida();
        bebida.setBebida(bebidaDTO.getBebida());
        bebida.setValor(bebidaDTO.getValor());
        this.bebidaService.addBebida(bebida);
    }

    /**
     * @return encoder
     */
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
