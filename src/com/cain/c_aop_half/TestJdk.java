package com.cain.c_aop_half;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdk {
	
	@Test
	public void test01(){

		//��spring�������
				String xmlPath = "com/cain/c_aop_half/beans.xml";
				ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
				UserService user = (UserService) applicationContext.getBean("proxyServiceId");
				user.addUser();
				user.updateUser();
				user.deleteUser();
	}

}
