package com.eryckavel.MultiBanco.database.routing;

import com.eryckavel.MultiBanco.database.routing.enums.DataSourceEnum;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSourceRouting extends AbstractRoutingDataSource {

    private final DataSourceContextHolderRouting dataSourceContextHolder;

    public DataSourceRouting(DataSourceContextHolderRouting dataSourceContextHolder) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.TELLES, dataSourceTelles());
        dataSourceMap.put(DataSourceEnum.TIAGO, dataSourceTiago());
        dataSourceMap.put(DataSourceEnum.DLUCA, dataSourceDluca());
        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(dataSourceDefault());
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContextHolder.getBranchContext();
    }

    public DataSource dataSourceDefault() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/default");
        dataSource.setUsername("postgres");
        dataSource.setPassword("senha");
        return dataSource;
    }


    public DataSource dataSourceTelles() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://192.168.30.16:5432/brazil");
        dataSource.setUsername("postgres");
        dataSource.setPassword("senha");
        return dataSource;
    }

    public DataSource dataSourceTiago() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/argentina");
        dataSource.setUsername("postgres");
        dataSource.setPassword("L@gtech1100");
        return dataSource;
    }

    public DataSource dataSourceDluca() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/uruguai");
        dataSource.setUsername("postgres");
        dataSource.setPassword("L@gtech1100");
        return dataSource;
    }

}
