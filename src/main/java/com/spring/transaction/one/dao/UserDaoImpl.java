package com.spring.transaction.one.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * XXXX
 *
 * @author tc
 * @date 2021/11/30
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //lucy少100
    @Override
    public void reduceMoney() {
        String sql = "update account set money=money-? where user_name=?";
        jdbcTemplate.update(sql,100,"lucy");
    }

    //mary多100
    @Override
    public void addMoney() {
        String sql = "update account set money=money+? where user_name=?";
        jdbcTemplate.update(sql,100,"mary");
    }
}
