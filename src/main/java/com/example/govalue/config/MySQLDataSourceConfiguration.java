package com.example.govalue.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLDataSourceConfiguration {

    // @Bean
    // @ConfigurationProperties("spring.datasource.mysql")
    // public DataSourceProperties mySQLDataSourceProperties() {
    //     return new DataSourceProperties();
    // }

    // @Bean
    // public DataSource mySQLDataSource() {
    //     return mySQLDataSourceProperties().initializeDataSourceBuilder().build();
    // }
	
}
