package com.hjc.menu.service.impl;

import com.hjc.menu.persistence.entity.User;
import com.hjc.menu.persistence.mapper.UserMapper;
import com.hjc.menu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
