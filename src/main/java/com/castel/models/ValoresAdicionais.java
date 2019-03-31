package com.castel.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "VALORES_ADICIONAIS")
@Repository
public class ValoresAdicionais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VALORESADICIONAIS_ID")
    private Integer id;

    private Double valorBaseBroto;

    private Double valorBaseMedia;

    private Double valorBaseGrande;

    private Double valorBaseGigante;

    private Double valorBordaGrande;

    private Double valorBordaGigante;

    private Double valorTeleEntrega;

    private Double valorEspecialBroto1;

    private Double valorEspecialBroto2;

    private Double valorEspecialMedia1;

    private Double valorEspecialMedia2;

    private Double valorEspecialMedia3;

    private Double valorEspecialGrande1;

    private Double valorEspecialGrande2;

    private Double valorEspecialGrande3;

    private Double valorEspecialGrande4;

    private Double valorEspecialGigante1;

    private Double valorEspecialGigante2;

    private Double valorEspecialGigante3;

    private Double valorEspecialGigante4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorBaseBroto() {
        return valorBaseBroto;
    }

    public void setValorBaseBroto(Double valorBaseBroto) {
        this.valorBaseBroto = valorBaseBroto;
    }

    public Double getValorBaseMedia() {
        return valorBaseMedia;
    }

    public void setValorBaseMedia(Double valorBaseMedia) {
        this.valorBaseMedia = valorBaseMedia;
    }

    public Double getValorBaseGrande() {
        return valorBaseGrande;
    }

    public void setValorBaseGrande(Double valorBaseGrande) {
        this.valorBaseGrande = valorBaseGrande;
    }

    public Double getValorBaseGigante() {
        return valorBaseGigante;
    }

    public void setValorBaseGigante(Double valorBaseGigante) {
        this.valorBaseGigante = valorBaseGigante;
    }

    public Double getValorBordaGrande() {
        return valorBordaGrande;
    }

    public void setValorBordaGrande(Double valorBordaGrande) {
        this.valorBordaGrande = valorBordaGrande;
    }

    public Double getValorBordaGigante() {
        return valorBordaGigante;
    }

    public void setValorBordaGigante(Double valorBordaGigante) {
        this.valorBordaGigante = valorBordaGigante;
    }

    public Double getValorTeleEntrega() {
        return valorTeleEntrega;
    }

    public void setValorTeleEntrega(Double valorTeleEntrega) {
        this.valorTeleEntrega = valorTeleEntrega;
    }

    public Double getValorEspecialBroto1() {
        return valorEspecialBroto1;
    }

    public void setValorEspecialBroto1(Double valorEspecialBroto1) {
        this.valorEspecialBroto1 = valorEspecialBroto1;
    }

    public Double getValorEspecialBroto2() {
        return valorEspecialBroto2;
    }

    public void setValorEspecialBroto2(Double valorEspecialBroto2) {
        this.valorEspecialBroto2 = valorEspecialBroto2;
    }

    public Double getValorEspecialMedia1() {
        return valorEspecialMedia1;
    }

    public void setValorEspecialMedia1(Double valorEspecialMedia1) {
        this.valorEspecialMedia1 = valorEspecialMedia1;
    }

    public Double getValorEspecialMedia2() {
        return valorEspecialMedia2;
    }

    public void setValorEspecialMedia2(Double valorEspecialMedia2) {
        this.valorEspecialMedia2 = valorEspecialMedia2;
    }

    public Double getValorEspecialMedia3() {
        return valorEspecialMedia3;
    }

    public void setValorEspecialMedia3(Double valorEspecialMedia3) {
        this.valorEspecialMedia3 = valorEspecialMedia3;
    }

    public Double getValorEspecialGrande1() {
        return valorEspecialGrande1;
    }

    public void setValorEspecialGrande1(Double valorEspecialGrande1) {
        this.valorEspecialGrande1 = valorEspecialGrande1;
    }

    public Double getValorEspecialGrande2() {
        return valorEspecialGrande2;
    }

    public void setValorEspecialGrande2(Double valorEspecialGrande2) {
        this.valorEspecialGrande2 = valorEspecialGrande2;
    }

    public Double getValorEspecialGrande3() {
        return valorEspecialGrande3;
    }

    public void setValorEspecialGrande3(Double valorEspecialGrande3) {
        this.valorEspecialGrande3 = valorEspecialGrande3;
    }

    public Double getValorEspecialGrande4() {
        return valorEspecialGrande4;
    }

    public void setValorEspecialGrande4(Double valorEspecialGrande4) {
        this.valorEspecialGrande4 = valorEspecialGrande4;
    }

    public Double getValorEspecialGigante1() {
        return valorEspecialGigante1;
    }

    public void setValorEspecialGigante1(Double valorEspecialGigante1) {
        this.valorEspecialGigante1 = valorEspecialGigante1;
    }

    public Double getValorEspecialGigante2() {
        return valorEspecialGigante2;
    }

    public void setValorEspecialGigante2(Double valorEspecialGigante2) {
        this.valorEspecialGigante2 = valorEspecialGigante2;
    }

    public Double getValorEspecialGigante3() {
        return valorEspecialGigante3;
    }

    public void setValorEspecialGigante3(Double valorEspecialGigante3) {
        this.valorEspecialGigante3 = valorEspecialGigante3;
    }

    public Double getValorEspecialGigante4() {
        return valorEspecialGigante4;
    }

    public void setValorEspecialGigante4(Double valorEspecialGigante4) {
        this.valorEspecialGigante4 = valorEspecialGigante4;
    }
}
