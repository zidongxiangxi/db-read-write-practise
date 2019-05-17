package com.zidongxiangxi.pratice.one.manager;

import com.zidongxiangxi.pratice.one.BaseTest;
import com.zidongxiangxi.pratice.one.entity.Text;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TextManager测试类
 *
 * @author chenxudong
 * @date 2019/05/17
 */
public class TextManagerTest extends BaseTest {
    @Autowired
    private TextManager textManager;

    @Test
    public void testSaveText() {
        Text text = new Text();
        text.setContent("666");
        int effectRows = textManager.saveText(text);
        Assert.assertTrue(effectRows > 0);
    }

    @Test
    public void testGetById() {
        Text text = textManager.getById(1);
        Assert.assertNotNull(text);
    }

    @Test
    public void testSaveAndGet() {
        Text text = textManager.saveAndGetText("777");
        Assert.assertNotNull(text);
    }
}
