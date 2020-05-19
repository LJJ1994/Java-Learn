package com.itheima.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LJJ
 * @Program: mybatis-day01-define
 * @Description: 自定义mybatis的配置类
 * @Create: 2020-05-08 01:52:52
 * @Modified By:
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public Map<String, Mapper> getMappers(){
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers){
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
