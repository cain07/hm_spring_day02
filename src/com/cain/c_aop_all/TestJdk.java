package com.cain.c_aop_all;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdk {
	
	@Test
	public void test01(){

		//´ÓspringÈÝÆ÷»ñµÃ
				String xmlPath = "com/cain/c_aop_all/beans.xml";
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
				UserService user = (UserService) applicationContext.getBean("userServiceId");
				user.addUser();
				user.updateUser();
				user.deleteUser();
	}

}
