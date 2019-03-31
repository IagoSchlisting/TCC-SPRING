package com.castel.service;

import com.castel.models.User;
import com.castel.models.ValoresAdicionais;

import java.util.List;

public interface ValoresService {

    public void addValores(ValoresAdicionais valoresAdicionais);
    public void updateValores(ValoresAdicionais valoresAdicionais);
    public ValoresAdicionais getValoresById(int id);
    public ValoresAdicionais getFirstLine();
}
