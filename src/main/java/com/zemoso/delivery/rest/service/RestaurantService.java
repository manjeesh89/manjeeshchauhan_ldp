package com.zemoso.delivery.rest.service;

import java.util.List;
import java.util.Optional;

import com.zemoso.delivery.rest.model.Restaurant;

public interface RestaurantService {
	public List<Restaurant> getAllRestaurants();
	public List<Restaurant> getRestaurantsByName(String name);
	public Optional<Restaurant> getRestaurantsByID(String id);
}
