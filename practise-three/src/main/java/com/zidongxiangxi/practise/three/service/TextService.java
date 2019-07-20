package com.zidongxiangxi.practise.three.service;

import com.zidongxiangxi.practise.three.entity.Text;
import com.zidongxiangxi.practise.three.manager.TextManager;
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

    @Transactional(rollbackFor = Exception.class)
    public Text saveAndGetText(String content) {
        Text text = new Text();
        text.setContent(content);
        textManager.saveText(text);
        return textManager.getById(text.getId());
    }
}
