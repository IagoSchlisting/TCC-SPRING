package com.castel.dao.impl;

import com.castel.dao.PizzaDao;
import com.castel.models.Pizza;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class PizzaDaoImp extends HibernateDaoSupport implements PizzaDao {

    public void addPizza(Pizza pizza){ this.getHibernateTemplate().save(pizza);}
    public List<Pizza> listPizzas(){ return (List<Pizza>) this.getHibernateTemplate().find("from com.castel.models.Pizza");}
    public Pizza getPizzaById(int id){ return this.getHibernateTemplate().get(Pizza.class, id);}
    public void removePizza(int id){this.getHibernateTemplate().delete(this.getPizzaById(id));}

}
