package com.dag.robot.web.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/backend/crawler")
public class BackendCrawlerController {
	
	/**
	 * 万方爬虫页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wangfang", method = RequestMethod.GET)
	public String wangfang(Model model){
		
		return "backend/crawler/wangfang";
	}
}
