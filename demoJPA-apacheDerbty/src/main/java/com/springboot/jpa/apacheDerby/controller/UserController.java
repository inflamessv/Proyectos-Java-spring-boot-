package com.springboot.jpa.apacheDerby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.jpa.apacheDerby.model.*;
import com.springboot.jpa.apacheDerby.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/list")
	public List<UserRecord>getAllUsersRecord(){
		return service.getAllUsers();
	}
	
	@PostMapping("/add-user")
	public void agregarUsuario(@RequestBody UserRecord user) {
		service.AddUser(user);
	}

}
