package com.cain.e_jdbctemplate.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cain.e_jdbctemplate.domain.User;

public class UserDao extends JdbcDaoSupport{


	public void update(User user){
		
		String sql = "update t_user set username=?,password=? where id=?";
		Object[] args = {user.getUsername(),user.getPassword(),user.getId()};
		this.getJdbcTemplate().update(sql, args);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().query("select * from t_user", ParameterizedBeanPropertyRowMapper.newInstance(User.class));
	}
}
