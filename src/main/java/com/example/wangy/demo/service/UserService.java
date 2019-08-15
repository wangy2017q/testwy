package com.example.wangy.demo.service;

import com.example.wangy.demo.pojo.UserTab;

public interface UserService {
    int addUser(UserTab userTab);
    UserTab getUser(int id);
    int updateUser(UserTab userTab);
    boolean updateAndInsertUser(UserTab userTabParam1,UserTab userTabParam2);
}
