package com.eryckavel.MultiBanco.utils;

import com.eryckavel.MultiBanco.database.routing.DataSourceContextHolderRouting;
import com.eryckavel.MultiBanco.database.routing.enums.DataSourceEnum;

import org.springframework.beans.factory.annotation.Autowired;

public class ControllerUtils {

    @Autowired
    private DataSourceContextHolderRouting sourceContextHolder;

    public void gerarConexaoViaRota(String rota){
        DataSourceEnum dataSource = DataSourceEnum.valueOf(rota.toUpperCase());
        sourceContextHolder.setBranchContext(dataSource);
    }

}
