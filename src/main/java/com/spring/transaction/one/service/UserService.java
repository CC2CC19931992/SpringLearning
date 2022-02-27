package com.spring.transaction.one.service;

import com.spring.transaction.one.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * XXXX
 *
 * @author tc
 * @date 2021/11/30
 */
@Service

public class UserService {

    @Autowired
    private UserDao userDao;

    //转账的方法
    @Transactional
    public void accountMoney(){
//        try{
            //开启事务


            //进行业务操作
            userDao.reduceMoney();

            int i = 10/0;

            userDao.addMoney();

            //没有发生异常 提交事务

//        }catch (Exception ex){
//            //发生异常 回滚事务
//
//        }finally {
//
//        }

    }
}
