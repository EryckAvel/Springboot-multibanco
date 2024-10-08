package com.eryckavel.MultiBanco.database.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.eryckavel.MultiBanco", transactionManagerRef = "transcationManager", entityManagerFactoryRef = "entityManagerFactory")
@DependsOn("dataSourceRouting")
public class DataSourceConfigRouting {

    @Autowired
    private DataSourceRouting dataSourceRouting;
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        return dataSourceRouting;
//    }

//    private DataSource getDefaultDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/default");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("senha");
//        return dataSource;
//    }
//
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(dataSource()).packages("com.eryckavel.MultiBanco.model").build();
//    }
//
//    @Bean(name = "transcationManager")
//    public JpaTransactionManager transactionManager(
//            @Autowired @Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
//        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
//    }

}
