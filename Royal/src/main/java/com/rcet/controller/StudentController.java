package com.rcet.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mysql.cj.Session;
import com.rcet.dto.Batch;
import com.rcet.dto.Student;
import com.rcet.dto.Teacher;
import com.rcet.service.BatchService;
import com.rcet.service.StudentService;

@Controller
public class StudentController {
	StudentService studentService = new StudentService();
	BatchService batchService = new BatchService();

	@RequestMapping("/students")
	public String Students(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@RequestMapping("/batch/{id}/addstudent")
	public String addStudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("batch", batchService.getBatch(id));
		return "addstudent";
	}

	@RequestMapping(path = "/handlestudent", method = RequestMethod.POST)
	public String handleTeacher(@ModelAttribute Student student, @RequestParam("profile") CommonsMultipartFile file,
			@RequestParam("batchId") int batchId) {

		System.out.println(file);
		student.setImage(file.getBytes());

		Batch batch = batchService.getBatch(batchId);
		student.setBatch(batch);

		Student student2 = studentService.saveStudent(batchId, student);
		return "redirect:/" + student2.getBatch().getDepartment().getDname() + "/batch/"
				+ student2.getBatch().getBatchCode();
	}

	@RequestMapping("/getstudent/{id}")
	public String getstudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "studentdetails";

	}

	@RequestMapping("/updatestudent/{id}")
	public String updateStuddent(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "updatestudent";

	}

	@RequestMapping(path = "handleupdatestudent/{id}", method = RequestMethod.POST)
	public String handleUpdateStudent(@PathVariable int id, @ModelAttribute Student student) {
		studentService.updateStudent(id, student);
		return "redirect:/getstudent/" + id;

	}
}
