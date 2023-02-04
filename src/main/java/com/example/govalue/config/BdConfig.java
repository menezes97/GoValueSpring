package com.example.govalue.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BdConfig {

    // @Bean
    // public JdbcTemplate mySQLJdbcTemplate(@Qualifier("mySQLDataSource") DataSource dataSource) {
    //     return new JdbcTemplate(dataSource);
    // }

    // @Bean
    // @ConfigurationProperties(prefix="spring.secondatasource")
    // public DataSource secondaryDataSource() {
    //     return DataSourceBuilder.create().build();
    // }
	
}
