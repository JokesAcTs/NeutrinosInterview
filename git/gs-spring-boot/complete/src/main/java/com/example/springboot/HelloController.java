package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	UserDetailsMapper userDetailsMapper;

	@GetMapping("/validateUser")
	public ResponseEntity<UserValidation> validateUser(@RequestParam("username") String userName, @RequestParam("password") String password) {
		UserValidation userValidation = new UserValidation();
		String selectUserNameSQL = "select * from user_details where user_name=?";
		List<UserDetails> userDetails = jdbcTemplate.query(selectUserNameSQL, new UserDetailsMapper(), userName);
		if(userDetails.get(0).getPassword().equalsIgnoreCase(password)) {
			userValidation.setDesignation(userDetails.get(0).getDesignation());
			userValidation.setLoginMessage("Login Successful");
			userValidation.setLoginStatus(true);
			return ResponseEntity.ok(userValidation);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping("/new_order")
	public String addOrderDetails(@RequestParam("delivery_address") String deliveryAddress) {
		 String addOrderDetailsSQL = "insert into order_details(delivery_address, delivery_status) values(?,?)";
		    jdbcTemplate.update(addOrderDetailsSQL,
		    		deliveryAddress,
		    		false);

		        return "Order Successfully placed";
	}
	
	
	@RequestMapping("/update_order")
	public long updateOrderDetails(@RequestParam("order_id") long order_id) {
		String updateOrderDetailsSQL = "update order_details set delivery_status=true where order_id=?";
		jdbcTemplate.update(updateOrderDetailsSQL, order_id);
		return 1;
	}
	
	@GetMapping("/getOrderDetails")
	public ResponseEntity<List<OrderDetails>> getOrderDetails() {
		String selectOrderDetailsSQL = "select * from order_details where delivery_status=false";
		List<OrderDetails> orderDetailsList = jdbcTemplate.query(selectOrderDetailsSQL, new OrderDetailsMapper());
		return ResponseEntity.ok(orderDetailsList);
	}

}
