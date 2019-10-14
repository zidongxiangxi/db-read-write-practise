package com.zidongxiangxi.practise.four.manager;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zidongxiangxi.practise.four.entity.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by cxd on 2019/7/20.
 */
@Component
public class TextManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存text
     *
     * @param text
     * @return
     */
    @DS("master")
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int saveText(Text text) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement ps = con.prepareStatement("INSERT  INTO text (content) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, text.getContent());
            return ps;
        };
        int result = jdbcTemplate.update(preparedStatementCreator, keyHolder);
        text.setId(keyHolder.getKey().intValue());
        return result;
    }

    /**
     * 根据id查询text
     *
     * @param id id
     * @return text
     */
    @DS("slave")
    @Transactional(rollbackFor = Exception.class, readOnly = true, propagation = Propagation.SUPPORTS)
    public Text getById(Integer id) {
        return jdbcTemplate.queryForObject("select * from text where id=?", new Text(), id);
    }
}
