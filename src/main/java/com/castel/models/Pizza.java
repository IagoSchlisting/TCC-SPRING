package com.castel.models;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PIZZA")
@Repository
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PIZZA_ID")
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private TamanhoPizza tamanhoPizza;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Pizza_Sabores",
            joinColumns = { @JoinColumn(name = "PIZZA_ID") },
            inverseJoinColumns = { @JoinColumn(name = "SABORPIZZA_ID") }
    )
    private List<SaborPizza> sabores;

    private boolean comborda;

    @OneToMany(mappedBy = "pizza")
    private List<Item> itens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TamanhoPizza getTamanhoPizza() {
        return tamanhoPizza;
    }

    public void setTamanhoPizza(TamanhoPizza tamanhoPizza) {
        this.tamanhoPizza = tamanhoPizza;
    }

    public List<SaborPizza> getSabores() {
        return sabores;
    }

    public void setSabores(List<SaborPizza> sabores) {
        this.sabores = sabores;
    }

    public boolean isComborda() {
        return comborda;
    }

    public void setComborda(boolean comborda) {
        this.comborda = comborda;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
