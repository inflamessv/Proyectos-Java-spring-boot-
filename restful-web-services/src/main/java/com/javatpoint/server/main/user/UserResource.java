package com.javatpoint.server.main.user;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.javatpoint.server.main.exception.CustomizedResponseEntityExceptionHandler;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	
	@GetMapping("/users")
	public List<User>retriveAllUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getById(@PathVariable Integer id) {
		User user=service.findById(id);
		if(user ==null) {
			throw new UserNotFoundException("id:"+id);
			 
		}
		return user;
	}
	
	/*@PostMapping("/users")
	public void createUsers(@RequestBody User user) {
		service.add(user);
	}*/
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser = service.add(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable Integer id) {
		User user=service.deleteById(id);
		if(user ==null) {
			throw new UserNotFoundException("id:"+id);
		}
	}
}
