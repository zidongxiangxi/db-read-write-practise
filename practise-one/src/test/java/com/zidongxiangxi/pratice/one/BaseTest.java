package com.zidongxiangxi.pratice.one;

import com.zidongxiangxi.pratice.one.container.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This is Description
 *
 * @author chenxudong
 * @date 2019/05/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration
public abstract class BaseTest {
}
