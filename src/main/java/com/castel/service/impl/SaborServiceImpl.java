package com.castel.service.impl;

import com.castel.dao.SaborDao;
import com.castel.models.Sabor;
import com.castel.service.SaborService;

import javax.annotation.Resource;
import java.util.List;

public class SaborServiceImpl implements SaborService {

    @Resource
    private SaborDao saborDao;

    @Override
    public void addSabor(Sabor sabor){
        this.saborDao.addSabor(sabor);
    }

    @Override
    public List<Sabor> listSabores(){
        return this.saborDao.listSabores();
    }

    @Override
    public Sabor getSaborById(int id){
        return this.saborDao.getSaborById(id);
    }

    @Override
    public void removeSabor(int id){
        this.saborDao.removeSabor(id);
    }


}
