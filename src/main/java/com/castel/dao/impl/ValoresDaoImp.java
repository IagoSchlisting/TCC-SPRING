package com.castel.dao.impl;

import com.castel.dao.ValoresDao;
import com.castel.models.ValoresAdicionais;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class ValoresDaoImp extends HibernateDaoSupport implements ValoresDao {

    @Override
    @Transactional
    public void addValores(ValoresAdicionais valoresAdicionais){
        this.getHibernateTemplate().save(valoresAdicionais);
    }

    @Override
    @Transactional
    public void updateValores(ValoresAdicionais valoresAdicionais){
        this.getHibernateTemplate().update(valoresAdicionais);
    }
    public ValoresAdicionais getValoresById(int id){
        return this.getHibernateTemplate().get(ValoresAdicionais.class, id);
    }

}
