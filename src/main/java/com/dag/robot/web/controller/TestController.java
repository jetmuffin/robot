package com.dag.robot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = "/index")
	public String test(Model model) {
		model.addAttribute("helloworld", "Hello world!");
		return "test/index";
	}
}
