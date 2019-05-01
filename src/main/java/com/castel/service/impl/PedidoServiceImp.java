package com.castel.service.impl;

import com.castel.dao.PedidoDao;
import com.castel.models.*;
import com.castel.service.PedidoService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
    public List<Pedido> listPedidosHome() {
        return this.pedidoDao.listPedidosHome();
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

    @Override
    public void addEndereco(Endereco endereco){ this.pedidoDao.addEndereco(endereco);}
    @Override
    public void removeEndereco(int id){ this.pedidoDao.removeEndereco(id);}
    @Override
    public Endereco getEnderecoById(int id){ return this.pedidoDao.getEnderecoById(id);}


    @Override
    public Integer getTotalPedidosDoDia(){
        return this.pedidoDao.getTotalPedidosDoDia();
    }
    @Override
    public Integer getTotalPedidosEmProducao(){
        return this.pedidoDao.getTotalPedidosEmProducao();
    }
    @Override
    public Integer getTotalPedidosConfirmados(){
        return this.pedidoDao.getTotalPedidosConfirmados();
    }

    @Override
    public void addProblem(Problema problema){
        this.pedidoDao.addProblem(problema);
    }
    @Override
    public Problema getProblemByPedidoId(int pedido_id){
        return this.pedidoDao.getProblemByPedidoId(pedido_id);
    }

    @Override
    public List<Pedido> listPedidosByStatus(int status_id, String filter, int limit){
        return this.pedidoDao.listPedidosByStatus(status_id, filter, limit);
    }
}
