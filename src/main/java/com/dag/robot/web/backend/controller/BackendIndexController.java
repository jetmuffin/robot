package com.dag.robot.web.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/backend/index")
public class BackendIndexController {

	/**
	 * 后台首页
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		
		//TODO 统计信息 expert,paper,patent,topic数量
//		model.addAttribute("statics", statics);
		return "backend/index/index";
	}
}
