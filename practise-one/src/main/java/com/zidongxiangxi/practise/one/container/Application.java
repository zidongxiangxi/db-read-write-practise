package com.zidongxiangxi.practise.one.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * 项目启动类
 *
 * @author chenxudong
 * @date 2019/05/17
 */
@SpringBootApplication(scanBasePackages = "com.zidongxiangxi.practise.one")
@ImportResource(locations = {"classpath:applicationContext-*.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebEnvironment(true);
        ConfigurableApplicationContext context = app.run(args);
        Runtime.getRuntime().addShutdownHook(new Thread(context::close));
    }
}
