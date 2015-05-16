package com.dag.robot.dao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.RelExpertField;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	@Qualifier("expertDao")
	ExpertDao expertDao;

	public TestController() {
		super();
	}

	@RequestMapping(value = "/expert", method = RequestMethod.GET)
	public String index() {
		// TUser user = new TUser("szq", "ss", "ss", 1);
		// TTopic topic = new TTopic("data");
		// user.getTTopics().add(topic);
		// userDao.save(user);
//		Date date = new Date(0);
//		Expert expert = new Expert("szq", "boy", 1, 1, 1);
		// Field field = new Field("name");
		// expertDao.addField(expert, field, 1);

		// Topic topic = new Topic("topic");
		// expertDao.addTopic(expert, topic, 1);

		// Paper paper = new Paper("title", "abs");
		// expertDao.addPaper(expert, paper, 1);

		// Patent patent = new Patent("title", "abs", date, "test", "test");
		// expertDao.addPatent(expert, patent, 1);

		// Orgnization org = new Orgnization("org");
		// expertDao.addOrgnization(expert, org, "job");

		// Expert ex = expertDao.getById(4);
		// System.out.println(ex.getName());

//		List<Expert> experts = expertDao.getByName("szq");
//		System.out.println(experts.size());
//		Set<RelExpertField> set = experts.get(1).getRelExpertFields();
//		Iterator it = set.iterator();
//		while (it.hasNext()) {
//			RelExpertField relExpertField = (RelExpertField) it.next();
//			System.out.println(relExpertField.getField().getName());
//		}
		
//		Expert expert1 = expertDao.getById(5);
//		expertDao.deleteExpert(expert1);
		
		List<Field> list = expertDao.getFields(6);
		System.out.println(list.size());
		return "test/index";

	}

}
