package com.at.guigu.test;

import com.at.guigu.bean.User;
import com.at.guigu.dao.UserDao;
import com.at.guigu.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoImplTest {
    UserDao dao = new UserDaoImpl();
    @Test
    public void test(){
        User user = dao.checkNameAndPassword("admin", "123456");
        System.out.println(user);
    }
    @Test
    public void test2(){
        boolean name = dao.checkName("zfq");
        System.out.println(name);
    }
    @Test
    public void test3(){
        int update = dao.insert("smn", "521", "smn@163.com");
        System.out.println(update);
    }
}
