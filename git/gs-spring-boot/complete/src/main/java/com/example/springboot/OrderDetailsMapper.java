package com.example.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderDetailsMapper implements RowMapper<OrderDetails>{

	@Override
	public OrderDetails mapRow (ResultSet resultSet, int i) throws SQLException {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrder_id(resultSet.getInt("order_id"));
		orderDetails.setDelivery_address(resultSet.getString("delivery_address"));
		orderDetails.setDelivery_status(resultSet.getBoolean("delivery_status"));
		return orderDetails;
	}
	
}
