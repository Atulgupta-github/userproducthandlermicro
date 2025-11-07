package com.test.userhandler.controller;

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

import com.test.userhandler.entity.User;
import com.test.userhandler.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<User> userCreation(@RequestBody User user){
		User saveduser = userService.createUser(user);
		
		return new ResponseEntity<>(saveduser, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> users =userService.getAllUser();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	@GetMapping("/fromresttemplate")
	public ResponseEntity<List<User>> getUserWichHaveMoreProductfromResttemplate(){
		List<User> users =userService.getUserWhichHaveMoreProduct();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/fromrfeign")
	public ResponseEntity<List<User>> getUserWichHaveMoreProductfromfeignclient(){
		List<User> users =userService.getUserWhichHaveMoreProductFromFeign();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	@GetMapping("/{userName}")
	public ResponseEntity<List<User>> findByUserName(@PathVariable("userName") String userName ){
		List<User> users =userService.findByUserName(userName);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	
	
}
