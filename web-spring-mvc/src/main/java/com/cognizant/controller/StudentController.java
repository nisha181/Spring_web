package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

@Controller
public class StudentController {
	
	StudentDao st=new StudentDaoImpl();

	@RequestMapping(value="insert" ,method=RequestMethod.GET)
	public String insertPage() {	
		
		return "insert";
		
	}
	
	@RequestMapping(value="insert" ,method=RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		//Read the request parameter
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		//Create the student
		Student student=new Student(id, name);
		
		System.out.println(student);
		
		//insert student to db
		String res=st.insert(new Student(id,name));
		
		if(res.equals("Success"))
			request.setAttribute("msg", "Record Inserted Successfully");
		else
			request.setAttribute("msg", "Record not Inserted Successfully");
		
		return "insert";
	}
	@RequestMapping(value="getAll" , method= {RequestMethod.POST,RequestMethod.GET})
	public String getAllpage(HttpServletRequest request) {
		List<Student> students=st.getAll();
		request.setAttribute("students", students);
		System.out.println(students);
		return "getAll";
	}

	@RequestMapping(value="update" ,method=RequestMethod.GET)
	public String updatePage() {	
		
		return "update";
		
	}
	@RequestMapping(value="update" ,method=RequestMethod.POST)
	public String update(HttpServletRequest request) {
		//Read the request parameter
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		//Create the student
		Student student=new Student(id, name);
		
		System.out.println(student);
		
		//insert student to db
		String res=st.update(new Student(id,name));
		
		if(res.equals("Success"))
			request.setAttribute("msg", "Record Updated Successfully");
		else
			request.setAttribute("msg", "Record not Updated Successfully");
		
		return "update";
	}
	@RequestMapping(value="delete" ,method=RequestMethod.GET)
	public String deletePage() {	
		
		return "delete";
		
	}
	@RequestMapping(value="delete" ,method=RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		//Read the request parameter
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		//Create the student
		Student student=new Student(id, name);
		
		System.out.println(student);
		
		//insert student to db
		String res=st.delete(student);
		
		request.setAttribute("result", res);
		
		return "delete";
	}
	
}
