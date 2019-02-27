package com.dongck.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileBean {
	
	@Bean(name="env")
	@Profile("dev")
	public String getDevEnv(){
		return "dev";
	}
	
	@Bean(name="env")
	@Profile("test")
	public String getTestEnv(){
		return "test";
	}

}
