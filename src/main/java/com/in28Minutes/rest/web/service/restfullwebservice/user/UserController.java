package com.in28Minutes.rest.web.service.restfullwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	
	@GetMapping("/users")
	private List<User>getAllUsers(){
		return dao.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	private User findUser(@PathVariable int id) {
		return dao.findById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		
		User userSaved=dao.addUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userSaved.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
