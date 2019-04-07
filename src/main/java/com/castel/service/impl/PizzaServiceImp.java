package com.castel.service.impl;

import com.castel.dao.PizzaDao;
import com.castel.models.Pizza;
import com.castel.service.PizzaService;

import javax.annotation.Resource;
import java.util.List;

public class PizzaServiceImp implements PizzaService {

    @Resource
    private PizzaDao pizzaDao;

    public void addPizza(Pizza pizza){ this.pizzaDao.addPizza(pizza);}
    public List<Pizza> listPizzas(){ return this.pizzaDao.listPizzas();}
    public Pizza getPizzaById(int id){ return this.pizzaDao.getPizzaById(id);}
    public void removePizza(int id){this.pizzaDao.removePizza(id);}
}
