package com.eryckavel.MultiBanco.database.dynamic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSourceManagerDynamic {

    private final Map<String, DataSource> dataSources = new ConcurrentHashMap<>();

    public DataSource getDataSource(String url) {
        return dataSources.computeIfAbsent(url, this::createDataSource);
    }

    private DataSource createDataSource(String url) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/" + url);
        dataSource.setUsername("postgres");
        dataSource.setPassword("senha");
        return dataSource;
    }

}
