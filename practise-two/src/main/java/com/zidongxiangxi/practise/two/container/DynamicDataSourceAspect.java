package com.zidongxiangxi.practise.two.container;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 动态数据源切面
 * order=-10 保证该AOP在@Transactional之前执行
 *
 * @author chenxudong
 * @date 2019/06/03
 */
@Aspect
@Order(-10)
@Component
public class DynamicDataSourceAspect {
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource) throws Throwable {
        String dataSource = targetDataSource.value();
        if (!DynamicDataSourceContextHolder.containsDataSource(dataSource)) {
            System.err.println("数据源[{}]不存在，使用默认数据源 > {}" + targetDataSource.value() + point.getSignature());
        } else {
            System.out.println("Use DataSource : {} > {}" + targetDataSource.value() + point.getSignature());
            DynamicDataSourceContextHolder.setDataSource(targetDataSource.value());
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        System.out.println("Revert DataSource : {} > {}" + targetDataSource.value() + point.getSignature());
        DynamicDataSourceContextHolder.clearDataSource();

    }
}
