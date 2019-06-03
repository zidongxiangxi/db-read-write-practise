package com.zidongxiangxi.practise.one.dao.slave;

import com.zidongxiangxi.practise.one.dao.annotation.Slave;
import com.zidongxiangxi.practise.one.entity.Text;

/**
 * text表从库mapper
 *
 * @author chenxudong
 * @date 2019/05/17
 */
@Slave
public interface TextSlaveMapper {
    Text getById(Integer id);
}