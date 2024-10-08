package com.eryckavel.MultiBanco.config;

import com.eryckavel.MultiBanco.database.dynamic.DataSourceInterceptorDynamic;
import com.eryckavel.MultiBanco.database.dynamic.DataSourceManagerDynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final DataSourceManagerDynamic dataSourceManager;

    public WebConfig(DataSourceManagerDynamic dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DataSourceInterceptorDynamic(dataSourceManager));
    }

}
