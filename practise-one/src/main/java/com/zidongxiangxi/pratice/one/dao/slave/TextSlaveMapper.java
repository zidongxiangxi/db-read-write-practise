package com.zidongxiangxi.pratice.one.dao.slave;

import com.zidongxiangxi.pratice.one.dao.annotation.Slave;
import com.zidongxiangxi.pratice.one.entity.Text;

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