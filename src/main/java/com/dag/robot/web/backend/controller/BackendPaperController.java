package com.dag.robot.web.backend.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.PaperDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperForList;

@Controller
@RequestMapping("/backend/paper")
public class BackendPaperController {
	
	private static int DEFAULT_PAGE = 1;
	private static int DEFAULT_PAGE_SIZE = 10;
	
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
	@Qualifier("paperDao")
	private PaperDao paperDao;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "backend/paper/add";
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String input(Model model) {
		return "backend/paper/import";
	}
	
	@RequestMapping(value = "/papers", method = RequestMethod.GET)
	public String list(Model model,String page,String pageSize) {
		int _page = page == null ? DEFAULT_PAGE : Integer.parseInt(page);
		int _pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : Integer.parseInt(pageSize);
		Page<PaperForList> pages = paperDao.page(_pageSize, _page);//起始页为1
		model.addAttribute("pages", pages);
		return "backend/paper/list";
	}
}
