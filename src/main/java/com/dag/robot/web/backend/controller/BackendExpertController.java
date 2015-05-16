package com.dag.robot.web.backend.controller;

import java.util.List;

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
import com.dag.robot.db.dao.impl.RelExpertOrgDaoImpl;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.RelExpertOrg;
import com.dag.robot.entities.RelExpertOrgId;
import com.dag.robot.utils.SpringMerge;
import com.dag.robot.utils.SpringSplit;

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

	public BackendExpertController() {
		super();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "backend/expert/add";
	}
	
	@RequestMapping(value = "/experts", method = RequestMethod.GET)
	public String list(Model model) {
		return "backend/expert/list";
	}
	
	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String input(Model model) {
		return "backend/expert/import";
	}

	@RequestMapping(value = "/edit/{expertId}", method = RequestMethod.GET)
	public String edit(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		model.addAttribute("exeprt", expert);
		return "backend/expert/edit";
	}

	@RequestMapping(value = "/{expertId}", method = RequestMethod.GET)
	public String get(@PathVariable int expertId, Model model) {
		Expert expert = expertDao.getById(expertId);
		model.addAttribute("exeprt", expert);
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAll(Model model, String name, String gender, String email,
			String address, String homepage, String experience, String info,
			String topic, String achievement, String organization) {
		Expert expert = new Expert(name, gender, email, address, homepage,
				experience, info, achievement);
		expertDao.addExpert(expert);
		List<String> orgs = SpringSplit.stringSplit(organization);
		for (int i = 0; i < orgs.size(); i++) {
			Orgnization orgnization = new Orgnization(orgs.get(i));
			orgnizationDao.addOrgnization(orgnization);
			RelExpertOrgId relExpertOrgId = new RelExpertOrgId(
					expert.getExpertId(), orgnization.getOrgId());
			RelExpertOrg relExpertOrg = new RelExpertOrg(relExpertOrgId,
					expert, orgnization);
			relExpertOrgDao.addRelExeprtOrg(relExpertOrg);
		}
		System.out.println(expert.getName());
		System.out.println(organization);
		System.out.print(topic);
		return "index";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update() {

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

}
