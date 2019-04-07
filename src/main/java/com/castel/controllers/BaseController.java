package com.castel.controllers;
import com.castel.models.User;
import com.castel.service.BebidaService;
import com.castel.service.SaborService;
import com.castel.service.UserService;
import com.castel.service.ValoresService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

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

    /**
     * Get current session user
     * @return object User
     */
    protected User getPrincipalUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByName(authentication.getName());
    }

    /**
     * @return encoder
     */
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
