package com.zidongxiangxi.practise.two.service;

import com.zidongxiangxi.practise.two.BaseTest;
import com.zidongxiangxi.practise.two.entity.Text;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is Description
 *
 * @author chenxudong
 * @date 2019/06/03
 */
public class TextServiceTest extends BaseTest {
    @Autowired
    private TextService textService;

    @Test
    public void testSaveAndGet() {
        Text text = textService.saveAndGetText("888");
        Assert.assertNotNull(text);
    }
}
