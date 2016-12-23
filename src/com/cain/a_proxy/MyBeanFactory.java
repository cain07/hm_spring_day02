package com.cain.a_proxy;

public class MyBeanFactory {

	public static UserService createUserService(){
		return new UserServiceImpl();
	}
	
	
}
