package com.dag.robot.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.StaticsDao;
import com.dag.robot.web.bean.Statics;

@Controller
@RequestMapping("/backend/index")
public class BackendIndexController {

	@Autowired
	@Qualifier("staticsDao")
	private StaticsDao staticsDao;
	
	/**
	 * 后台首页
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		Statics statics = staticsDao.initStatics();
		//统计信息 expert,paper,patent,topic数量
		model.addAttribute("statics", statics);
		return "backend/index/index";
	}
}
