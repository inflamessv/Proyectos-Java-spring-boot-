package com.spring.rest.demo.TutorialCRUDRest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.demo.TutorialCRUDRest.model.Tutorial;
import com.spring.rest.demo.TutorialCRUDRest.repository.TutorialRepository;

@RestController
@RequestMapping("/api")
public class TutorialController {
	
	@Autowired
	TutorialRepository repository;
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>>getAllTutorials(@RequestParam(required = false)String titulo){
		try {		
			List<Tutorial>tutorials=new ArrayList<Tutorial>();

			if(titulo == null) {
				repository.findAll().forEach(tutorials::add);;
			}
			else {
				repository.findByTitleContaining(titulo).forEach(tutorials::add);
			}
			
			if(tutorials.isEmpty()){
				return new ResponseEntity<List<Tutorial>>(tutorials, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Tutorial>>(tutorials, HttpStatus.OK);	
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> addTutorial(@RequestBody Tutorial tutorial){
		
		try {
			Tutorial _tutorial = repository.save(tutorial);
			return new ResponseEntity<Tutorial>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> updateTutorial(@RequestBody Tutorial tutorial,@PathVariable("id") long id){
		
		try {
			Optional<Tutorial> _tutorialData = repository.findById(id);
			Tutorial _tutorial=null;
			
			if(_tutorialData.isPresent()) {
			    _tutorial = _tutorialData.get();
				_tutorial.setDescription(tutorial.getDescription());
				_tutorial.setTitle(tutorial.getTitle());
				_tutorial.setPublished(tutorial.isPublished());				
			}

			return new ResponseEntity<Tutorial>(repository.save(_tutorial), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus>deleteById(@PathVariable("id")long id){
		
		try {
			repository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus>deleteAll(){
		
		try {
			repository.deleteAll();;
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> findByPublished() {
		try {
			List<Tutorial> tutorials = repository.findByPublished(true);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
