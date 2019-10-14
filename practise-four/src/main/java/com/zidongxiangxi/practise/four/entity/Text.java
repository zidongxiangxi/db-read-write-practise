package com.zidongxiangxi.practise.four.entity;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cxd on 2019/7/20.
 */
@Data
public class Text implements RowMapper<Text> {
    private Integer id;

    private String content;

    @Override
    public Text mapRow(ResultSet resultSet, int i) throws SQLException {
        Text text = new Text();
        text.setId(resultSet.getInt("id"));
        text.setContent(resultSet.getString("content"));
        return text;
    }
}
