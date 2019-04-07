package com.castel.models;

import org.hibernate.annotations.Cascade;
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
//
//    @OneToMany(mappedBy = "bebida")
//    private List<Item> itens;

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
//    public List<Item> getItens() {
//        return itens;
//    }
//
//    public void setItens(List<Item> itens) {
//        this.itens = itens;
//    }
}
