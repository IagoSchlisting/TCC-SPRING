package com.castel.dao;

import com.castel.models.ValoresAdicionais;

import java.util.List;

public interface ValoresDao {

    public void addValores(ValoresAdicionais valoresAdicionais);
    public void updateValores(ValoresAdicionais valoresAdicionais);
    public ValoresAdicionais getValoresById(int id);
    public ValoresAdicionais getFirstLine();
}
