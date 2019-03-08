package com.castel.dao.impl;

import com.castel.dao.SaborDao;
import com.castel.models.Sabor;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SaborDaoImpl extends HibernateDaoSupport implements SaborDao {

    @Override
    @Transactional
    public void addSabor(Sabor sabor){
        getHibernateTemplate().save(sabor);
    }

    @Override
    public List<Sabor> listSabores(){
        return (List<Sabor>) getHibernateTemplate().find("from com.castel.models.Sabor");

    }

    @Override
    public Sabor getSaborById(int id){
        Sabor sabor = getHibernateTemplate().get(Sabor.class, id);
        return sabor;
    }

    @Override
    @Transactional
    public void removeSabor(int id){
        Sabor sabor = this.getSaborById(id);
        this.getHibernateTemplate().delete(sabor);
    }


}
