package com.susu.ssm.service;

import com.susu.ssm.pojo.User;

import java.util.List;

public interface UserService
{
    User getUserById(int userId);

    List<User> getUserList();
}
