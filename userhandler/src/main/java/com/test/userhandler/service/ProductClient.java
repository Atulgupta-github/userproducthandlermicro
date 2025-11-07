package com.test.userhandler.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.test.userhandler.entity.Product;
@FeignClient(name = "PRODUCTHANDLER")
public interface ProductClient {

	
	@GetMapping("/product/v2/{userId}")
    List<Product> getProductsByUserId(@PathVariable("userId") Integer userId);
}
