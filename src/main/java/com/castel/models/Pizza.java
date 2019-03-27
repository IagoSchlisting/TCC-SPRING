package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "PIZZA")
@Repository
public class Pizza {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PIZZA_ID")
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private TamanhoPizza tamanhoPizza;

    private SaborPizza sabor1;

    private SaborPizza sabor2;

    private SaborPizza sabor3

    private SaborPizza sabor4;

    private boolean comborda;
}
