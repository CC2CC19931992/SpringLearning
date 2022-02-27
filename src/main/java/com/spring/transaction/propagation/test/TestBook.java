package com.spring.transaction.propagation.test;

import com.spring.transaction.propagation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XXXX
 *
 * @author tc
 * @date 2021/11/30
 */
public class TestBook {

    @Test
    public void testAccount(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.reduceMoney();
    }
}
