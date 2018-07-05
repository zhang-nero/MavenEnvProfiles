package com.nero.maven.env.profiles.api;

import com.nero.maven.env.profiles.vo.ApiResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nero
 * @since 2018-07-04 19:45
 */
@RestController
@RequestMapping(value = "/websocket")
public class WebsocketApi {

    @MessageMapping(value = "/welcome")
    @SendTo(value = "/queue/getResponse")
    public ApiResponse websocketTest(String name){
        System.out.println(name);
        return ApiResponse.success();
    }
}
