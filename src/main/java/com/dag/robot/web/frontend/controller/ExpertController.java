package com.dag.robot.web.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.utils.EntitiesForShowUtil;
import com.dag.robot.web.bean.ExpertForShow;

@Controller
@RequestMapping("/expert")
public class ExpertController {

	@Autowired
	@Qualifier("expertDao")
	ExpertDao expertDao;

	public ExpertController() {
		super();
	}

	@RequestMapping(value = {"/{expertId}","/basic/{expertId}"}, method = RequestMethod.GET)
	public String get(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		ExpertForShow expertForShow = EntitiesForShowUtil.expertForShow(expert);
		model.addAttribute("expert", expertForShow);
		model.addAttribute("module", "专家");
		return "expert/basic";
	}

	@RequestMapping(value = "/paper/{expertId}", method = RequestMethod.GET)
	public String paper(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		ExpertForShow expertForShow = EntitiesForShowUtil.expertForShow(expert);
		model.addAttribute("expert", expertForShow);
		model.addAttribute("module", "专家");
		return "expert/paper";
	}
	
	@RequestMapping(value = "/patent/{expertId}", method = RequestMethod.GET)
	public String patent(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		ExpertForShow expertForShow = EntitiesForShowUtil.expertForShow(expert);
		model.addAttribute("expert", expertForShow);
		model.addAttribute("module", "专家");
		return "expert/patent";
	}
	
	@RequestMapping(value = "/relation/{expertId}", method = RequestMethod.GET)
	public String relation(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		ExpertForShow expertForShow = EntitiesForShowUtil.expertForShow(expert);
		model.addAttribute("expert", expertForShow);
		model.addAttribute("module", "专家");
		return "expert/relation";
	}
	
	@RequestMapping(value = "/topics/{expertId}", method = RequestMethod.GET)
	public String topics(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		ExpertForShow expertForShow = EntitiesForShowUtil.expertForShow(expert);
		model.addAttribute("expert", expertForShow);
		model.addAttribute("module", "专家");
		return "expert/topics";
	}
}
