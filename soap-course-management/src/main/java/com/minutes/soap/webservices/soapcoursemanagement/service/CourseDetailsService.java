package com.minutes.soap.webservices.soapcoursemanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Component;

import com.minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {

	
	private static List<Course>courses=new ArrayList<>();
	
	public enum Status{
		SUCCESS,FAILURE;
	}
	
	static {
		Course course1=new Course(1, "Angular", "Angular for beginners");
		courses.add(course1);
		
		Course course2=new Course(2, "NodeJS", "NodeJS for beginners");
		courses.add(course2);
		
		Course course3=new Course(3, "React", "React for beginners");
		courses.add(course3);
		
		Course course4=new Course(4, "Python", "Python for beginners");
		courses.add(course4);
	}
	
	public List<Course>getCourses(){
		return courses;
	}
	
	public Course findById(int id) {
		for (Course course : courses) {
			if(course.getId() == id) {
				return course;
			}
		}
		return null;
	}
	
	public Status delete (int id) {
		Iterator<Course>iterator=courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId() == id) {
				iterator.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
}
