package com.dongck.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dongck.pojo.ScopeClass;

public class ProfileTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		String s = (String) ctx.getBean("env");
		
		System.out.println(s);


	}

}
