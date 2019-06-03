package com.zidongxiangxi.practise.two.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 目标数据源注解
 *
 * @author chenxudong
 * @date 2019/06/03
 */
@Target({ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
    String DATA_SOURCE_MASTER = "master";
    String DATA_SOURCE_SLAVE = "slave";

    String value();
}
