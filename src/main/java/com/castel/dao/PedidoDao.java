package com.castel.dao;

import com.castel.models.Pedido;

import java.util.List;

public interface PedidoDao {

    public void addPedido(Pedido pedido);
    public void updatePedido(Pedido pedido);
    public List<Pedido> listPedidos(int pedido_id);
    public Pedido getPedidoById(int id);
    public void removePedido(int id);
    public Pedido findLastOrderFromUser(int user_id);

}

