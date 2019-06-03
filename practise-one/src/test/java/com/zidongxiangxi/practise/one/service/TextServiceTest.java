package com.zidongxiangxi.practise.one.service;

import com.zidongxiangxi.practise.one.BaseTest;
import com.zidongxiangxi.practise.one.entity.Text;
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
        Text text = textService.saveAndGetText("777");
        Assert.assertNotNull(text);
    }
}
