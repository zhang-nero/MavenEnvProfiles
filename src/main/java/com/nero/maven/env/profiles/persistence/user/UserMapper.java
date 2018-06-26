package com.nero.maven.env.profiles.persistence.user;

import com.nero.maven.env.profiles.entities.user.User;

/**
 * @author Nero
 * @since 2018-06-26 11:55
 */
public interface UserMapper {
    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    User getUser(String userName);
}
