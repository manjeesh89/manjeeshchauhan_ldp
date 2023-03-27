package com.zemoso.delivery.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemoso.delivery.rest.model.CartRequest;
import com.zemoso.delivery.rest.model.Restaurant;
import com.zemoso.delivery.rest.service.RestaurantService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Mycontroller {

	private static final Logger log = LoggerFactory.getLogger(Mycontroller.class);
	
	ObjectMapper mapper = new ObjectMapper();
	List<Restaurant> list = null;
	Optional<Restaurant> rest = null;

	@Autowired
	RestaurantService restaurantService;

	@GetMapping(value = {"/restaurants", "/restaurants/{id}"})
	public ResponseEntity<?> restaurants(@RequestParam(value = "keyword", required = false) String keyword, 
			@PathVariable(required = false) String id) throws Exception {
		log.info("Get Restaurants id={}, keyword={}",id, keyword);
		
		if(keyword != null && !keyword.equals(""))
			list = restaurantService.getRestaurantsByName(keyword);
		else if(id != null && !id.equals(""))
			rest = restaurantService.getRestaurantsByID(id);
		else
			list = restaurantService.getAllRestaurants();
		
		if (list != null && !list.isEmpty()) 
			return new ResponseEntity<List<Restaurant>>(list, HttpStatus.OK);
		else if(rest != null && !rest.isEmpty())
			return new ResponseEntity<Object>(rest, HttpStatus.OK);
		else 
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/cart")
	public ResponseEntity<?> cart(@Valid @RequestBody CartRequest cart) throws Exception {
		log.info("Get Cart cart={}",mapper.writeValueAsString(cart));
		
		
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_FOUND);
	}
	
}