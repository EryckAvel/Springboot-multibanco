package com.eryckavel.MultiBanco.database.dynamic;

public class DataSourceContextHolderDynamic {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSourceUrl(String url) {
        contextHolder.set(url);
    }

    public static String getDataSourceUrl() {
        return contextHolder.get();
    }

    public static void clear() {
        contextHolder.remove();
    }

}
