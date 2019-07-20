package com.zidongxiangxi.practise.three.manager;

import com.zidongxiangxi.practise.three.entity.Text;
import com.zidongxiangxi.practise.three.mapper.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cxd on 2019/7/20.
 */
@Component
public class TextManager {
    @Autowired
    private TextMapper textMapper;

    /**
     * 保存text
     *
     * @param text
     * @return
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int saveText(Text text) {
        textMapper.insert(text);
        return text.getId();
    }

    /**
     * 根据id查询text
     *
     * @param id id
     * @return text
     */
    @Transactional(rollbackFor = Exception.class, readOnly = true, propagation = Propagation.SUPPORTS)
    public Text getById(Integer id) {
        return textMapper.selectById(id);
    }
}
