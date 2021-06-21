package com.minutes.soap.webservices.soapcoursemanagement.exeption;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,customFaultCode = "{http://in28minutes.com/courses}001_COURSE_NOT_FOUND")
public class CourseHandleExeption extends RuntimeException {

	private static final long serialVersionUID = 1965215541434087139L;

	public CourseHandleExeption(String cause) {
		super(cause);
		
	}

	
}
