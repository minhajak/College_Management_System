package com.rcet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rcet.dto.Address;
import com.rcet.dto.College;
import com.rcet.service.AddressService;
import com.rcet.service.CollegeService;

@Controller
public class CollegeController {
	CollegeService service = new CollegeService();
	AddressService addressService = new AddressService();

	@RequestMapping("/")
	public String home(Model model) {
		CollegeService service = new CollegeService();
		College college = service.getCollege(1);
		model.addAttribute("college", college);
		return "home";
	}

	@RequestMapping("/addcollege")
	public String addCollege() {
		return "addcollege";
	}

	@RequestMapping(path = "/handlecollege", method = RequestMethod.POST)
	public String handleCollege(@ModelAttribute College college) {
		Address address=college.getAddress();
		college.setAddress(null);
		System.out.println(college);
		System.out.println(address);
		service.saveCollege(college);
		addressService.saveAddress(college.getcid(), address);
		
		return "redirect:/";
	}

}
