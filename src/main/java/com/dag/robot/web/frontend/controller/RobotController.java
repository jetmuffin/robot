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

import com.dag.robot.analyzer.Analyzer;
import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.nlp.StanfordParser;

import edu.stanford.nlp.process.WordSegmenter;

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
		Analyzer analyzer = new Analyzer();
		String [] words = analyzer.analyzeSplit(sentence);
		String keyword = StanfordParser.getRoot(words);
		List<String> points = expertDao.getPoint(expertId, keyword, pointNum);
		model.addAttribute("module", "expertRobot");
		System.out.println(points.size());
		return points;
	}
}
