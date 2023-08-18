package com.example.govalue.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BdConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource1() {
        return DataSourceBuilder.create()
        .driverClassName(dataSourceProperties.getDriverClassName())
        .url(dataSourceProperties.getUrl())
        .username(dataSourceProperties.getUsername())
        .password(dataSourceProperties.getPassword())
        .build();
    }

    @Bean(name = "jdbcTemplace1")
    public JdbcTemplate jdbcTemplate1(@Qualifier("db1") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    // @Bean(name = "db2")
    // public DataSource dataSource2() {
    //     return DataSourceBuilder.create()
    //     .driverClassName("org.postgresql.Driver")
    //     .url("jdbc:postgresql://localhost:5432/postgres")
    //     .username("postgres")
    //     .password("postgres")
    //     .build();
    // }

    // @Bean(name = "jdbcTemplate2")
    // public JdbcTemplate jdbcTemplate2(@Qualifier("db2") DataSource ds) {
    //     return new JdbcTemplate(ds);
    // }

}
