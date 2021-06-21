package com.in28Minutes.rest.web.service.restfullwebservice.user;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDao {

	private static List<User> users = new ArrayList<User>();
	private int userCount = 3;
	
	static {
		users.add(new User(1,"giovanni",new Date()));
		users.add(new User(2,"isaac",new Date()));
		users.add(new User(3,"helen",new Date()));
	}
	
	
	public List<User>getAllUsers(){
		return users;		
	}
	
	public User addUser(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findById(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}else {
				throw new UserNotFoundException("User not found "+id);
			}
		}
		return null;
	}
	
}
