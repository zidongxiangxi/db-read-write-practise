package com.zidongxiangxi.practise.four.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zidongxiangxi.practise.four.entity.Text;
import com.zidongxiangxi.practise.four.manager.TextManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cxd on 2019/7/20.
 */
@Service
public class TextService {
    @Autowired
    private TextManager textManager;

//    @DS("slave")
//    @Transactional(rollbackFor = Exception.class)
    public Text saveAndGetText(String content) {
        Text text = new Text();
        text.setContent(content);
        textManager.saveText(text);
        return textManager.getById(text.getId());
    }
}
