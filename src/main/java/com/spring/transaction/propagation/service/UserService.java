package com.spring.transaction.propagation.service;

import com.spring.transaction.propagation.dao.UserDao;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    //因为同一个类里的两个方法都加了事务标记，当两个方法发生嵌套调用(如A调用B) 那么要使事务B的事务注解起作用，
    // 则需要在自己类里注入自己。这样就是不同的对象中进行事务传播调用了
    @Autowired
    private UserService userService;

    //花钱
    @Transactional(propagation = Propagation.REQUIRED)
    public void reduceMoney() {
        userDao.reduceMoney();
        try {
            userService.addMoney();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //赚钱
    @Transactional(propagation = Propagation.NEVER)
    public void addMoney() {
        userDao.addMoney();
        //int i = 10/0;
    }
}
