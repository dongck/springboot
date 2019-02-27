package com.dongck.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dongck.pojo.ScopeClass;
import com.dongck.pojo.User;

public class ScopeTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		ScopeClass s1 = ctx.getBean(ScopeClass.class);
		ScopeClass s2 = ctx.getBean(ScopeClass.class);
		
		System.out.println(s1 == s2);

	}

}
