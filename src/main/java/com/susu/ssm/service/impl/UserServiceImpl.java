package com.susu.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.susu.ssm.dao.UserMapper;
import com.susu.ssm.pojo.User;
import com.susu.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId)
    {
        return this.userMapper.selectByPrimaryKey(userId);
    }
    
}
