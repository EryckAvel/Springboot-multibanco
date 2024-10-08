package com.eryckavel.MultiBanco.database.dynamic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DataSourceInterceptorDynamic implements HandlerInterceptor {

    private final DataSourceManagerDynamic dataSourceManager;

    public DataSourceInterceptorDynamic(DataSourceManagerDynamic dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String databaseUrl = request.getHeader("X-Database-Url");
        if (databaseUrl != null) {
            DataSourceContextHolderDynamic.setDataSourceUrl(databaseUrl);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        DataSourceContextHolderDynamic.clear();
    }

}
