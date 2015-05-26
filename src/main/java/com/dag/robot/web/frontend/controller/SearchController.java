package com.dag.robot.web.frontend.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.data.add.AddService;
import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.OrgnizationDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Topic;
import com.dag.robot.utils.EntitiesForListUtil;
import com.dag.robot.utils.EntitiesForShowUtil;
import com.dag.robot.web.bean.ExpertForShow;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	@Qualifier("expertDao")
	private ExpertDao expertDao;

	@Autowired
	@Qualifier("orgnizationDao")
	private OrgnizationDao orgnizationDao;

	@Autowired
	@Qualifier("topicDao")
	private TopicDao topicDao;

	@Autowired
	@Qualifier("relExpertTopicDao")
	private RelExpertTopicDao relExpertTopicDao;

	@Autowired
	private AddService addService;
	/**
	 * 搜索页面
	 * @param model
	 * @param searchType 搜索类型 expert or topic or field
	 * @param searchKey 搜索key
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String search(Model model,String searchType,String searchKey) throws UnsupportedEncodingException{
		searchKey = new String(searchKey.getBytes("ISO-8859-1"),"utf-8");
		model.addAttribute("searchKey", searchKey);
		if(searchType.equals("expert")){
			List<ExpertForShow> experts = expertDao.getByFuzzyName(searchKey);
			model.addAttribute("experts", experts);
			return "result/expert";
		}
		else if(searchType.equals("field")){
			return "result/field";
			
		}else {
			List<Topic> topics = topicDao.getTopicByFuzzyName(searchKey);
			model.addAttribute("topics", EntitiesForListUtil.topicForList(topics));
			return "result/topic";
		}
	}
}
