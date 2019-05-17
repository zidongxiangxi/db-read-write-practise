package com.zidongxiangxi.pratice.one.container;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;

/**
 * druid数据源配置
 *
 * @author chenxudong
 * @date 2019/05/17
 */
@Configuration
public class DruidConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DruidConfig.class);

    @Primary
    @Bean(name = "masterDS")
    public DataSource masterDS(
        @Value("${spring.datasource.driverClassName}") String driver,
        @Value("${spring.datasource.master}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password,
        @Value("${spring.datasource.publickey}") String publicKey) {
        return createDruidDataSource(driver, url, username, password, publicKey);
    }

    @Bean(name = "slaveDS")
    public DataSource slaveDS(
        @Value("${spring.datasource.driverClassName}") String driver,
        @Value("${spring.datasource.slave}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password,
        @Value("${spring.datasource.publickey}") String publicKey) {
        return createDruidDataSource(driver, url, username, password, publicKey);
    }

    /**
     * 当加密有public key 时则调用此方法
     *
     * @param driver 数据库驱动
     * @param url 数据库地址
     * @param username 用户名
     * @param password 密码
     * @param publicKey 公钥
     * @return 数据源
     */
    private DataSource createDruidDataSource(String driver, String url, String username, String password, String publicKey) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        LOGGER.info("durid db password : {}", password);
        druidDataSource.setPassword(password);
        druidDataSource.setConnectionInitSqls(Collections.singletonList("set names utf8mb4;"));
        druidDataSource.setConnectionProperties("config.decrypt=true;config.decrypt.key=" + publicKey);
        try {
            druidDataSource.setFilters("stat, wall,config");
        } catch (SQLException e) {
            LOGGER.error("create druid datasource", e);
        }
        return druidDataSource;
    }
}
