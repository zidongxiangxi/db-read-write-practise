package com.zidongxiangxi.pratice.one.container;

import com.zidongxiangxi.pratice.one.dao.annotation.Master;
import com.zidongxiangxi.pratice.one.dao.annotation.Slave;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;

/**
 * mybatis扫描配置
 *
 * @author chenxudong
 * @date 2019/05/17
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    private static final String MYBATIS_MAPPER_PACKAGE = "com.zidongxiangxi.pratice.one.dao";


    @Bean
    public MapperScannerConfigurer masterMSC() {
        return createMapperScannerConfigurer("masterSSF", MYBATIS_MAPPER_PACKAGE + ".master", Master.class);
    }

    @Bean
    public MapperScannerConfigurer slaveMSC() {
        return createMapperScannerConfigurer("slaveSSF", MYBATIS_MAPPER_PACKAGE + ".slave", Slave.class);
    }

    private MapperScannerConfigurer createMapperScannerConfigurer(
        String sqlSessionFactoryBeanName,
        String basePackage,
        Class<? extends Annotation> annotationClass) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
        mapperScannerConfigurer.setBasePackage(basePackage);
        mapperScannerConfigurer.setAnnotationClass(annotationClass);
        return mapperScannerConfigurer;
    }
}
