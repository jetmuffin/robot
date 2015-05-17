package com.dag.robot.web.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.PatentDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;

@Controller
@RequestMapping("/backend/patent")
public class BackendPatentController {
	@Autowired
	@Qualifier("expertDao")
	private ExpertDao expertDao;

	@Autowired
	@Qualifier("topicDao")
	private TopicDao topicDao;

	@Autowired
	@Qualifier("relExpertTopicDao")
	private RelExpertTopicDao relExpertTopicDao;
	
	@Autowired
	@Qualifier("patentDao")
	private PatentDao patentDao;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "backend/patent/add";
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String input(Model model) {
		return "backend/patent/import";
	}
	
	@RequestMapping(value = "/patents/{}", method = RequestMethod.GET)
	public String list(Model model) {
		return "backend/patent/list";
	}
}
