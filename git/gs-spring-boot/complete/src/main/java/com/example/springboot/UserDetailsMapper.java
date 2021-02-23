package com.example.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDetailsMapper implements RowMapper<UserDetails>{

	@Override
	public UserDetails mapRow (ResultSet resultSet, int i) throws SQLException {

		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(resultSet.getString("user_name"));
		userDetails.setPassword(resultSet.getString("password"));
		userDetails.setDesignation(resultSet.getString("user_role"));
		return userDetails;
	}
	
}
