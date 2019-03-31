package com.castel.models;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SABOR")
@Repository
public class Sabor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SABOR_ID")
    private Integer id;

    @Column(unique = true)
    private String sabor;

    @OneToMany(mappedBy = "sabor")
    private List<SaborPizza> saborespizza;

    private Boolean especial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Boolean getEspecial() {
        return especial;
    }

    public void setEspecial(Boolean especial) {
        this.especial = especial;
    }

    public List<SaborPizza> getSaborespizza() {
        return saborespizza;
    }

    public void setSaborespizza(List<SaborPizza> saborespizza) {
        this.saborespizza = saborespizza;
    }
}
