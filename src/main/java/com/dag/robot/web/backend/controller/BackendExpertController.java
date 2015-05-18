package com.dag.robot.web.backend.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.OrgnizationDao;
import com.dag.robot.db.dao.PaperDao;
import com.dag.robot.db.dao.RelExpertOrgDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.db.dao.impl.RelExpertOrgDaoImpl;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.RelExpertOrg;
import com.dag.robot.entities.RelExpertOrgId;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.entities.RelExpertTopicId;
import com.dag.robot.entities.Topic;
import com.dag.robot.utils.EntitiesForShowUtil;
import com.dag.robot.utils.PropertiesUtil;
import com.dag.robot.utils.StringMergeUtil;
import com.dag.robot.utils.StringSplitUtil;
import com.dag.robot.web.bean.ExpertForCheck;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.Page;

@Controller
@RequestMapping("/backend/expert")
public class BackendExpertController {
	private static int DEFAULT_PAGE = 1;
	private static int DEFAULT_PAGE_SIZE = 10;

	@Autowired
	@Qualifier("expertDao")
	private ExpertDao expertDao;

	@Autowired
	@Qualifier("orgnizationDao")
	private OrgnizationDao orgnizationDao;

	@Autowired
	@Qualifier("relExpertOrgDao")
	private RelExpertOrgDao relExpertOrgDao;

	@Autowired
	@Qualifier("topicDao")
	private TopicDao topicDao;

	@Autowired
	@Qualifier("relExpertTopicDao")
	private RelExpertTopicDao relExpertTopicDao;

	public BackendExpertController() {
		super();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "backend/expert/add";
	}

	@RequestMapping(value = "/experts", method = RequestMethod.GET)
	public String list(Model model, String page, String pageSize) {
		int _page = page == null ? DEFAULT_PAGE : Integer.parseInt(page);
		int _pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : Integer
				.parseInt(pageSize);
		Page<ExpertForList> pages = expertDao.page(_pageSize, _page);// 起始页为1
		model.addAttribute("pages", pages);
		return "backend/expert/list";
	}

	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String input(Model model) {
		return "backend/expert/import";
	}

	@RequestMapping(value = "/edit/{expertId}", method = RequestMethod.GET)
	public String edit(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		List<String> orgnizations = new ArrayList<String>();
		List<String> topics = new ArrayList<String>();
		String orgString = expert.getOrgnization().getName();

		Set<RelExpertTopic> relExpertTopics = expert.getRelExpertTopics();
		Iterator<?> iterator = relExpertTopics.iterator();
		while (iterator.hasNext()) {
			RelExpertTopic relExpertTopic = (RelExpertTopic) iterator.next();
			Topic topic = relExpertTopic.getTopic();
			topics.add(topic.getName());
		}
		String orgsString = StringMergeUtil.stringMerge(orgnizations);
		String topicsString = StringMergeUtil.stringMerge(topics);
		System.out.println(orgsString);
		System.out.println(topicsString);
		model.addAttribute("expert", expert);
		model.addAttribute("orgnization", orgsString);
		model.addAttribute("topics", topicsString);
		return "backend/expert/edit";
	}

	@RequestMapping(value = "/{expertId}", method = RequestMethod.GET)
	public String get(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		ExpertForShow expertForShow = EntitiesForShowUtil.expertForShow(expert);
		model.addAttribute("expert", expertForShow);
		return "backend/expert/show";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model, String name, String gender, String email,
			String address, String homepage, String experience, String info,
			String topic, String achievement, String organization,
			RedirectAttributes redirectAttributes) {
		add(name, gender, email, address, homepage, experience, info, topic,
				achievement, organization);
		redirectAttributes.addFlashAttribute("addMsg", "专家信息添加成功!");
		return "redirect:experts";
	}

	@RequestMapping(value = "/edit/{expertId}", method = RequestMethod.POST)
	public String edit(@PathVariable int expertId) {
		return "index";
	}

	@RequestMapping(value = "/delete/{expertId}", method = RequestMethod.POST)
	public String delete(@PathVariable int expertId,
			RedirectAttributes redirectAttributes) {
		Expert expert = expertDao.getById(expertId);
		expertDao.deleteExpert(expert);
		redirectAttributes.addFlashAttribute("deleteMsg", "专家信息已删除!");
		return "index";
	}

	@RequestMapping(value = "/check/{expertName}.json", method = RequestMethod.GET)
	public @ResponseBody List<ExpertForCheck> check(
			@PathVariable String expertName) {
		List<ExpertForCheck> expertForChecks = expertDao.check(expertName);
		return expertForChecks;
	}

	@RequestMapping(value = "/editExperience/{expertId}", method = RequestMethod.POST)
	public String editExperience(@PathVariable int expertId,
			String experience,
			RedirectAttributes redirectAttributes) {
		expertDao.updateExperience(expertId, experience);
		redirectAttributes.addAttribute("EditMsg", "信息修改成功！");
		return "redirect:/backend/expert/" + expertId;
	}

	@RequestMapping(value = "/editInfo/{expertId}", method = RequestMethod.POST)
	public String editInfo(@PathVariable int expertId,
			String info, RedirectAttributes redirectAttributes) {
		expertDao.updateInfo(expertId, info);
		redirectAttributes.addFlashAttribute("EditMsg", "信息修改成功！");
		return "redirect:/backend/expert/" + expertId;
	}

	@RequestMapping(value = "/editAchievement/{expertId}", method = RequestMethod.POST)
	public String editAchievement(@PathVariable int expertId,
			String achievement,
			RedirectAttributes redirectAttributes) {
		expertDao.updateAchievement(expertId, achievement);
		redirectAttributes.addFlashAttribute("EditMsg", "信息修改成功！");
		return "redirect:/backend/expert/" + expertId;
	}

	public void add(String name, String gender, String email, String address,
			String homepage, String experience, String info, String topic,
			String achievement, String organization) {
		Expert expert = new Expert(name, gender, email, address, homepage,
				experience, info, achievement);
		expertDao.addExpert(expert);

		List<String> orgs = StringSplitUtil.stringSplit(organization);
		for (int i = 0; i < orgs.size(); i++) {
			Orgnization orgnization = new Orgnization(orgs.get(i));
			orgnizationDao.addOrgnization(orgnization);
			RelExpertOrgId relExpertOrgId = new RelExpertOrgId(
					expert.getExpertId(), orgnization.getOrgId());
			RelExpertOrg relExpertOrg = new RelExpertOrg(relExpertOrgId,
					expert, orgnization);
			relExpertOrgDao.addRelExeprtOrg(relExpertOrg);
		}

		List<String> topics = StringSplitUtil.stringSplit(topic);
		for (int i = 0; i < topics.size(); i++) {
			Topic topic1 = new Topic(topics.get(i));
			topicDao.addTopic(topic1);
			RelExpertTopicId relExpertTopicId = new RelExpertTopicId(
					expert.getExpertId(), topic1.getTopicId());
			RelExpertTopic relExpertTopic = new RelExpertTopic(
					relExpertTopicId, expert, topic1);
			relExpertTopicDao.addRelExeprtTopic(relExpertTopic);
		}
	}

}
