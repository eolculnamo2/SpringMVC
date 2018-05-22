package com.rob.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloWorldController {
	//need a controller method to show the form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller to method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//without RequestParam
	@RequestMapping("/processForm2")
	public String letsShout(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String result = "Hello! "+ theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	//with RequestParam
	@RequestMapping("/processForm3")
	public String processForm3(@RequestParam("studentName") String theName, Model model) {

		theName = theName.toUpperCase();
		
		String result = "Hey my friend "+ theName;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	

}

