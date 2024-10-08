package com.eryckavel.MultiBanco.database.routing;

import com.eryckavel.MultiBanco.database.routing.enums.DataSourceEnum;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DataSourceContextHolderRouting {

    private static ThreadLocal<DataSourceEnum> threadLocal = new ThreadLocal<>();

    public DataSourceContextHolderRouting() {
        threadLocal = new ThreadLocal<>();
    }

    public void setBranchContext(DataSourceEnum dataSourceEnum) {
        threadLocal.set(dataSourceEnum);
    }

    public DataSourceEnum getBranchContext() {
        return threadLocal.get();
    }

    public static void clearBranchContext() {
        threadLocal.remove();
    }

}
