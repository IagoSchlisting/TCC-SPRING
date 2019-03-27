package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "SABORPIZZA")
@Repository
public class SaborPizza {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SABORPIZZA_ID")
    private Integer id;

    private TamanhoSabor tamanhoSabor;

    private Sabor sabor;

}
