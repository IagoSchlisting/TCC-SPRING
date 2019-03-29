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

    @ManyToMany(mappedBy = "sabores", fetch = FetchType.EAGER)
    private List<Pizza> pizzas;

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

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
