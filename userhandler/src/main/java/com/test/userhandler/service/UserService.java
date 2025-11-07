package com.test.userhandler.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.userhandler.entity.Product;
import com.test.userhandler.entity.User;
import com.test.userhandler.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProductClient productClient;
	
	public User createUser(User user) {
		if (user.getProducts() != null) {
            for (Product p : user.getProducts()) {
                p.setUser(user);
            }
        }
		
		User saveduser = userRepository.save(user);
		
		return saveduser;
	}
	
	
	public List<User> getAllUser(){
		List<User>users= userRepository.findAll();
		return users;
	}
	
	public List<User> findByUserName(String username){
		List<User>users= userRepository.findByName(username);
		return users;
	}
	
	
	public List<User> getUserWhichHaveMoreProduct() {
	    List<User> users = userRepository.findAll();
	    List<User> result = new ArrayList<>();

	    for (User user : users) {
	        try {
	        	 Product[] products = restTemplate.getForObject(
	                     "http://PRODUCTHANDLER/product/v2/" + user.getUserId(),
	                     Product[].class
	                 );

	                 // ✅ Check if user has more than 1 product
	                 if (products != null && products.length > 0) {
	                     result.add(user);
	                 }

	        } catch (Exception e) {
	            System.err.println("❌ Error fetching products for userId " + user.getUserId() + ": " + e.getMessage());
	        }
	    }

	    return result;
	}
	
	@CircuitBreaker(name = "productServiceCB", fallbackMethod = "fallbackProducts")
	public List<User> getUserWhichHaveMoreProductFromFeign() {
		 List<User> users = userRepository.findAll();
		    List<User> result = new ArrayList<>();

		    for (User user : users) {
		        List<Product> products = productClient.getProductsByUserId(user.getUserId());
		        if (products != null && products.size() > 0) {
		            result.add(user);
		        }
		    }
		    
		    return result;
		
	}
	
	public List<User> fallbackProducts(Throwable t) {
        System.err.println("⚠️ Product service unavailable: " + t.getMessage());
        // Return empty list or cached data
        return Collections.emptyList();
    }

}

