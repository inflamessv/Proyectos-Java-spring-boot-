package com.demo.hateoas.rest.HateoasDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hateoas.rest.HateoasDemo.model.Model;

public interface Repository extends JpaRepository<Model, Long>{

}
