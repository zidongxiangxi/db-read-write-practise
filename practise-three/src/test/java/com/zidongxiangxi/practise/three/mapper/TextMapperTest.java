package com.zidongxiangxi.practise.three.mapper;

import com.zidongxiangxi.practise.three.BaseTest;
import com.zidongxiangxi.practise.three.entity.Text;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by cxd on 2019/7/20.
 */
public class TextMapperTest extends BaseTest {
    @Resource
    private TextMapper mapper;

    @Test
    public void testGet() {
        Text text = mapper.selectById(1L);
        Assert.assertNotNull(text);
    }
}
