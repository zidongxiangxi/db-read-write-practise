package com.zidongxiangxi.practise.three.service;

import com.zidongxiangxi.practise.three.BaseTest;
import com.zidongxiangxi.practise.three.entity.Text;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cxd on 2019/7/20.
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
