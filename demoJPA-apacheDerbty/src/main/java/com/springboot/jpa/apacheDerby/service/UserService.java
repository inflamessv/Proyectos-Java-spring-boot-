package com.springboot.jpa.apacheDerby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.apacheDerby.model.UserRecord;
import com.springboot.jpa.apacheDerby.repository.IUserRepository;

@Service
public class UserService {

	@Autowired    
	private IUserRepository repository;
	
	public List<UserRecord>getAllUsers(){
		List<UserRecord>lstUser = repository.findAll();
		return lstUser;
	}
	
	public void AddUser(UserRecord user) {
		repository.save(user);
	}
	  
}
