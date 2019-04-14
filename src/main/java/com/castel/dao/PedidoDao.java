package com.castel.dao;

import com.castel.models.Endereco;
import com.castel.models.Item;
import com.castel.models.Pedido;

import java.util.List;

public interface PedidoDao {

    public void addPedido(Pedido pedido);
    public void updatePedido(Pedido pedido);

    public void addItem(Item item);
    public void removeItem(int id);
    public Item getItemById(int id);

    public void addEndereco(Endereco endereco);
    public void removeEndereco(int id);
    public Endereco getEnderecoById(int id);

    public List<Pedido> listPedidos(int pedido_id);
    public Pedido getPedidoById(int id);
    public void removePedido(int id);
    public Pedido findLastOrderFromUser(int user_id);

}

