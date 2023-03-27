package com.zemoso.delivery.rest.model;

import java.util.List;

public class CartRequest {
	private int user_id;
	private int restaurant_id;
	private List<FoodItemRequest> food_items;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public List<FoodItemRequest> getFood_items() {
		return food_items;
	}
	public void setFood_items(List<FoodItemRequest> food_items) {
		this.food_items = food_items;
	}
}
