package com.test.producthandler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.producthandler.entity.Product;
import com.test.producthandler.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product product) {
		Product p =productRepository.save(product);
		return p;
	}

	public List<Product> findAllProdcut() {
		List<Product> p =productRepository.findAll();
		return p;
	}
	
	public List<Product> findAllProdcutsByUserId(Integer userId) {
		List<Product> p =productRepository.findAllProdcutsByUserId(userId);
		return p;
	}
	
	
	

}
