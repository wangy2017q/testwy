package com.example.wangy.demo.service.impl;

import com.example.wangy.demo.mapper.UserTabMapper;
import com.example.wangy.demo.pojo.UserTab;
import com.example.wangy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * Description
 * @author 
 * @param 
 * @createDate  
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserTabMapper userTabMapper;

    @Override
    public int addUser(UserTab userTab) {
        return userTabMapper.insertSelective(userTab);
    }

    @Override
    public UserTab getUser(int id) {
        return userTabMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(UserTab userTab) {
        return userTabMapper.updateByPrimaryKeySelective(userTab);
    }
/**
 * Description
 * @author
 * @param userTabParam1
 * @param userTabParam2
 * @createDate  
 **/
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateAndInsertUser(UserTab userTabParam1, UserTab userTabParam2) {
        int i = this.updateUser(userTabParam1);
        int i1 = this.addUser(userTabParam2);
        return  i > 0 && i1  > 0;
    }
}
