package com.dongck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dongck.pojo.User;

@Configuration
@ComponentScan("com.dongck.*")
public class AppConfig {
	
//	@Bean(name="user")
//	public User initUser(){
//		User user = new User();
//		user.setId(1L);
//		user.setUserName("zhangSan");
//		user.setNote("abc");
//		return user;
//	}
	
	

}
