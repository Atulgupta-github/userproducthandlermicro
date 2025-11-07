package com.test.producthandler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.producthandler.entity.Product;
import com.test.producthandler.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		Product savedProduct =  prodService.createProduct(product);
		
		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAllProduct(){
		
		List<Product> p = prodService.findAllProdcut();
		
		return new ResponseEntity<List<Product>>(p, HttpStatus.OK);
	}
	
	
	@GetMapping("/v1/{userId}")
	public ResponseEntity<List<Product>> findAllProdcutsByUserId(@PathVariable Integer userId){
		
		List<Product> p = prodService.findAllProdcutsByUserId(userId);
		
		return new ResponseEntity<List<Product>>(p, HttpStatus.OK);
	}
	
	
	@GetMapping("/v2/{userId}")
    public List<Product> getProductsByUserId(@PathVariable Integer userId) {
        return prodService.findAllProdcutsByUserId(userId);
    }
	
}
