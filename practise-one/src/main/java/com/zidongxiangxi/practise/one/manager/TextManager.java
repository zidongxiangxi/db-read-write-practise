package com.zidongxiangxi.practise.one.manager;

import com.zidongxiangxi.practise.one.entity.Text;
import com.zidongxiangxi.practise.one.dao.master.TextMapper;
import com.zidongxiangxi.practise.one.dao.slave.TextSlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional(rollbackFor = Exception.class)
    public int saveText(Text text) {
        textMapper.insertSelective(text);
        return text.getId();
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true, propagation = Propagation.SUPPORTS)
    public Text getById(Integer id) {
        return textSlaveMapper.getById(id);
    }
}
