package com.dag.robot.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.entities.Expert;

@Controller
@RequestMapping("/backend/expert")
public class BackendExpertController {

	@Autowired
	@Qualifier("expertDao")
	ExpertDao expertDao;

	public BackendExpertController() {
		super();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model,@ModelAttribute("expert") Expert expert) {
		return "backend/expert/add";
	}
	
	@RequestMapping(value = "/edit/{expertId}", method = RequestMethod.GET)
	public String edit(@PathVariable int expertId,Model model) {
		Expert expert = expertDao.getById(expertId);
		model.addAttribute("exeprt", expert);		
		return "backend/expert/edit";
	}
	
	@RequestMapping(value = "/{expertId}", method = RequestMethod.GET)
	public String getAll(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		model.addAttribute("exeprt", expert);
		return "index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAll(Model model,String name,String gender,String email,String address
			,String homepage,String experience,String info,String area,String achievement,String organization){
		Expert expert = new Expert(name, gender, email, address, homepage, experience, info, achievement);
		System.out.println(expert.getName());
		System.out.println(organization);
		System.out.print(area);
		return "index";
	}
	
	@RequestMapping(value = "/{expertId}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable int expertId, RedirectAttributes redirectAttributes){
		Expert expert = expertDao.getById(expertId);
		expertDao.deleteExpert(expert);
		
		redirectAttributes.addFlashAttribute("deleteMsg", "专家信息已删除!");
		return "index";
	}

}
