package com.zidongxiangxi.practise.three.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Created by cxd on 2019/7/20.
 */
@Data
public class Text {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private String content;
}
