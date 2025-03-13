package com.rcet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rcet.dto.Teacher;
import com.rcet.service.DepartmentService;
import com.rcet.service.SubjectService;
import com.rcet.service.TeacherService;

@Controller
public class TeacherController {
	TeacherService teacherService = new TeacherService();
	SubjectService subjectService = new SubjectService();
	DepartmentService departmentService = new DepartmentService();

	@RequestMapping("/teachers")
	public String teachers(Model model) {
		List<Teacher> teachers = teacherService.getAllTeachers();
		model.addAttribute("teachers", teachers);
		return "teachers";
	}

	@RequestMapping("/department/{dname}/addteacher")
	public String addTeacher(@PathVariable("dname") String dname, Model model) {
		DepartmentService service = new DepartmentService();
		model.addAttribute("subjects", subjectService.getAllSubjects());
		model.addAttribute("department", departmentService.getDepartmentByDname(dname));
		return "addteacher";
	}

	@RequestMapping(path = "/addteacher/handleteacher", method = RequestMethod.POST)
	public String handleTeacher(@ModelAttribute Teacher teacher, @RequestParam("profile") CommonsMultipartFile file) {
		System.out.println(file);
		teacher.setImage(file.getBytes());
		teacherService.saveTeacher(teacher.getDepartment().getDid(), teacher);
		return "redirect:/department/" + teacher.getDepartment().getDname();
	}

	@RequestMapping("/updateteacher/{id}")
	public String updateTeacher(@PathVariable("id") int id, Model model) {
		model.addAttribute("teacher", teacherService.geTeacher(id));
		return "updateteacher";

	}

	@RequestMapping(path = "handleupdateteacher/{id}", method = RequestMethod.POST)
	public String handleUpdateTeacher(@PathVariable int id, @ModelAttribute Teacher teacher) {
		System.out.println("started update");
		teacherService.updateTeacher(id, teacher);
		System.out.println(teacher);
		return "redirect:/getteacher/" + id;

	}

	@RequestMapping("/getteacher/{id}")
	public String teacherDetails(@PathVariable("id") int id, Model model) {
		model.addAttribute("teacher", teacherService.geTeacher(id));
		return "teacherdetails";

	}
}
