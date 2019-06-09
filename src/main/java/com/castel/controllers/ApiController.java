package com.castel.controllers;
import com.castel.dto.BebidaDTO;
import com.castel.models.Bebida;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ApiController extends BaseController{

    @RequestMapping(value = "/get/bebidas", method = RequestMethod.GET)
    public List<Bebida> getBebidas(){
        return this.bebidaService.listBebidas();
    }

    @RequestMapping(value = "/post/bebida", method = RequestMethod.POST)
    public String postBebida(@RequestBody String bebidas, HttpServletRequest request){
        String jsonString = request.getParameter("json");
        String result;
        try{
            //this.addBebida(bebidaDTO);
            result = "{'success': 'Bebida inserida com sucesso!'}";
        }catch (Exception e){
            result = "{'error': ' "+ e.getMessage() +" '}";
        }
        return result;
    }
}
