package com.castel.dao.impl;

import com.castel.dao.PedidoDao;
import com.castel.models.Endereco;
import com.castel.models.Item;
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
    public List<Pedido> listPedidos(){
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
        List<Pedido> pedidos = (List<Pedido>) this.getHibernateTemplate().find("from com.castel.models.Pedido where USER_ID = " + user_id + "ORDER BY PEDIDO_ID DESC");
        return pedidos.isEmpty() ? null : pedidos.get(0);
    }
    @Override
    public Item getItemById(int id){ return this.getHibernateTemplate().get(Item.class, id);}
    @Override
    @Transactional
    public void addItem(Item item) { this.getHibernateTemplate().save(item);}
    @Override
    @Transactional
    public void removeItem(int id){ this.getHibernateTemplate().delete(this.getItemById(id));}

    @Override
    @Transactional
    public void addEndereco(Endereco endereco){ this.getHibernateTemplate().save(endereco);}
    @Override
    @Transactional
    public void removeEndereco(int id){ this.getHibernateTemplate().delete(getEnderecoById(id));}
    @Override
    public Endereco getEnderecoById(int id){ return this.getHibernateTemplate().get(Endereco.class, id);}



}
