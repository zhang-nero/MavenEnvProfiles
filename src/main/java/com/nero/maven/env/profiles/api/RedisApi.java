package com.nero.maven.env.profiles.api;

import com.nero.maven.env.profiles.utils.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nero
 * @since 2018-06-26 17:32
 */
@RestController
@RequestMapping(value = "/redisApi")
public class RedisApi {

    @ApiOperation(value = "设置值", httpMethod = "GET", notes = "设置值")
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public void getUser(@RequestParam String key, @RequestParam String value){
        RedisUtil.set(key, value);
    }

    @ApiOperation(value = "获取值", httpMethod = "GET", notes = "获取值")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getUser(@RequestParam String key){
        return RedisUtil.get(key);
    }
}
