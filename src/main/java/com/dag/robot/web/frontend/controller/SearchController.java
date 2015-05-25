package com.dag.robot.web.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search")
public class SearchController {

	/**
	 * 搜索页面
	 * @param model
	 * @param searchType 搜索类型 expert or topic or field
	 * @param searchKey 搜索key
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String search(Model model,String searchType,String searchKey){
		
		if(searchType.equals("expert"))
			return "search/expert";
		else if(searchType.equals("field"))
			return "search/field";
		else 
			return "search/topic";
	}
}
