package com.in28Minutes.rest.web.service.restfullwebservice.user;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

public class User {

	private Integer id;
	private String name;	
	private Date bithDate;

	
	public User(Integer id, String name, Date bithDate) {
		super();
	
		this.id = id;
		this.name = name;
		this.bithDate = bithDate;
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

	public Date getBithDate() {
		return bithDate;
	}

	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bithDate=" + bithDate + "]";
	}
	
	
}
