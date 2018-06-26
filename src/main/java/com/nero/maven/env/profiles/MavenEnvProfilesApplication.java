package com.nero.maven.env.profiles;

import com.nero.maven.env.profiles.utils.ContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MavenEnvProfilesApplication {

	@Autowired
	private ApplicationContext ac;

	public static void main(String[] args) {
		SpringApplication.run(MavenEnvProfilesApplication.class, args);
	}

	@PostConstruct
	public void initApplicatContext(){
		ContextHelper.setAc(ac);
	}
}
