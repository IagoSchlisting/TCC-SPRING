package com.castel.service;

import com.castel.models.*;

import java.time.LocalDateTime;
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
    public List<Pedido> listPedidosHome();
    public List<Pedido> listPedidosByStatus(int status_id, String filter, int limit);
    public Pedido getPedidoById(int id);
    public void removePedido(int id);

    public Integer getTotalPedidosDoDia();
    public Integer getTotalPedidosEmProducao();
    public Integer getTotalPedidosConfirmados();

    public void addProblem(Problema problema);
    public Problema getProblemByPedidoId(int pedido_id);

}
