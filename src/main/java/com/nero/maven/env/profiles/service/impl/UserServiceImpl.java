package com.nero.maven.env.profiles.service.impl;

import com.nero.maven.env.profiles.entities.user.User;
import com.nero.maven.env.profiles.persistence.user.UserMapper;
import com.nero.maven.env.profiles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nero
 * @since 2018-06-26 13:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userName) {
        return userMapper.getUser(userName);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
