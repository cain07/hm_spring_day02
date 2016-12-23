package com.cain.a_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

	public static UserService createUserService(){
		//1 目标类
		final UserService userService = new UserServiceImpl();
		//2切面类
		final MyAspect myAspect = new MyAspect();

		UserService proxService = (UserService)Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				userService.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						//前执行
						myAspect.before();
						
						//执行目标类的方法
						Object obj = method.invoke(userService, args);
						
						//后执行
						myAspect.after();
						
						return obj;
					}
				});

		return proxService;

	}
	
	
}
