package com.validation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validation.entities.LoginData;


@Controller
public class MyController {

	
	@GetMapping("/form")
	public String openForm(Model model) {
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	
	//handler for process form
	//form data comes at this url, data coming in modelAttrib argument stores in a loginData
	//valid annotation used to triger validation,validation results stores in bindingresult
	@PostMapping("/process")
	public String processForm(@jakarta.validation.Valid @ModelAttribute("loginData")LoginData loginData,BindingResult result) {
		System.out.println(result);
		System.out.println(loginData.getEmail());
		System.out.println(loginData.getUserName());
		if(result.hasErrors()) {
			return "form";
		}
		return "success";
	}
	
	
	
}
