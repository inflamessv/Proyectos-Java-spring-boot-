package com.in28minutes.spring.basics.springin10steps;

public class Book {
	
	private String name;
	private int id;
	private String author;
	
	public Book(String name, int id, String author) {
		this.name = name;
		this.id = id;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + ", author=" + author + ", toString()=" + super.toString() + "]";
	}
	

}
