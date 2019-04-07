package com.castel.models;

import org.hibernate.annotations.Cascade;
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

    @Enumerated(EnumType.ORDINAL)
    private StatusPedido statusPedido;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "ENDERECO_ID")
//    private Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
//
//    private Double valorTotal;
//
//    @OneToMany(mappedBy = "pedido")
//    private List<Item> itens;
//
//    @Enumerated(EnumType.ORDINAL)
//    private TipoPagamento tipoPagamento;
//
//    @Enumerated(EnumType.ORDINAL)
//    private Bandeira bandeira;
//
//    private Double troco;


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
//
//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
//
//    public Double getValorTotal() {
//        return valorTotal;
//    }
//
//    public void setValorTotal(Double valorTotal) {
//        this.valorTotal = valorTotal;
//    }
//
//    public TipoPagamento getTipoPagamento() {
//        return tipoPagamento;
//    }
//
//    public void setTipoPagamento(TipoPagamento tipoPagamento) {
//        this.tipoPagamento = tipoPagamento;
//    }
//
//    public Bandeira getBandeira() {
//        return bandeira;
//    }
//
//    public void setBandeira(Bandeira bandeira) {
//        this.bandeira = bandeira;
//    }
//
//    public Double getTroco() {
//        return troco;
//    }
//
//    public void setTroco(Double troco) {
//        this.troco = troco;
//    }
//
//    public List<Item> getItens() {
//        return itens;
//    }
//
//    public void setItens(List<Item> itens) {
//        this.itens = itens;
//    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
