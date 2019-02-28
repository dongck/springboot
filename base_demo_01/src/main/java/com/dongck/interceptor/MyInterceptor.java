package com.dongck.interceptor;

import java.lang.reflect.InvocationTargetException;

import com.dongck.invoke.Invocation;

public class MyInterceptor implements Interceptor{

	@Override
	public boolean before() {
		System.out.println("before ...");
		return true;
	}

	@Override
	public void after() {
		System.out.println("after ...");
	}

	@Override
	public Object around(Invocation invocation) throws IllegalAccessException, 
			IllegalArgumentException, InvocationTargetException {
		System.out.println("around before ...");
		Object obj = invocation.proceed();
		System.out.println("around after ...");
		return obj;
	}

	@Override
	public void afterReturning() {
		System.out.println("after returning ...");
	}

	@Override
	public void afterThrowing() {
		System.out.println("after Throwing ...");
	}

	@Override
	public boolean useAround() {
		return true;
	}

}
