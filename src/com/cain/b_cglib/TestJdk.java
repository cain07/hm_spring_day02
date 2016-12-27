package com.cain.b_cglib;

import org.junit.Test;

public class TestJdk {
	
	@Test
	public void test01(){
		UserServiceImpl userService = MyBeanFactory.createUserService();
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();

	}

}
