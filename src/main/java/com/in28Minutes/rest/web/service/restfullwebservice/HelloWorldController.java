package com.in28Minutes.rest.web.service.restfullwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "hello workd";
	} 
	
	@GetMapping("/hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("hola mundo");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorld helloWorldParam(@PathVariable String name) {
		return new HelloWorld(String.format("hola mundo,%s", name));
		
	}
}


