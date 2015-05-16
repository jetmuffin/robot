package com.dag.robot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/backend")
public class BackendController {

	public BackendController() {
		super();
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(){
		return "backend/index/index";
	}
	
	@RequestMapping(value = "/expert/experts", method = RequestMethod.GET)
	public String list(){
		return "backend/expert/list";
	}
	
	@RequestMapping(value = "/expert/{expertId}", method = RequestMethod.GET)
	public String show(@PathVariable int expertId, Model model){
		return "backend/expert/show";
	}
	
	@RequestMapping(value = "/expert/{expertId}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable int expertId, Model model){
		return "backend/expert/edit";
	}
	
	@RequestMapping(value = "/expert/add", method = RequestMethod.GET)
	public String add(Model model){
		return "backend/expert/add";
	}
}
