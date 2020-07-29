package com.option.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateUtils {
    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate jdbcTemplate(){
        if (jdbcTemplate == null){
            jdbcTemplate = createJdbcTemplate();
        }
        return jdbcTemplate;
    }

    private static JdbcTemplate createJdbcTemplate(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        return new JdbcTemplate(dataSource);
    }
}
