package com.zidongxiangxi.practise.one.service;

import com.zidongxiangxi.practise.one.entity.Text;
import com.zidongxiangxi.practise.one.manager.TextManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * text的Service层
 *
 * @author chenxudong
 * @date 2019/06/03
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
