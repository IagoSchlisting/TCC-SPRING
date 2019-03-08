package com.castel.service;

import com.castel.models.Sabor;

import java.util.List;

public interface SaborService {

    public void addSabor(Sabor sabor);
    public List<Sabor> listSabores();
    public Sabor getSaborById(int id);
    public void removeSabor(int id);

}


