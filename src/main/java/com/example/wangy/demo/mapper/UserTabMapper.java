package com.example.wangy.demo.mapper;

import com.example.wangy.demo.pojo.UserTab;

public interface UserTabMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTab record);

    int insertSelective(UserTab record);

    UserTab selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTab record);

    int updateByPrimaryKey(UserTab record);
}