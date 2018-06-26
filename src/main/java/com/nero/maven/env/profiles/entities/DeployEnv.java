package com.nero.maven.env.profiles.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nero
 * @since 2018-06-26 13:54
 */
@Setter
@Getter
@Configuration
public class DeployEnv {
    @Value(value = "${deploy.env}")
    private String deployEnv;

    public DeployEnv convert(){
        DeployEnv deployEnv = new DeployEnv();
        deployEnv.setDeployEnv(this.deployEnv);
        return deployEnv;
    }
}
