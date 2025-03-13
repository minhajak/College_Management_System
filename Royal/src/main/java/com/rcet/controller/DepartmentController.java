package com.rcet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rcet.dto.Department;
import com.rcet.service.BatchService;
import com.rcet.service.DepartmentService;
import com.rcet.service.TeacherService;

@Controller
public class DepartmentController {
	DepartmentService departmentService = new DepartmentService();
	TeacherService teacherService = new TeacherService();
	BatchService batchService = new BatchService();

	@RequestMapping("/department")
	public String dept(Model model) {
		DepartmentService service = new DepartmentService();
		List<Department> departments = service.getAllDepartments();
		model.addAttribute("departments", departments);
		return "department";
	}

	@RequestMapping("/addDept")
	public String addDept() {
		return "addDepartment";
	}

	@RequestMapping(path = "/addDept/createDept", method = RequestMethod.POST)
	public String createDept(@ModelAttribute Department department) {
		DepartmentService service = new DepartmentService();
		service.saveDepartment(1, department);
		return "redirect:/department";
	}

	@RequestMapping("/department/{name}")
	public String departmentDetails(@PathVariable("name") String dname, Model model) {
		Department department = departmentService.getDepartmentByDname(dname);
		model.addAttribute("department", department);
		model.addAttribute("teachers", teacherService.getTeachersByDepartmentId(department.getDid()));
		model.addAttribute("batches", batchService.getBatchesByDepartmentId(department.getDid()));
		return "departmentdetails";
	}

}
