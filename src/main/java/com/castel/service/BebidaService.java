package com.castel.service;

import com.castel.models.Bebida;

import java.util.List;

public interface BebidaService {

    public void addBebida(Bebida bebida);
    public List<Bebida> listBebidas();
    public Bebida getBebidaById(int id);
    public void removeBebida(int id);
    
}
