package com.zidongxiangxi.practise.two.manager;

import com.zidongxiangxi.practise.two.container.TargetDataSource;
import com.zidongxiangxi.practise.two.dao.TextMapper;
import com.zidongxiangxi.practise.two.entity.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Text的manager层
 *
 * @author chenxudong
 * @date 2019/06/03
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
    @TargetDataSource(TargetDataSource.DATA_SOURCE_MASTER)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int saveText(Text text) {
        textMapper.insertSelective(text);
        return text.getId();
    }

    /**
     * 根据id查询text
     *
     * @param id id
     * @return text
     */
    @TargetDataSource(TargetDataSource.DATA_SOURCE_SLAVE)
    @Transactional(rollbackFor = Exception.class, readOnly = true, propagation = Propagation.SUPPORTS)
    public Text getById(Integer id) {
        return textMapper.selectByPrimaryKey(id);
    }
}
