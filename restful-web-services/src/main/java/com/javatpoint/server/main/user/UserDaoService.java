package com.javatpoint.server.main.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	
	public static  int userCount = 5;
	private static List<User>users= new ArrayList<>();
	
	static {
		users.add(new User(1,"giovanni",new Date()));
		users.add(new User(2,"isaac", new Date()));
		users.add(new User(3,"helen", new Date()));
		users.add(new User(4,"jose",new Date()));
		users.add(new User(5,"daniela", new Date()));
	
	}
	
	public List<User>getUsers(){
		return users;
	}
	
	public User add(User user) {
		if(user.getId() == null) {
		  user.setId(++userCount);
		}		
		users.add(user);
		return user;		
	}
	
	public User findById(Integer id) {
		for(User user : users){
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public User deleteById(Integer id) {
		
		Iterator<User>iterator=users.iterator();
		while(iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
