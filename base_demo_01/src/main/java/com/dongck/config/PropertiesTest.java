package com.dongck.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dongck.pojo.User;

public class PropertiesTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		User user = ctx.getBean(User.class);
		System.out.println(user.getName());
	}

}
