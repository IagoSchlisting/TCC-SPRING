package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BEBIDA")
@Repository
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BEBIDA_ID")
    private Integer id;

    @Column(unique = true)
    private String bebida;

    private Double valor;

//    @ManyToMany(mappedBy = "bebidas", fetch = FetchType.EAGER)
//    private List<Pedido> pedidos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
//
//    public List<Pedido> getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(List<Pedido> pedidos) {
//        this.pedidos = pedidos;
//    }
}
