package com.castel.dao;

import com.castel.models.Pizza;

import java.util.List;

public interface PizzaDao {

    public void addPizza(Pizza pizza);
    public List<Pizza> listPizzas();
    public Pizza getPizzaById(int id);
    public void removePizza(int id);

}
