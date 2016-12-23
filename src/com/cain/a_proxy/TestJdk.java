package com.cain.a_proxy;

import org.junit.Test;

public class TestJdk {
	
	@Test
	public void test01(){
		UserService userService = MyBeanFactory.createUserService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();

	}

}
