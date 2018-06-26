package com.nero.maven.env.profiles.api;

import com.nero.maven.env.profiles.entities.user.User;
import com.nero.maven.env.profiles.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nero
 * @since 2018-06-26 13:14
 */
@RestController
@RequestMapping(value = "/userApi")
public class UserApi {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据用户名查找用户", httpMethod = "GET", notes = "根据用户名查找用户")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam String userName){
        return userService.getUser(userName);
    }
}
