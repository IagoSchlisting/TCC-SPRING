package com.castel.dao.impl;

import com.castel.dao.PedidoDao;
import com.castel.models.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public List<Pedido> listPedidosHome(){
        return (List<Pedido>) this.getHibernateTemplate().find("from com.castel.models.Pedido p where STATUSPEDIDO = " + 3 + " and START LIKE '%"+LocalDate.now()+"%'");
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


    @Override
    @Transactional
    public Integer getTotalPedidosDoDia(){
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = (Query) session.createQuery("SELECT COUNT(*) FROM com.castel.models.Pedido WHERE START LIKE '%"+LocalDate.now()+"%'");
        return Integer.valueOf(query.getResultList().get(0).toString());
    }
    @Override
    @Transactional
    public Integer getTotalPedidosEmProducao(){
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = (Query) session.createQuery("SELECT COUNT(*) FROM com.castel.models.Pedido WHERE STATUSPEDIDO = " + 3 + " and START LIKE '%"+LocalDate.now()+"%'");
        return Integer.valueOf(query.getResultList().get(0).toString());
    }
    @Override
    @Transactional
    public Integer getTotalPedidosConfirmados(){
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = (Query) session.createQuery("SELECT COUNT(*) FROM com.castel.models.Pedido WHERE STATUSPEDIDO = " + 4 + " and START LIKE '%"+LocalDate.now()+"%'");
        return Integer.valueOf(query.getResultList().get(0).toString());
    }

    @Override
    @Transactional
    public void addProblem(Problema problema){
        this.getHibernateTemplate().save(problema);
    }

    @Override
    public Problema getProblemByPedidoId(int pedido_id){
        List<Problema> problemas = (List<Problema>) this.getHibernateTemplate().find("from com.castel.models.Problema where PEDIDO_ID = " + pedido_id);
        return problemas.isEmpty() ? null : problemas.get(0);
    }
    @Override
    public List<Pedido> listPedidosByStatus(int status_id, String filter){
        return (List<Pedido>) this.getHibernateTemplate().find("from com.castel.models.Pedido where START LIKE '%"+filter+"%' AND STATUSPEDIDO = " + status_id);
    }


}
