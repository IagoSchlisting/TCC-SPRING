package com.castel.service;

import com.castel.models.Pedido;

import java.util.List;

public interface PedidoService {

    public void addPedido(Pedido pedido);
    public Pedido findLastOrderFromUser(int user_id);
    public void updatePedido(Pedido pedido);
    public List<Pedido> listPedidos(int pedido_id);
    public Pedido getPedidoById(int id);
    public void removePedido(int id);

}
