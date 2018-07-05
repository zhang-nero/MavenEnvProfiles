package com.nero.maven.env.profiles.api;

import com.nero.maven.env.profiles.entities.DeployEnv;
import com.nero.maven.env.profiles.utils.ContextHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nero
 * @since 2018-06-26 13:56
 */
@RestController
@RequestMapping(value = "/envApi")
public class EnvApi {

    @ApiOperation(value = "查看部署环境信息", httpMethod = "GET", notes = "查看环境信息")
    @RequestMapping(value = "/getEnv", method = RequestMethod.GET)
    public DeployEnv getEnv() {
        return ContextHelper.getBeanByType(DeployEnv.class).convert();
    }
}
