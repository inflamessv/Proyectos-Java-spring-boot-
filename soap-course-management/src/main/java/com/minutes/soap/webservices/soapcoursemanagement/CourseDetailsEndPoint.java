package com.minutes.soap.webservices.soapcoursemanagement;

import com.in28minutes.courses.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.minutes.soap.webservices.soapcoursemanagement.exeption.CourseHandleExeption;
import com.minutes.soap.webservices.soapcoursemanagement.service.CourseDetailsService;
import com.minutes.soap.webservices.soapcoursemanagement.service.CourseDetailsService.Status;
import com.minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Endpoint
public class CourseDetailsEndPoint {

	@Autowired
	CourseDetailsService service;
	
	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse 
		processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		
		Course course = service.findById(request.getId());
		if(course == null) {
			throw new CourseHandleExeption("El id ingresado no existe "+request.getId());
		}
		GetCourseDetailsResponse response = mapCourseDetails(course);
		
		return response;
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response=new GetCourseDetailsResponse();
		
		CourseDetails details = mapCourse(course);
		
		response.setCourseDetails(details);
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails details=new CourseDetails();
		details.setId(course.getId());
		details.setName(course.getName());
		details.setDescription(course.getDescription());
		return details;
	}

	@PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		
		List<Course>courses=service.getCourses();
		
		return mapCourseDetails(courses);
		
	}
	
	private GetAllCourseDetailsResponse mapCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response=new GetAllCourseDetailsResponse();
		
		for(Course course : courses) {
			CourseDetails details = mapCourse(course);
			response.getCourseDetails().add(details);
		}		
		return response;
	}
	
	@PayloadRoot(namespace = "http://in28minutes.com/courses",localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse deleteCourseDetailsResponse(@RequestPayload DeleteCourseDetailsRequest request){
	   com.minutes.soap.webservices.soapcoursemanagement.service.CourseDetailsService.Status status=service.delete(request.getId());
		DeleteCourseDetailsResponse response=new DeleteCourseDetailsResponse();
		response.setStatus(mapStatus(status));
		return response;
	}

	private com.in28minutes.courses.Status mapStatus(Status status) {
		if(status== Status.FAILURE) {
			return com.in28minutes.courses.Status.FAILURE;
		}
		return com.in28minutes.courses.Status.SUCCESS;
	}

	
}
