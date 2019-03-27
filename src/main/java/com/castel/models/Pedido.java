package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@Repository
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PEDIDO_ID")
    private Integer id;

    private String nomeCliente;

    private String telefone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ENDERECO_ID")
    private Endereco endereco;

    private Double valorTotal;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Pedido_Pizzas",
            joinColumns = { @JoinColumn(name = "PEDIDO_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PIZZA_ID") }
    )
    private List<Pizza> pizza;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Pedido_Bebidas",
            joinColumns = { @JoinColumn(name = "PEDIDO_ID") },
            inverseJoinColumns = { @JoinColumn(name = "BEBIDA_ID") }
    )
    private List<Bebida> bebidas;

    @Enumerated(EnumType.ORDINAL)
    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.ORDINAL)
    private Bandeira bandeira;

    private Double troco;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Pizza> getPizza() {
        return pizza;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }
}
