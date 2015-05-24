package com.dag.robot.dao;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.weaver.patterns.OrSignaturePattern;
import org.neo4j.register.Register.Int;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dag.robot.data.input.InputFromJson;
import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.FieldDao;
import com.dag.robot.db.dao.OrgnizationDao;
import com.dag.robot.db.dao.PaperDao;
import com.dag.robot.db.dao.PatentDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.db.dao.UserDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.RelExpertField;
import com.dag.robot.entities.Topic;
import com.dag.robot.entities.User;
import com.dag.robot.web.bean.ExpertForList;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	@Qualifier("expertDao")
	ExpertDao expertDao;
	
	@Autowired
	@Qualifier("fieldDao")
	FieldDao fieldDao;
	
	@Autowired
	@Qualifier("orgnizationDao")
	OrgnizationDao orgnizationDao;
	
	@Autowired
	@Qualifier("paperDao")
	PaperDao paperDao;
	
	@Autowired
	@Qualifier("patentDao")
	PatentDao patentDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@Autowired
	@Qualifier("topicDao")
	TopicDao topicDao;
	
	@Autowired
	@Qualifier("relExpertTopicDao")
	RelExpertTopicDao relExpertTopicDao;
	@Autowired
	InputFromJson inputFromJson;

	public TestController() {
		super();
	}

	@RequestMapping(value = "/expert", method = RequestMethod.GET)
	public String expert() {
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
//
//		 Expert ex = expertDao.getById(4);
//		 System.out.println(ex.getName());

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
		
//		List<Field> list = expertDao.getFields(6);
//		System.out.println(list.size());
		
//		Expert expert = new Expert("szq", "boy", 1, 1, 1);
//		expert.setUrl("url");
//		expertDao.addExpert(expert);
		Expert expert = expertDao.getById(12);
		expertDao.deleteExpert(expert);
		
		return "test/index";

	}

	
	@RequestMapping(value = "/field", method = RequestMethod.GET)
	public String field() {
		
//		Field field = new Field("datamine");
//		fieldDao.addField(field);
		
		Field field = fieldDao.getById(2);
//		field.setName("DATA");
//		fieldDao.updateField(field);
		
		fieldDao.deleteField(field);
//		
//		List<Field> fields = fieldDao.getAllFields();
//		System.out.println(fields.size());
//		
		return "test/index";
	}
	
	@RequestMapping(value = "/org", method = RequestMethod.GET)
	public String org() {
//		Orgnization orgnization = new Orgnization("hhu");
//		orgnizationDao.addOrgnization(orgnization);
		
		Orgnization orgnization = orgnizationDao.getById(2);
		System.out.println(orgnization.getName());
		orgnizationDao.deleteOrgnization(orgnization);
		
		List<Orgnization> orgnizations = orgnizationDao.getAllOrgnizations();
		System.out.println(orgnizations.size());
		
		return "test/index";
	}
	
	@RequestMapping(value = "/paper", method = RequestMethod.GET)
	public String paper() {

//		Paper paper = new Paper("timu", "zhaiyao");
//		paperDao.addPaper(paper);
		
//		Paper paper = paperDao.getById(2);
//		paper.setKeywords("key");
//		paperDao.updatePaper(paper);
//		paperDao.updateAbs(2, "sdiasg");
//		paperDao.updateKeywords(3, "sdhaisdfdg");
		Paper paper = paperDao.getById(2);
		paperDao.deletePaper(paper);
		
		return "test/index";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
//		User user = new User("szq", "123456", "sloriac", 1);
//		
//		Topic topic = new Topic("数据挖掘");
//		Set<Topic> topics = new HashSet<Topic>();
//		topics.add(topic);
//		user.setTopics(topics);
//		topicDao.addTopic(topic);
//		userDao.addUser(user);
		
//		User user = userDao.getById(15);
//		userDao.deleteUser(user);
		
//		List<Topic> topics = userDao.getFollowedTopics(15);
//		System.out.println(topics.size());
		
		return "test/index";
	}
	
	
	@RequestMapping(value = "/patent", method = RequestMethod.GET)
	public String patent() {
		patentDao.updateAbs(0, "afakgakf");
		return "test/index";
	}
	
	@RequestMapping(value = "/testPaperAvg", method = RequestMethod.GET)
	public String test1() {
		System.out.println(expertDao.getPaperAvg());
		return "test/index";
	}
	
	@RequestMapping(value = "/testPaperKey", method = RequestMethod.GET)
	public String test2() {
		Map<String, Integer> map = expertDao.getPaperKey(59);
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, Integer> entry = iterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		return "test/index";
	}
	
	@RequestMapping(value = "/testInput", method = RequestMethod.GET)
	public String test3() {
//		inputFromJson.inputPaper("paperData.txt");
		inputFromJson.inputPatent("patentData.txt");
		return "test/index";
	}
}
