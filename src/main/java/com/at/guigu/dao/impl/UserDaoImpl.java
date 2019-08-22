package com.at.guigu.dao.impl;

import com.at.guigu.bean.User;
import com.at.guigu.dao.BaseDao;
import com.at.guigu.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao{
    @Override
    public User checkNameAndPassword(String username, String password) {
        User bean = getBean("select id,username,password,email from users where username = ? and password = ?", username, password);
        return bean;
    }

    @Override
    public boolean checkName(String username) {
        User bean = getBean("select id,username,password,email from users where username = ?", username);
        return bean == null;
    }

    @Override
    public int insert(String username, String password, String email) {
        int update = update("insert into users(username,password,email) values(?,?,?)", username, password, email);
        return update;
    }
}
