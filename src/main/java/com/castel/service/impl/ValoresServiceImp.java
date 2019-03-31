package com.castel.service.impl;

import com.castel.dao.ValoresDao;
import com.castel.models.ValoresAdicionais;
import com.castel.service.ValoresService;

import javax.annotation.Resource;

public class ValoresServiceImp implements ValoresService {

    @Resource
    private ValoresDao valoresDao;

    public void addValores(ValoresAdicionais valoresAdicionais){
        valoresDao.addValores(valoresAdicionais);
    }
    public void updateValores(ValoresAdicionais valoresAdicionais){
        valoresDao.updateValores(valoresAdicionais);
    }
    public ValoresAdicionais getValoresById(int id){
        return valoresDao.getValoresById(id);
    }
    public ValoresAdicionais getFirstLine(){ return valoresDao.getFirstLine();}
}
