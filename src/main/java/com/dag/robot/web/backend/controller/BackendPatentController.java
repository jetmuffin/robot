package com.dag.robot.web.backend.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dag.robot.data.add.AddService;
import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.OrgnizationDao;
import com.dag.robot.db.dao.PatentDao;
import com.dag.robot.db.dao.RelExpertPatentDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelExpertPaperId;
import com.dag.robot.entities.RelExpertPatent;
import com.dag.robot.entities.RelExpertPatentId;
import com.dag.robot.utils.DateUtil;
import com.dag.robot.utils.EntitiesForShowUtil;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperForShow;
import com.dag.robot.web.bean.PatentForShow;

@Controller
@RequestMapping("/backend/patent")
public class BackendPatentController {
	
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
	@Qualifier("patentDao")
	private PatentDao patentDao;
	
	@Autowired
	@Qualifier("orgnizationDao")
	private OrgnizationDao orgnizationDao;
	
	@Autowired
	@Qualifier("relExpertPatentDao")
	private RelExpertPatentDao relExpertPatentDao;
	
	@Autowired
	private AddService addService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "backend/patent/add";
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String input(Model model) {
		return "backend/patent/import";
	}
	
	@RequestMapping(value = "/patents", method = RequestMethod.GET)
	public String list(Model model,String page,String pageSize) {
		int _page = page == null ? DEFAULT_PAGE : Integer.parseInt(page);
		int _pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : Integer.parseInt(pageSize);
		Page<PatentForShow> pages = patentDao.page(_pageSize, _page);//起始页为1
		model.addAttribute("pages", pages);
		return "backend/patent/list";
	}
	
	/**
	 * 查看专利
	 * @param model
	 * @param patentId 专利ID
	 * @return
	 */
	@RequestMapping(value = "/{patentId}", method = RequestMethod.GET)
	public String get(Model model,@PathVariable int patentId) {
		Patent patent = patentDao.getById(patentId);
		PatentForShow patentForShow = EntitiesForShowUtil.patentForShow(patent);
		model.addAttribute("patent", patentForShow);
		return "backend/patent/show";
	}

	/**
	 * 修改摘要
	 * @param patentId 专利ID
	 * @param abs
	 * @param redirectAttributes 
	 * @return
	 */
	@RequestMapping(value = "/editAbs/{patentId}", method = RequestMethod.POST)
	public String editAbs(@PathVariable int patentId,@PathVariable String abs, RedirectAttributes redirectAttributes) {
		patentDao.updateAbs(patentId, abs);
		redirectAttributes.addFlashAttribute("message", "修改专利成功！");
		return "redirect:/backend/patent/" + patentId;
	}
	
	/**
	 * 添加专利
	 * @param title 标题
	 * @param applicant 申请人
	 * @param abs 摘要
	 * @param organization 组织(第一申请人单位)
	 * @param inventors 发明人(数组)
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(String title,String applicant,String abs,
			String[] inventors,String date, String orgnization, RedirectAttributes redirectAttributes) throws ParseException {
		
		addService.addPatent(title, applicant, abs, inventors, date, orgnization);
		redirectAttributes.addFlashAttribute("message", "添加专利成功！");
		return "redirect:patents";
	}	
	
	/**
	 * 删除专利
	 * @param patentId 专利ID
	 * @return
	 */
	@RequestMapping(value = "/delete/{patentId}", method = RequestMethod.GET)
	public String delete(@PathVariable int patentId,RedirectAttributes redirectAttributes) {
		Patent patent = patentDao.getById(patentId);
		patentDao.deletePatent(patent);
		redirectAttributes.addFlashAttribute("message", "删除专利成功！");
		return "redirect:patents";
	}	
}
