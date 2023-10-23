package com.example.idenbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
public class DataBaseConfig {
    @Bean
    protected DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/idenBotDb");
        dataSource.setUsername("root");
        dataSource.setPassword("mozgorez2");

        return dataSource;
    }
}
