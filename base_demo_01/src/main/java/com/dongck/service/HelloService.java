package com.dongck.service;

import com.dongck.impl.IHello;

public class HelloService implements IHello{

	@Override
	public void sayHello(String name) {
		
		if(name == null || name.trim() == ""){
			throw new RuntimeException("sayHello param name is null");
		}
		System.out.println("hello " + name);
	}

}
