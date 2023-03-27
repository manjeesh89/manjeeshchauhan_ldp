package com.zemoso.delivery.rest.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.delivery.rest.dao.RestaurantRepository;
import com.zemoso.delivery.rest.model.Restaurant;

@Service
public class RestaurantServiceimpl implements RestaurantService {	
	private static final Logger log = LoggerFactory.getLogger(RestaurantServiceimpl.class);
	
	@Autowired
	RestaurantRepository dao;

	@Override
	public List<Restaurant> getAllRestaurants() {
		try {
			return dao.findAll();
		}catch (Exception e) {
			log.error("Exception in Get All Restaurants Method", e);
		}
		return null;
	}
	
	@Override
	public List<Restaurant> getRestaurantsByName(String name) {
		try {
			return dao.findByNameContaining(name);
		}catch (Exception e) {
			log.error("Exception in Get All Restaurants Method", e);
		}
		return null;
	}
	
	@Override
	public Optional<Restaurant> getRestaurantsByID(String id) {
		try {
			return dao.findById(Integer.parseInt(id));
		}catch (Exception e) {
			log.error("Exception in Get All Restaurants Method", e);
		}
		return null;
	}
}
