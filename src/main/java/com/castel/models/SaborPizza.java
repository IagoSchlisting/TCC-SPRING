package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SABORPIZZA")
@Repository
public class SaborPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SABORPIZZA_ID")
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private TamanhoSabor tamanhoSabor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SABOR_ID")
    private Sabor sabor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PIZZA_ID")
    private Pizza pizza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TamanhoSabor getTamanhoSabor() {
        return tamanhoSabor;
    }

    public void setTamanhoSabor(TamanhoSabor tamanhoSabor) {
        this.tamanhoSabor = tamanhoSabor;
    }


    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }


    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
