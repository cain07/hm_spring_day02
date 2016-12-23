package com.cain.a_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

	public static UserService createUserService(){
		//1 Ŀ����
		final UserService userService = new UserServiceImpl();
		//2������
		final MyAspect myAspect = new MyAspect();

		UserService proxService = (UserService)Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				userService.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						//ǰִ��
						myAspect.before();
						
						//ִ��Ŀ����ķ���
						Object obj = method.invoke(userService, args);
						
						//��ִ��
						myAspect.after();
						
						return obj;
					}
				});

		return proxService;

	}
	
	
}
