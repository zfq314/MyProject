package com.at.guigu.dao;

import com.at.guigu.bean.User;

public interface UserDao {
    User checkNameAndPassword(String username,String password);
    boolean checkName(String username);
    int insert(String username, String password, String email);
}
