package com.dag.robot.web.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.Topic;


@Controller
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	@Qualifier("topicDao")
	TopicDao topicDao;
	
	@RequestMapping(value = {"/{topicId}","/basic/{topicId}"}, method = RequestMethod.GET)
	public String get(@PathVariable int topicId, Model model) {
		model.addAttribute("module", "研究领域");
		return "topic/basic";
	}
	
	@RequestMapping(value = "/network/{topicId}", method = RequestMethod.GET)
	public String network(@PathVariable int topicId, Model model) {
		model.addAttribute("module", "研究领域");
		
		Topic topic = topicDao.getById(topicId);
		model.addAttribute("topic", topic);
		return "topic/network";
	}
	
	@RequestMapping(value = "/knowledge/{topicId}", method = RequestMethod.GET)
	public String knowledge(@PathVariable int topicId, Model model) {
		model.addAttribute("module", "研究领域");
		
		Topic topic = topicDao.getById(topicId);
		model.addAttribute("topic", topic);
		return "topic/knowledge";
	}
}
