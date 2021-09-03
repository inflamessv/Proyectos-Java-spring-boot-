package com.jpa.demo.SpringBootJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.demo.SpringBootJPA.entity.User;
import com.jpa.demo.SpringBootJPA.entity.UserDAOService;


@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log=
				LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userService;
	
	@Override
	public void run(String... args) throws Exception {
		/*User user=new User("giovanni","admin");
		long insert=userService.addUser(user);
		log.info("New user is created "+ user);*/
	}

}
