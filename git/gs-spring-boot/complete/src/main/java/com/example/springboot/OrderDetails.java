package com.example.springboot;

public class OrderDetails {
	private long order_id;
	private String delivery_address;
	private boolean delivery_status;
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public boolean isDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(boolean delivery_status) {
		this.delivery_status = delivery_status;
	}

}
