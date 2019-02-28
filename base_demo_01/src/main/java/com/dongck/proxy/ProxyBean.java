package com.dongck.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.dongck.interceptor.Interceptor;
import com.dongck.invoke.Invocation;

public class ProxyBean implements InvocationHandler{
	
	private Object target = null;
	
	private Interceptor interceptor = null;
	
	
	public static Object getProxyBean(Object target,Interceptor interceptor){
		ProxyBean proxyBean = new ProxyBean();
		proxyBean.target = target;
		proxyBean.interceptor = interceptor;
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), proxyBean);
		
		return proxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		boolean exceptionFlag = false;
		Invocation invocation = new Invocation(target,method,args);
		
		Object retObj = null;
		
		try{
			if(interceptor.before()){
				retObj = interceptor.around(invocation);
			}else{
				retObj = method.invoke(target, args);
			}
		}catch(Exception e){
			exceptionFlag = true;
		}
		
		interceptor.after();
		if(exceptionFlag){
			interceptor.afterThrowing();
		}else{
			interceptor.afterReturning();
			return retObj;
		}
		return null;
	}

}
