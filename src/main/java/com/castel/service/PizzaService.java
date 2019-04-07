package com.castel.service;

import com.castel.models.Pizza;

import java.util.List;

public interface PizzaService {

    public void addPizza(Pizza pizza);
    public List<Pizza> listPizzas();
    public Pizza getPizzaById(int id);
    public void removePizza(int id);

}
