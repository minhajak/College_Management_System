package com.rcet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rcet.dto.Student;
import com.rcet.dto.Teacher;
import com.rcet.service.StudentService;
import com.rcet.service.TeacherService;

@Controller
public class ImageController {

	@RequestMapping(path = "/teacher/{id}", method = RequestMethod.GET)
	public void imageTeacher(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
		TeacherService service = new TeacherService();
		Teacher teacher = service.geTeacher(id);
		response.setContentType("image/jpg");
		response.getOutputStream().write(teacher.getImage());

	}
	
	@RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
	public void imageStudent(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
		StudentService service = new StudentService();
		Student student = service.getStudent(id);
		response.setContentType("image/jpg");
		response.getOutputStream().write(student.getImage());
		
	}

}
