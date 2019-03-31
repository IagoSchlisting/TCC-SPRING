package com.castel.dao.impl;

import com.castel.dao.PedidoDao;
import com.castel.models.Pedido;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public class PedidoDaoImp extends HibernateDaoSupport implements PedidoDao {



    @Override
    @Transactional
    public void addPedido(Pedido pedido){
        this.getHibernateTemplate().save(pedido);
    }
    @Override
    @Transactional
    public void updatePedido(Pedido pedido){
        this.getHibernateTemplate().update(pedido);
    }
    @Override
    public List<Pedido> listPedidos(int pedido_id){
        return (List<Pedido>) this.getHibernateTemplate().find("from com.castel.models.Pedido");
    }
    @Override
    public Pedido getPedidoById(int id){
        return this.getHibernateTemplate().get(Pedido.class, id);
    }
    @Override
    @Transactional
    public void removePedido(int id){
        this.getHibernateTemplate().delete(this.getPedidoById(id));
    }
    @Override
    public Pedido findLastOrderFromUser(int user_id){
        List<Pedido> pedidos = (List<Pedido>) this.getHibernateTemplate().find("from com.castel.models.Pedido where PEDIDO_ID = (select max(PEDIDO_ID) from com.castel.models.Pedido) and not USER_ID = " + user_id);
        return pedidos.get(0);
    }

}
