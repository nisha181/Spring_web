package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.services.StudentServices;

@Controller
public class ModelController {

	@Autowired
	private StudentServices studentServices;

	public void setStudentServices(StudentServices studentServices) {
		this.studentServices = studentServices;
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String sayHelloGet(HttpServletRequest request) {
		String id = request.getParameter("id");
		request.setAttribute("deb", id);
		System.out.println(id);
		return "hello";
	}

}
