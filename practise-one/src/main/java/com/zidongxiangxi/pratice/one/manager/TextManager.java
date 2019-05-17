package com.zidongxiangxi.pratice.one.manager;

import com.zidongxiangxi.pratice.one.dao.master.TextMapper;
import com.zidongxiangxi.pratice.one.dao.slave.TextSlaveMapper;
import com.zidongxiangxi.pratice.one.entity.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Text的manager层
 *
 * @author chenxudong
 * @date 2019/05/17
 */
@Service
public class TextManager {
    @Autowired
    private TextMapper textMapper;

    @Autowired
    private TextSlaveMapper textSlaveMapper;

    public int saveText(Text text) {
        return textMapper.insertSelective(text);
    }

    public Text getById(Integer id) {
        return textSlaveMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Text saveAndGetText(String content) {
        Text text = new Text();
        text.setContent(content);
        textMapper.insertSelective(text);
        return textSlaveMapper.getById(text.getId());
    }
}
