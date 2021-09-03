package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;



public interface Actions <T,S> {

	public ResponseEntity<List<T>>getAll();

	public ResponseEntity<T>add(S entity);
	
	public ResponseEntity<T>update( long id);	

	public ResponseEntity<T>delete();
	
	public ResponseEntity<T>deleteByid( long id);
	
}
