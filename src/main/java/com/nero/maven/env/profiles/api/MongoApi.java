package com.nero.maven.env.profiles.api;

import com.nero.maven.env.profiles.entities.user.User;
import com.nero.maven.env.profiles.service.MongoService;
import com.nero.maven.env.profiles.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nero
 * @since 2018-07-18 10:40
 */
@RestController
@MessageMapping(value = "/mongoApi")
public class MongoApi {
    @Autowired
    private MongoService mongoService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试写入mongo", httpMethod = "GET", notes = "测试写入mongo")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addTest(){
        List<User> list = userService.getAllUser();
        for (User user: list){
            mongoService.add(user);
        }
    }
}
