package com.demo.hateoas.rest.HateoasDemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.hateoas.rest.HateoasDemo.model.*;
import com.demo.hateoas.rest.HateoasDemo.repository.Repository;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private Repository repo;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/greeting")
	public String greeting() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/model")
	public ResponseEntity<List<Model>> allModel(){
		try {
			List<Model>lstModel=new ArrayList<Model>();
			repo.findAll().forEach(lstModel::add);
			return new ResponseEntity<List<Model>>(lstModel, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/model/{id}")
	public EntityModel<Model> modelById(@PathVariable("id") long id){
		
			Optional<Model>_modelData=repo.findById(id);
			Model model=_modelData.get();
			
			EntityModel<Model> resource=EntityModel.of(model);
			WebMvcLinkBuilder linkto=linkTo(methodOn(this.getClass()).allModel());
			resource.add(linkto.withRel("all-users"));
			return resource;
		
	}
	
	@PostMapping("/model")
	public ResponseEntity<HttpStatus>addModel(@RequestBody Model model){
		try {
			repo.save(model);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/model/{id}")
	public ResponseEntity<Model>updateModel(@PathVariable("id")long id,@RequestBody Model model){
		try {
			Optional<Model>_modelData=repo.findById(id);
			Model _model=null;
			if(_modelData.isPresent()) {
			    _model =_modelData.get();
				_model.setName(model.getName());
				_model.setDescription(model.getDescription());
			}
			return new ResponseEntity<Model>(repo.save(_model),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping("/model")
	public ResponseEntity<HttpStatus>deleteModel(){
		try {
			repo.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
