package com.jpa.demo.SpringBootJPA.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long addUser(User user) {
		entityManager.persist(user);
		return user.getId();	
	}
}
