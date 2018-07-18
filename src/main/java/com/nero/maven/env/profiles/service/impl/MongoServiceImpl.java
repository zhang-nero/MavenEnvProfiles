package com.nero.maven.env.profiles.service.impl;

import com.nero.maven.env.profiles.entities.user.User;
import com.nero.maven.env.profiles.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Nero
 * @since 2018-07-18 10:38
 */
@Service
public class MongoServiceImpl implements MongoService {

    private static final String collectionName = "user";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(User user) {
        mongoTemplate.insert(user, collectionName);
    }
}
