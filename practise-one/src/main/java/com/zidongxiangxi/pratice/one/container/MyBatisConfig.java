package com.zidongxiangxi.pratice.one.container;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * mybatis配置
 *
 * @author chenxudong
 * @date 2019/05/17
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    @Qualifier("masterDS")
    private DataSource masterDS;

    @Autowired
    @Qualifier("slaveDS")
    private DataSource slaveDS;

    @Bean(name = "masterSSF")
    public SqlSessionFactory masterSSF() {
        return createSqlSessionFactory(masterDS, "classpath:mybatis/*.xml");
    }

    @Bean(name = "slaveSSF")
    public SqlSessionFactory slaveSSF() {
        return createSqlSessionFactory(slaveDS, "classpath:mybatis/*.xml");
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory masterSSF) {
        return new SqlSessionTemplate(masterSSF);
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(masterDS);
    }

    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource, String mapperLocation) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources(mapperLocation));
            return bean.getObject();
        } catch (Exception e) {
            LOGGER.error("init SqlSessionFactory failed", e);
            throw new RuntimeException(e);
        }
    }
}
