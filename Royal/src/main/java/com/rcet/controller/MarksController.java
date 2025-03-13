package com.rcet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rcet.dto.Marks;
import com.rcet.service.MarksService;
import com.rcet.service.StudentService;
import com.rcet.service.SubjectService;

@Controller
public class MarksController {
	MarksService marksService = new MarksService();
	StudentService studentService = new StudentService();
	SubjectService subjectService = new SubjectService();

	@RequestMapping("/addmarks/{subId}")
	public String addMarks(@PathVariable("subId") int id, Model model) {
		model.addAttribute("subject", subjectService.getSubject(id));
		return "addmarks";
	}

	@RequestMapping(path = "/handleaddmarks", method = RequestMethod.POST)
	public String handleAddMarks(@ModelAttribute Marks marks, @RequestParam("studId") int studId,
			@RequestParam("subId") int subId) {
		
		marksService.saveMarks(studId, subId, marks);

		return "redirect:/subject/" + subId;

	}

	@RequestMapping("/updateMarks/{studId}/{subId}/{markId}")
	public String getMarks(@PathVariable("studId") int studId, @PathVariable("subId") int subId,
			@PathVariable("markId") int id, Model model) {
		model.addAttribute("marks", marksService.getByIds(studId, subId));
		return "updatemark";
	}

	@RequestMapping(path = "/handlupdateemark", method = RequestMethod.POST)
	public String handleMark(@ModelAttribute Marks marks) {
		Marks marks2 = marksService.updateMarks(marks);

		return "redirect:/subject/" + marks2.getSubject().getSid();

	}

}
