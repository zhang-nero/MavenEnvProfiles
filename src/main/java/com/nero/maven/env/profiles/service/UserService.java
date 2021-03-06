package com.nero.maven.env.profiles.service;

import com.nero.maven.env.profiles.entities.user.User;

import java.util.List;

/**
 * @author Nero
 * @since 2018-06-26 13:20
 */
public interface UserService {
    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User getUser(String userName);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();
}
