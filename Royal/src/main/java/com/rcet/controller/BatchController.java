package com.rcet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rcet.dto.Batch;
import com.rcet.service.BatchService;
import com.rcet.service.DepartmentService;
import com.rcet.service.StudentService;

@Controller
public class BatchController {
	BatchService service = new BatchService();
	StudentService studentService = new StudentService();

	@RequestMapping("/batchs")
	public String batch(Model model) {
		BatchService service = new BatchService();
		model.addAttribute("batchs", service.getAllBatchs());
		return "batch";
	}

	@RequestMapping("/department/{name}/addBatch")
	public String batchAdd(@PathVariable("name") String name,Model model) {
		DepartmentService service = new DepartmentService();
		model.addAttribute("department", service.getDepartmentByDname(name));
		return "addBatch";
	}

	@RequestMapping(path = "createBatch", method = RequestMethod.POST)
	public String addBatch(@ModelAttribute Batch batch) {
		System.out.println("batch creation started");
		BatchService service = new BatchService();
		service.saveBactch(batch.getDepartment().getDid(), batch);

		return "redirect:/department/" + batch.getDepartment().getDname();

	}

	@RequestMapping("/{dname}/batch/{BatchCode}")
	public String batchDetails(@PathVariable("BatchCode") String BatchCode, Model model) {
		System.out.println("/n inside the Batchcontroller");
		Batch batch = service.getBatchByName(BatchCode);
		model.addAttribute("batch", batch);
		System.out.println("1 2 3.................go ");
		model.addAttribute("students", studentService.getStudentByBatchId(batch.getBid()));
		return "batchdetails";
	}

}
