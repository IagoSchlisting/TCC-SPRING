package com.castel.service.impl;

import com.castel.dao.PedidoDao;
import com.castel.models.Item;
import com.castel.models.Pedido;
import com.castel.service.PedidoService;

import javax.annotation.Resource;
import java.util.List;

public class PedidoServiceImp implements PedidoService {

    @Resource
    private PedidoDao pedidoDao;

    @Override
    public void addPedido(Pedido pedido) {
        this.pedidoDao.addPedido(pedido);
    }

    @Override
    public void updatePedido(Pedido pedido) {
        this.pedidoDao.updatePedido(pedido);
    }

    @Override
    public List<Pedido> listPedidos(int pedido_id) {
        return this.pedidoDao.listPedidos(pedido_id);
    }

    @Override
    public Pedido getPedidoById(int id) {
        return this.pedidoDao.getPedidoById(id);
    }

    @Override
    public void removePedido(int id) {
        this.pedidoDao.removePedido(id);
    }

    @Override
    public Pedido findLastOrderFromUser(int user_id) {
        return this.pedidoDao.findLastOrderFromUser(user_id);
    }

    @Override
    public void addItem(Item item) { this.pedidoDao.addItem(item);}
    @Override
    public void removeItem(int id){ this.pedidoDao.removeItem(id);}
    @Override
    public Item getItemById(int id){return this.pedidoDao.getItemById(id);}

}