package com.dag.robot.web.backend.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.OrgnizationDao;
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
import com.dag.robot.utils.PropertiesUtil;
import com.dag.robot.utils.StringMerge;
import com.dag.robot.utils.StringSplit;
import com.dag.robot.web.bean.Page;

@Controller
@RequestMapping("/backend/expert")
public class BackendExpertController {

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
	public String list(Model model) {
		//从配置文件加载每页条数
		Page<Expert> page = expertDao.page(10, 1);//起始页为1
		model.addAttribute("page", page);
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
		Iterator<?> iterator;
		Set<RelExpertOrg> relExpertOrgs = expert.getRelExpertOrgs();
		iterator = relExpertOrgs.iterator();
		while (iterator.hasNext()) {
			RelExpertOrg relExpertOrg = (RelExpertOrg) iterator.next();
			Orgnization orgnization = relExpertOrg.getOrgnization();
			orgnizations.add(orgnization.getName());
		}

		Set<RelExpertTopic> relExpertTopics = expert.getRelExpertTopics();
		iterator = relExpertTopics.iterator();
		while (iterator.hasNext()) {
			RelExpertTopic relExpertTopic = (RelExpertTopic) iterator.next();
			Topic topic = relExpertTopic.getTopic();
			topics.add(topic.getName());
		}
		String orgsString = StringMerge.stringMerge(orgnizations);
		String topicsString = StringMerge.stringMerge(topics);
		System.out.println(orgsString);
		System.out.println(topicsString);
		model.addAttribute("exeprt", expert);
		model.addAttribute("orgnizations", orgsString);
		model.addAttribute("topics", topicsString);
		return "backend/expert/edit";
	}

	@RequestMapping(value = "/{expertId}", method = RequestMethod.GET)
	public String get(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		model.addAttribute("exeprt", expert);
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model, String name, String gender, String email,
			String address, String homepage, String experience, String info,
			String topic, String achievement, String organization,
			RedirectAttributes redirectAttributes) {
		add(name, gender, email, address, homepage, experience, info, topic, achievement, organization);
		redirectAttributes.addFlashAttribute("addMsg", "专家信息添加成功!");
		return "redirect:list";
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
	
	@RequestMapping(value = "/experts/{page}/{pageSize}", method = RequestMethod.GET)
	public String list(@PathVariable int page, @PathVariable int pageSize,  Model model) {
		Page<Expert> pageExpert = expertDao.page(pageSize, page);
		model.addAttribute("page", pageExpert);
		return "backend/expert/list";
	}
	
	
	
	
	public void add(String name, String gender, String email, String address,
			String homepage, String experience, String info, String topic,
			String achievement, String organization) {
		Expert expert = new Expert(name, gender, email, address, homepage,
				experience, info, achievement);
		expertDao.addExpert(expert);

		List<String> orgs = StringSplit.stringSplit(organization);
		for (int i = 0; i < orgs.size(); i++) {
			Orgnization orgnization = new Orgnization(orgs.get(i));
			orgnizationDao.addOrgnization(orgnization);
			RelExpertOrgId relExpertOrgId = new RelExpertOrgId(
					expert.getExpertId(), orgnization.getOrgId());
			RelExpertOrg relExpertOrg = new RelExpertOrg(relExpertOrgId,
					expert, orgnization);
			relExpertOrgDao.addRelExeprtOrg(relExpertOrg);
		}

		List<String> topics = StringSplit.stringSplit(topic);
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
