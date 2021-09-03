package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Actions;
import com.example.demo.model.Book;
import com.example.demo.repository.Repository;

@RestController
@RequestMapping("test")
public class Controller {

	@Autowired
	private Repository repository;

	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAll() {
		List<Book>lst=new ArrayList<Book>();
		repository.findAll().forEach(lst::add);
		return new ResponseEntity<List<Book>>(lst,HttpStatus.OK);
	}

	@PostMapping("/book")
	public ResponseEntity<HttpStatus> add(@RequestBody Book entity) {
		repository.save(entity);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<Book> update(@PathVariable long id,@RequestBody Book entity) {
		// TODO Auto-generated method stub
		Book _bookData=repository.getById(id);
		_bookData.setDescription(entity.getDescription());
		_bookData.setTitle(entity.getTitle());
		return new ResponseEntity<Book>(repository.save(_bookData),HttpStatus.OK);
	}

	@DeleteMapping("/book")
	public ResponseEntity<HttpStatus> delete() {
		// TODO Auto-generated method stub
		repository.deleteAll();
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<HttpStatus> deleteByid(@PathVariable long id) {
		repository.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}