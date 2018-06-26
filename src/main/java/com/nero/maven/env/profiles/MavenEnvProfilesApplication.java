package com.nero.maven.env.profiles;

import com.nero.maven.env.profiles.utils.ContextHelper;
import com.nero.maven.env.profiles.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MavenEnvProfilesApplication {

	@Autowired
	private ApplicationContext ac;

	public static void main(String[] args) {
		SpringApplication.run(MavenEnvProfilesApplication.class, args);
	}

	@PostConstruct
	public void init(){
		ContextHelper.setAc(ac);
        RedisUtil.setJedisPool(ContextHelper.getBeanByType(JedisPool.class));
	}
}
