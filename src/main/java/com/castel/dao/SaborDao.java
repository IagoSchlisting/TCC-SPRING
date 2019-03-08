package com.castel.dao;

import com.castel.models.Sabor;

import java.util.List;

public interface SaborDao {

    public void addSabor(Sabor sabor);
    public List<Sabor> listSabores();
    public Sabor getSaborById(int id);
    public void removeSabor(int id);

}
