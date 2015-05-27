package com.dag.robot.web.frontend.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dag.robot.db.dao.ExpertDao;

@Controller
@RequestMapping("/robot")
public class RobotController {
	private int pointNum = 1;
	
	@Autowired
	@Qualifier("expertDao")
	ExpertDao expertDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("module", "expertRobot");
		
		return "robot/index";
	}
	
	@RequestMapping(value="/answer",method = RequestMethod.GET)
	@ResponseBody
	public List<String> answer(Model model,String sentence,int expertId) throws UnsupportedEncodingException{
		
		sentence = new String(sentence.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(sentence);
		List<String> points = expertDao.getPoint(expertId, sentence, pointNum);
		model.addAttribute("module", "expertRobot");
		return points;
	}
}
