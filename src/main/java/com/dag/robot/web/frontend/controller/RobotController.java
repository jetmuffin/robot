package com.dag.robot.web.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/robot")
public class RobotController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("module", "expertRobot");
		
		return "robot/index";
	}
	
	
	
}
