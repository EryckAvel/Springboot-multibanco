package com.eryckavel.MultiBanco.database.dynamic;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource{

    private final DataSourceManagerDynamic dataSourceManager;

    @Autowired
    public DynamicRoutingDataSource(DataSourceManagerDynamic dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
        setTargetDataSources(new HashMap<>());
        setDefaultTargetDataSource(dataSourceManager.getDataSource("defaultDataSourceUrl"));
        afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolderDynamic.getDataSourceUrl();
    }
    @Override
    protected DataSource determineTargetDataSource() {
        String dataSourceUrl = (String) determineCurrentLookupKey();
        if (dataSourceUrl != null) {
            return dataSourceManager.getDataSource(dataSourceUrl);
        }else {
            return dataSourceManager.getDataSource("default");
        }
    }

}
