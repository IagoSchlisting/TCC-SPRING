package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "PROBLEMA")
@Repository
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROBLEMA_ID")
    private Integer id;

    @OneToOne
    private Pedido pedido;

    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
