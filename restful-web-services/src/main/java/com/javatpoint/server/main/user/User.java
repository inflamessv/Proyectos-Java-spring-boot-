package com.javatpoint.server.main.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	Map<Integer, String>nombres= new HashMap<Integer, String>();
	
	private Integer id;
	@Size(min = 5,message="Name should have at least 5 characters")
	private String name;
	@Past
	private Date dob;	
	
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getDob()=" + getDob() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
