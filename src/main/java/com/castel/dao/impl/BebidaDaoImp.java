package com.castel.dao.impl;

import com.castel.dao.BebidaDao;
import com.castel.models.Bebida;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BebidaDaoImp extends HibernateDaoSupport implements BebidaDao {


    @Override
    @Transactional
    public void addBebida(Bebida bebida){
        getHibernateTemplate().save(bebida);
    }

    @Override
    public List<Bebida> listBebidas(){
        return (List<Bebida>) getHibernateTemplate().find("from com.castel.models.Bebida");

    }

    @Override
    public Bebida getBebidaById(int id){
        Bebida bebida = getHibernateTemplate().get(Bebida.class, id);
        return bebida;
    }

    @Override
    @Transactional
    public void removeBebida(int id){
        Bebida bebida = this.getBebidaById(id);
        this.getHibernateTemplate().delete(bebida);
    }
    
}
