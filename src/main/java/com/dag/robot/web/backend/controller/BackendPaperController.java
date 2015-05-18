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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.PaperDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.utils.EntitiesForShowUtil;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperForShow;
import com.dag.robot.web.bean.PaperForShow;

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
		Page<PaperForShow> pages = paperDao.page(_pageSize, _page);//起始页为1
		model.addAttribute("pages", pages);
		return "backend/paper/list";
	}
	
	@RequestMapping(value = "/{paperId}", method = RequestMethod.GET)
	public String get(@PathVariable int paperId, Model model) {
		Paper paper = paperDao.getById(paperId);
		PaperForShow paperForShow = EntitiesForShowUtil.paperForShow(paper);
		model.addAttribute("paper", paperForShow);
		return "backend/paper/show";
	}
	
	@RequestMapping(value = "/editAbs/{paperId}", method = RequestMethod.POST)
	public String editAbs(@PathVariable int paperId,
			String abs,
			RedirectAttributes redirectAttributes) {
		//TODO
		redirectAttributes.addFlashAttribute("message", "信息修改成功！");
		return "redirect:/backend/paper/" + paperId;
	}
	
	@RequestMapping(value = "/editKeywords/{paperId}", method = RequestMethod.POST)
	public String editKeywords(@PathVariable int paperId,
			String keywords,
			RedirectAttributes redirectAttributes) {
		//TODO
		redirectAttributes.addFlashAttribute("message", "信息修改成功！");
		return "redirect:/backend/paper/" + paperId;
	}
	
	/**
	 * 添加论文
	 * @param title 标题
	 * @param authors 作者(数组)
	 * @param abs 摘要
	 * @param keywords 关键词 字符串以 ',' 分开
	 * @param type 类别 journal或conference
	 * @param journal 期刊名 type为journal时用
	 * @param issue 收录日期 yyyy年i期 type为conference用
	 	* @param conference	会议名 type为conference用
	 	*  @param time 会议时间( 'yyyy年mm月dd日' type为conference用
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(String title,String[] authors,String abs,
			String keywords,String type,String journal,String issue,
			String conference,String time,RedirectAttributes redirectAttributes) {
		//TODO
		if(type.equals("journal")){
			//TODO
		} else if(type.equals("conference")){
			//TODO
		}
		
		redirectAttributes.addFlashAttribute("message", "添加论文成功！");
		return "redirect:papers";
	}
	
	/**
	 * 删除论文
	 * @param paperId 论文ID
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/delete/{paperId}", method = RequestMethod.GET)
	public String delete(@PathVariable int paperId,RedirectAttributes redirectAttributes) {
		//TODO
		redirectAttributes.addFlashAttribute("message", "删除论文成功！");
		return "redirect:patents";
	}	
}
