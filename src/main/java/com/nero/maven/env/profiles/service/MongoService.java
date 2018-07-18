package com.nero.maven.env.profiles.service;

import com.nero.maven.env.profiles.entities.user.User;

/**
 * @author Nero
 * @since 2018-07-18 10:38
 */
public interface MongoService {
    void add(User user);
}
