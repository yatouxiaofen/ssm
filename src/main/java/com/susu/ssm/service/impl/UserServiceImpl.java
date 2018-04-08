package com.susu.ssm.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.susu.ssm.dao.UserMapper;
import com.susu.ssm.pojo.User;
import com.susu.ssm.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId)
    {
        logger.info("getUserById start,userId="+userId);
        User user = this.userMapper.selectByPrimaryKey(userId);
        logger.info("getUserById end, user info", user.toString());
        return user;
    }

    @Override
    public List<User> getUserList() {
        logger.info("getUserList start ...");
        List<User> userList = this.userMapper.selectUserList();
        logger.info("getUserList end, data size:{}", userList.size());
        return userList;
    }
}
