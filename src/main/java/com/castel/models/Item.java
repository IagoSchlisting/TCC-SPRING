package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@Repository
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PIZZA_ID")
    private Pizza pizza;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BEBIDA_ID")
    private Bebida bebida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PEDIDO_ID")
    private Pedido pedido;

    private boolean ispizza;

    private Double valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isIspizza() {
        return ispizza;
    }

    public void setIspizza(boolean ispizza) {
        this.ispizza = ispizza;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
