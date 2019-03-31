package com.castel.service;

import com.castel.models.ValoresAdicionais;

public interface ValoresService {

    public void addValores(ValoresAdicionais valoresAdicionais);
    public void updateValores(ValoresAdicionais valoresAdicionais);
    public ValoresAdicionais getValoresById(int id);
    
}
