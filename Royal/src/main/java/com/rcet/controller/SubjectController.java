package com.rcet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rcet.dto.Marks;
import com.rcet.dto.Subject;
import com.rcet.service.BatchService;
import com.rcet.service.DepartmentService;
import com.rcet.service.MarksService;
import com.rcet.service.StudentService;
import com.rcet.service.SubjectService;

@Controller
public class SubjectController {
	SubjectService subjectService = new SubjectService();
	DepartmentService departmentService = new DepartmentService();
	BatchService batchService = new BatchService();
	MarksService marksService = new MarksService();

//	@RequestMapping("subject")
//	public String subject(Model model) {
//		model.addAttribute("subjects", subjectService.getAllSubjects());
//		return "subject";
//	}

	@RequestMapping("/batch/{id}/addsubject")
	public String addSubject(@PathVariable("id") int id, Model model) {
		model.addAttribute("batch", batchService.getBatch(id));
		return "addsubject";

	}

	@RequestMapping(path = "/addsubject/handlesubject", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute Subject subject, @RequestParam("batchId") int bid) {
		subjectService.saveStudent(subject.getDepartment().getDid(), bid, subject);
		return "redirect:/" + subject.getDepartment().getDname() + "/batch/" + subject.getBatch().getBatchCode();
	}

	@RequestMapping("/subject/{id}")
	public String showSubjectDetails(@PathVariable("id") int id, Model model) {
		Subject subject = subjectService.getSubject(id);
		model.addAttribute("subject", subject);
		List<Marks> marks = marksService.getMarksBySubjectId(subject.getSid());
		model.addAttribute("marks", marks);
		return "subjectdetails";

	}

}
