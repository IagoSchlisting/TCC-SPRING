package com.castel.service;

import com.castel.models.Endereco;
import com.castel.models.Item;
import com.castel.models.Pedido;

import java.util.List;

public interface PedidoService {

    public void addPedido(Pedido pedido);

    public void addItem(Item item);
    public void removeItem(int id);
    public Item getItemById(int id);

    public void addEndereco(Endereco endereco);
    public void removeEndereco(int id);
    public Endereco getEnderecoById(int id);

    public Pedido findLastOrderFromUser(int user_id);
    public void updatePedido(Pedido pedido);
    public List<Pedido> listPedidos();
    public Pedido getPedidoById(int id);
    public void removePedido(int id);

}
