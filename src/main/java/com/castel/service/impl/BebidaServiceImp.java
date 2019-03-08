package com.castel.service.impl;

import com.castel.dao.BebidaDao;
import com.castel.models.Bebida;
import com.castel.service.BebidaService;

import javax.annotation.Resource;
import java.util.List;

public class BebidaServiceImp implements BebidaService {

    @Resource
    private BebidaDao bebidaDao;

    @Override
    public void addBebida(Bebida bebida){
        this.bebidaDao.addBebida(bebida);
    }

    @Override
    public List<Bebida> listBebidas(){
        return this.bebidaDao.listBebidas();
    }

    @Override
    public Bebida getBebidaById(int id){
        return this.bebidaDao.getBebidaById(id);
    }

    @Override
    public void removeBebida(int id){
        this.bebidaDao.removeBebida(id);
    }
}
