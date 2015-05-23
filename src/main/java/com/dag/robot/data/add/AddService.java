package com.dag.robot.data.add;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dag.robot.db.dao.ConferenceDao;
import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.db.dao.FieldDao;
import com.dag.robot.db.dao.JournalDao;
import com.dag.robot.db.dao.OrgnizationDao;
import com.dag.robot.db.dao.PaperDao;
import com.dag.robot.db.dao.PatentDao;
import com.dag.robot.db.dao.RelExpertPaperDao;
import com.dag.robot.db.dao.RelExpertPatentDao;
import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.RelFieldTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.db.dao.impl.SessionDao;
import com.dag.robot.entities.Conference;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Journal;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelExpertPaperId;
import com.dag.robot.entities.RelExpertPatent;
import com.dag.robot.entities.RelExpertPatentId;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.entities.RelExpertTopicId;
import com.dag.robot.entities.RelFieldTopic;
import com.dag.robot.entities.RelFieldTopicId;
import com.dag.robot.entities.Topic;
import com.dag.robot.utils.DateUtil;
import com.dag.robot.utils.StringSplitUtil;

@Service
public class AddService {

	private static String dbPath = "/home/sloriac/neoOut";

	@Autowired
	private SessionDao sessionDao;

	@Autowired
	private AddToNeo addToNeo;

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
	@Qualifier("relExpertPaperDao")
	private RelExpertPaperDao relExpertPaperDao;

	@Autowired
	@Qualifier("paperDao")
	private PaperDao paperDao;

	@Autowired
	@Qualifier("conferenceDao")
	private ConferenceDao conferenceDao;

	@Autowired
	@Qualifier("journalDao")
	private JournalDao journalDao;

	@Autowired
	@Qualifier("orgnizationDao")
	private OrgnizationDao orgnizationDao;

	@Autowired
	@Qualifier("patentDao")
	private PatentDao patentDao;

	@Autowired
	@Qualifier("relExpertPatentDao")
	private RelExpertPatentDao relExpertPatentDao;

	@Autowired
	@Qualifier("fieldDao")
	private FieldDao fieldDao;

	@Autowired
	@Qualifier("relFieldTopicDao")
	private RelFieldTopicDao relFieldTopicDao;

	public void addExpert(String name, String gender, String email,
			String address, String homepage, String experience, String info,
			String topic, String achievement, String orgnization, Integer age,
			String area, String field) {

		Expert expert = expertDao.checkSame(name, orgnization);
		if (expert == null) {//没有重复
			// 必要资料信息
			expert = new Expert(name, gender, email, address, homepage,
					experience, info, achievement);

			// 可空信息
			if (age != null)
				expert.setAge(age);
			if (area != null)
				expert.setArea(area);

			// 领域查重
			Field field2 = fieldDao.getByName(field);
			if (field2 == null) {
				// 没有重名的
				field2 = new Field(field);
				fieldDao.addField(field2);
			}
			expert.setField(field2);

			// 组织查重
			List<Orgnization> orgnizations = orgnizationDao
					.getByName(orgnization);
			Orgnization orgnization1 = new Orgnization();
			if (orgnizations.size() == 0 || orgnizations == null) {
				orgnization1.setName(orgnization);
				orgnizationDao.addOrgnization(orgnization1);
			} else {
				orgnization1 = orgnizations.get(0);
			}
			expert.setOrgnization(orgnization1);
			expertDao.addExpert(expert);

			addToNeo.begin();

			// 将关系写入neo4j
			addToNeo.addExpertField(expert.getExpertId(), expert.getName(),
					field2.getFieldId(), field2.getName());
			// 将关系写入neo4j
			addToNeo.addExpertOrg(expert.getExpertId(), expert.getName(),
					orgnization1.getOrgId(), orgnization1.getName());

			List<String> topics = StringSplitUtil.stringSplit(topic);
			for (int i = 0; i < topics.size(); i++) {
				Topic topic1 = topicDao.getByName(topics.get(i));
				if (topic1 == null) {
					topic1 = new Topic(topics.get(i));
					topicDao.addTopic(topic1);
				}
				RelExpertTopicId relExpertTopicId = new RelExpertTopicId(
						expert.getExpertId(), topic1.getTopicId());
				RelExpertTopic relExpertTopic = new RelExpertTopic(
						relExpertTopicId, expert, topic1);
				relExpertTopicDao.addRelExeprtTopic(relExpertTopic);

				RelFieldTopicId relFieldTopicId = new RelFieldTopicId(
						field2.getFieldId(), topic1.getTopicId());
				RelFieldTopic relFieldTopic = new RelFieldTopic(
						relFieldTopicId, field2, topic1);
				relFieldTopicDao.addRelFieldTopic(relFieldTopic);
				sessionDao.evict(topic1);
				sessionDao.evict(field2);
				sessionDao.evict(expert);
				sessionDao.evict(relFieldTopic);
				// 保存关系到图数据库
				addToNeo.addExpertTopic(expert.getExpertId(), expert.getName(),
						topic1.getTopicId(), topic1.getName());

				addToNeo.addTopicField(topic1.getTopicId(), topic1.getName(),
						field2.getFieldId(), field2.getName());
				// 关闭连接
				addToNeo.finish();
			}
		}
	}

	public void addPaper(String title, String[] authors, String abs,
			String keywords, String type, String journal, String issue,
			String conference, String time, String orgnization) {
		Paper paper = new Paper();
		paper.setTitle(title);
		paper.setAbs(abs);
		paper.setKeywords(keywords);
		paper.setType(type);
		addToNeo.begin();
		if (type.equals("journal")) {
			Journal journal2 = journalDao.check(journal);
			// 没有重复
			if (journal2 == null) {
				journal2 = new Journal(journal);
				journalDao.addJournal(journal2);
			}
			// 期刊与期刊号
			paper.setJournal(journal2);
			paper.setIssue(issue);
		} else if (type.equals("conference")) {
			Conference conference2 = conferenceDao.check(conference);
			// 没有重复
			if (conference2 == null) {
				conference2 = new Conference(conference, 0);
				conferenceDao.addConference(conference2);
			}
			paper.setConference(conference2);
			try {
				paper.setConferenceDate(DateUtil.toDate(time, "yyyy年mm月dd日"));
			} catch (ParseException e) {
				paper.setConferenceDate(null);
				e.printStackTrace();
			}
		}
		// 组织查重
		Orgnization orgnization2 = orgnizationDao.check(orgnization);
		if (orgnization2 == null) {
			// 没有重复
			orgnization2 = new Orgnization(orgnization);
			orgnizationDao.addOrgnization(orgnization2);
		}
		paper.setOrgnization(orgnization2);
		addToNeo.setDB_PATH(dbPath);
		paperDao.addPaper(paper);

		// 作者查重
		for (int i = 0; i < authors.length; i++) {
			Expert expert = expertDao.checkSame(authors[i], orgnization);
			if (expert == null) {
				// 没有重复
				expert = new Expert(authors[i], "男", 0, 0, 0);
				expert.setOrgnization(orgnization2);
				expertDao.addExpert(expert);
			}
			RelExpertPaperId relExpertPaperId = new RelExpertPaperId(
					expert.getExpertId(), paper.getPaperId());
			RelExpertPaper relExpertPaper = new RelExpertPaper(
					relExpertPaperId, expert, paper, i + 1);
			relExpertPaperDao.addRelExeprtPaper(relExpertPaper);

			addToNeo.addExpertPaper(expert.getExpertId(), expert.getName(),
					paper.getPaperId(), paper.getTitle());

			addToNeo.finish();
		}
	}

	public void addPatent(String title, String applicant, String abs,
			String organization, String[] inventors, String date,
			String orgnization) throws ParseException {

		Patent patent = new Patent();
		patent.setTitle(title);
		patent.setAbs(abs);
		patent.setApplicant(applicant);
		patent.setInventor(inventors[0]);
		patent.setDate(DateUtil.toDate(date, "yyyy/mm/dd"));

		// 组织查重
		Orgnization orgnization2 = orgnizationDao.check(orgnization);
		if (orgnization2 == null) {
			// 没有重复
			orgnization2 = new Orgnization(orgnization);
			orgnizationDao.addOrgnization(orgnization2);
		}
		patent.setOrgnization(orgnization2);

		patentDao.addPatent(patent);
		// 作者查重
		for (int i = 0; i < inventors.length; i++) {
			Expert expert = expertDao.checkSame(inventors[i], orgnization);
			if (expert == null) {
				// 没有重复
				expert = new Expert(inventors[i], "男", 0, 0, 0);
				expert.setOrgnization(orgnization2);
				expertDao.addExpert(expert);
			}
			RelExpertPatentId relExpertPatentId = new RelExpertPatentId(
					expert.getExpertId(), patent.getPatentId());
			RelExpertPatent relExpertPatent = new RelExpertPatent(
					relExpertPatentId, expert, patent, i + 1);
			relExpertPatentDao.addRelExeprtPatent(relExpertPatent);
			addToNeo.begin();
			addToNeo.addExpertPatent(expert.getExpertId(), expert.getName(),
					patent.getPatentId(), patent.getTitle());
			addToNeo.finish();
		}
	}
}
