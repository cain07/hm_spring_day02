package com.cain.e_jdbctemplate;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cain.d_aspectj.UserService;
import com.cain.e_jdbctemplate.dao.UserDao;
import com.cain.e_jdbctemplate.domain.User;

public class TestDB {

	public static void main(String[] args) {
		//1 创建数据源（连接池） dbcp
		BasicDataSource dataSource = new BasicDataSource();
		// * 基本4项
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ee19_spring_day02");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		//2  创建模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		//3 通过api操作
		jdbcTemplate.update("insert into t_user(username,password) values(?,?);", "tom","998");

	}
	
	@Test
	public void  test01() {
		// 从spring容器获得
		User user = new User();
		user.setId(1);
		user.setPassword("999");
		user.setUsername("djjd");
		String xmlPath = "com/cain/e_jdbctemplate/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserDao userdao = (UserDao) applicationContext.getBean("userDaoId");
		userdao.update(user);
	}
	
	
	@Test
	public void  test02() {
		String xmlPath = "com/cain/e_jdbctemplate/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserDao userdao = (UserDao) applicationContext.getBean("userDaoId");
		List<User> users= userdao.getAllUser();
		for (User user:users) {
			System.out.println(user.toString());
		}
	}
	
}
