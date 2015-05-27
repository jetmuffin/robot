package com.dag.robot.db.dao.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.commons.math3.analysis.function.Exp;
import org.hibernate.Query;
import org.junit.Ignore;
import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertField;
import com.dag.robot.entities.RelExpertFieldId;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelExpertPaperId;
import com.dag.robot.entities.RelExpertPatent;
import com.dag.robot.entities.RelExpertPatentId;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.entities.RelExpertTopicId;
import com.dag.robot.entities.Topic;
import com.dag.robot.utils.EntitiesForListUtil;
import com.dag.robot.utils.EntitiesForShowUtil;
import com.dag.robot.utils.StringMergeUtil;
import com.dag.robot.utils.StringSplitUtil;
import com.dag.robot.web.bean.ExpertForCheck;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.JsonData;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperKeyword;
import com.dag.robot.web.bean.PaperNumTenYears;
import com.dag.robot.web.bean.PaperRefGrade;

@Repository("expertDao")
public class ExpertDaoImpl extends BaseDao implements ExpertDao {

	@Override
	public void addExpert(Expert expert) {
		save(expert);
	}

	@Override
	public void updateExpert(Expert expert) {
		update(expert);
	}

	@Override
	public List<Expert> getByName(String name) {
		String hql = "from Expert as expert where expert.name = ?";
		@SuppressWarnings("unchecked")
		List<Expert> experts = query(hql).setString(0, name).list();
		return experts;
	}

	@Override
	public Expert getById(int expertId) {
		return get(Expert.class, expertId);
	}

	@Override
	public void deleteExpert(Expert expert) {
		delete(expert);
	}

	@Override
	public void addField(Expert expert, Field field, int weight) {

		saveOrUpdate(expert);
		saveOrUpdate(field);
		RelExpertFieldId relExpertFieldId = new RelExpertFieldId(
				expert.getExpertId(), field.getFieldId());
		RelExpertField relExpertField = new RelExpertField(relExpertFieldId,
				expert, field, weight);
		saveOrUpdate(relExpertField);
	}

	@Override
	public void addTopic(Expert expert, Topic topic, int weight) {

		saveOrUpdate(expert);
		saveOrUpdate(topic);
		RelExpertTopicId relExpertTopicId = new RelExpertTopicId(
				expert.getExpertId(), topic.getTopicId());
		RelExpertTopic relExpertTopic = new RelExpertTopic(relExpertTopicId,
				expert, topic, weight);
		saveOrUpdate(relExpertTopic);

	}

	@Override
	public void addPaper(Expert expert, Paper paper, int authorOrder) {
		saveOrUpdate(expert);
		saveOrUpdate(paper);
		RelExpertPaperId relExpertPaperId = new RelExpertPaperId(
				expert.getExpertId(), paper.getPaperId());
		RelExpertPaper relExpertPaper = new RelExpertPaper(relExpertPaperId,
				expert, paper, authorOrder);
		saveOrUpdate(relExpertPaper);
	}

	@Override
	public void addPatent(Expert expert, Patent patent, int authorOrder) {
		saveOrUpdate(expert);
		saveOrUpdate(patent);
		RelExpertPatentId relExpertPatentId = new RelExpertPatentId(
				expert.getExpertId(), patent.getPatentId());
		RelExpertPatent relExpertPatent = new RelExpertPatent(
				relExpertPatentId, expert, patent, authorOrder);
		saveOrUpdate(relExpertPatent);
	}

	@Override
	public void addOrgnization(Expert expert, Orgnization orgnization,
			String job) {
		expert.setOrgnization(orgnization);
		expert.setJob(job);
		saveOrUpdate(expert);
	}

	@Override
	public Field getField(int expertId) {
		Expert expert = getById(expertId);
		Field field = expert.getField();
		return field;
	}

	@Override
	public List<Topic> getTopics(int expertId) {
		Expert expert = getById(expertId);
		List<Topic> topics = new ArrayList<Topic>();
		Set<RelExpertTopic> relExpertTopics = expert.getRelExpertTopics();
		Iterator<RelExpertTopic> iterator = relExpertTopics.iterator();
		while (iterator.hasNext()) {
			RelExpertTopic relExpertTopic = iterator.next();
			Topic topic = relExpertTopic.getTopic();
			topics.add(topic);
		}
		if (topics.size() == 0)
			return null;
		return topics;
	}

	@Override
	public List<Paper> getPapers(int expertId) {
		Expert expert = getById(expertId);
		List<Paper> papers = new ArrayList<Paper>();
		Set<RelExpertPaper> relExpertPapers = expert.getRelExpertPapers();
		Iterator<RelExpertPaper> iterator = relExpertPapers.iterator();
		while (iterator.hasNext()) {
			RelExpertPaper relExpertPaper = iterator.next();
			Paper paper = relExpertPaper.getPaper();
			papers.add(paper);
		}
		if (papers.size() == 0)
			return null;
		return papers;
	}

	@Override
	public List<Patent> getPatents(int expertId) {
		Expert expert = getById(expertId);
		List<Patent> patents = new ArrayList<Patent>();
		Set<RelExpertPatent> relExpertPatents = expert.getRelExpertPatents();
		Iterator<RelExpertPatent> iterator = relExpertPatents.iterator();
		while (iterator.hasNext()) {
			RelExpertPatent relExpertPatent = iterator.next();
			Patent patent = relExpertPatent.getPatent();
			patents.add(patent);
		}
		if (patents.size() == 0)
			return null;
		return patents;
	}

	@Override
	public Orgnization getOrgnization(int expertId) {
		Expert expert = getById(expertId);
		Orgnization orgnization = expert.getOrgnization();
		return orgnization;
	}

	@Override
	public Page<ExpertForList> page(int pageSize, int currenPage) {
		Query query = query("select count(*) from Expert");
		Long totalCount = (Long) query.uniqueResult();
		Page<ExpertForList> page = new Page<ExpertForList>(currenPage,
				pageSize, totalCount);
		page.init();
		query = query("from Expert");
		query.setFirstResult((currenPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Expert> experts = query.list();
		List<ExpertForList> expertForLists = EntitiesForListUtil
				.expertForLists(experts);
		page.setList(expertForLists);
		return page;
	}

	@Override
	public List<ExpertForCheck> check(String expertName) {
		List<Expert> experts = getByName(expertName);
		List<ExpertForCheck> exerptForChecks = new ArrayList<ExpertForCheck>();
		if (experts.size() == 0)
			return exerptForChecks;// 表示没有重名

		for (int i = 0; i < experts.size(); i++) {
			Expert expert = experts.get(i);
			ExpertForCheck expertForCheck = new ExpertForCheck();
			expertForCheck.setName(expert.getName());
			expertForCheck.setExpertId(expert.getExpertId());
			expertForCheck.setOrg(expert.getOrgnization().getName());
			exerptForChecks.add(expertForCheck);
		}
		return exerptForChecks;
	}

	@Override
	public void updateExperience(int expertId, String experience) {
		Expert expert = getById(expertId);
		expert.setExperience(experience);
		updateExpert(expert);
	}

	@Override
	public void updateInfo(int expertId, String info) {
		Expert expert = getById(expertId);
		expert.setInfo(info);
		updateExpert(expert);
	}

	@Override
	public void updateAchievement(int expertId, String achievement) {
		Expert expert = getById(expertId);
		expert.setAchievement(achievement);
		updateExpert(expert);
	}

	@Override
	public Expert checkSame(String name, String OrgName) {
		List<Expert> experts = getByName(name);
		if (experts.size() != 0) {
			for (int i = 0; i < experts.size(); i++) {
				if (experts.get(i).getOrgnization().getName().equals(OrgName))
					return experts.get(i);
			}
		}
		return null;
	}

	@Override
	public List<ExpertForList> getByField(String field, int num) {
		String hql = "from Expert as expert where expert.field.name = ?";
		Query query = query(hql);
		query.setMaxResults(num);
		query.setString(0, field);
		List<Expert> experts = query.list();
		return EntitiesForListUtil.expertForLists(experts);
	}

	@Override
	public String getPaperAvg() {
		long expertNum = getExpertNum();
		Query query = query("select sum(expert.paperNum) from Expert as expert");
		long paperNum = (long) query.iterate().next();
		double expertNum1 = (double) expertNum;
		double paperNum1 = (double) paperNum;
		double res = paperNum1 / expertNum1;
		DecimalFormat decimalFormat = new DecimalFormat("#.0");
		String result = decimalFormat.format(res);
		if (res < 1.0) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * 暂时不需要实现
	 * @return
	 */
	@Override
	public String getPaperRate() {
		return null;
	}

	@Override
	public List<Paper> getPapersOrderByRefNum(int expertId) {
		Expert expert = getById(expertId);
		Set<RelExpertPaper> relExpertPapers = expert.getRelExpertPapers();
		if(relExpertPapers.size() == 0)
			return null;
		Iterator<RelExpertPaper> iterator = relExpertPapers.iterator();
		List<Paper> papers = new ArrayList<Paper>();
		while(iterator.hasNext()){
			RelExpertPaper relExpertPaper = iterator.next();
			Paper paper= relExpertPaper.getPaper();
			papers.add(paper);
		}
		 Collections.sort(papers, new Comparator<Paper>() {
	            public int compare(Paper arg0, Paper arg1) {
	                return arg1.getReferencedNum()-arg0.getReferencedNum();
	            }
	        });
		return papers;
	}

	@Override
	public List<PaperKeyword> getPaperKey(int expertId, int num) {
		Map<String, Integer> keywordsMap = new TreeMap<String, Integer>();
		List<Paper> papers = getPapers(expertId);
		for (int i = 0; i < papers.size(); i++) {
			Paper paper = papers.get(i);
			String keyword = paper.getKeywords();
			List<String> keywords = StringSplitUtil.stringSplit(keyword);
			for (int j = 0; j < keywords.size(); j++) {
				String key = keywords.get(j);
				// 如果包含key,value加1
				if (keywordsMap.containsKey(key)) {
					int value = keywordsMap.get(key);
					value = value + 1;
					keywordsMap.put(key, value);
				} else {
					// 第一次出现
					keywordsMap.put(key, 1);
				}
			}
		}

		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(
				keywordsMap.entrySet());

		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		List<PaperKeyword> paperKeywords = new ArrayList<PaperKeyword>();
		for (int i = 0; i < entries.size(); i++) {
			Map.Entry<String, Integer> entry = entries.get(i);
			PaperKeyword paperKeyword = new PaperKeyword(entry.getKey(),
					entry.getValue());
			paperKeywords.add(paperKeyword);
			if (paperKeywords.size() == num) {
				return paperKeywords;
			}
		}
		return paperKeywords;
	}

	@Override
	public void merge(Object object) {
		getSession().merge(object);
	}

	@Override
	public long getExpertNum() {
		Query query = query("select count(*) from Expert");
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}

	@Override
	public List<JsonData> getPaperRefInfo(int expertId) {
		List<Paper> papers = getPapers(expertId);
		int refNum = 0;
		int unRefNum = 0;
		for (int i = 0; i < papers.size(); i++) {
			if (papers.get(i).getReferencedNum() == 0) {
				unRefNum = unRefNum + 1;
			} else {
				refNum = refNum + 1;
			}
		}
		List<JsonData> jsonDatas = new ArrayList<JsonData>();
		JsonData jsonData1 = new JsonData("引用", refNum);
		JsonData jsonData2 = new JsonData("未引用", unRefNum);
		jsonDatas.add(jsonData1);
		jsonDatas.add(jsonData2);
		return jsonDatas;
	}

	@Override
	public int[] getPaperRefGrade(int expertId) {
		List<Paper> papers = getPapers(expertId);
		int g1 = 0;
		int g2 = 0;
		int g3 = 0;
		int g4 = 0;
		int g5 = 0;
		for (int i = 0; i < papers.size(); i++) {
			int refNum = papers.get(i).getReferencedNum();
			if (refNum == 0) {
				g1 = g1 + 1;
			} else if (refNum < 11) {
				g2 = g2 + 1;
			} else if (refNum < 51) {
				g3 = g3 + 1;
			} else if (refNum < 101) {
				g4 = g4 + 1;
			} else {
				g5 = g5 + 1;
			}
		}
		int num[] = new int[] { g1, g2, g3, g4, g5 };
		return num;
	}

	@Override
	public int[] getPaperNumTenYears(int expertId) {
		List<Paper> papers = getPapers(expertId);
		Calendar calendar = Calendar.getInstance();
		// 获取当前年份
		int nowYear = calendar.get(Calendar.YEAR);
		int res[] = new int[10];
		for (int i = 0; i < papers.size(); i++) {
			Paper paper = papers.get(i);
			int year = 0;
			if (paper.getType().equals("journal")) {
				year = Integer.parseInt(paper.getIssue().substring(0, 4));
			} else {
				year = paper.getConferenceDate().getYear();
			}
			for (int j = 0; j < 10; j++) {
				if (year == nowYear - j) {
					res[9 - j] = res[9 - j] + 1;
					break;
				}
			}
		}
		return res;

	}

	@Override
	public List<ExpertForShow> getByFuzzyName(String name) {
		String hql = "from Expert as expert where expert.name like ?";
		Query query = query(hql);
		query.setString(0, "%" + name + "%");
		List<Expert> experts = query.list();
		List<ExpertForShow> expertForShows = new ArrayList<ExpertForShow>();
		for (int i = 0; i < experts.size(); i++) {
			ExpertForShow expertForShow = EntitiesForShowUtil
					.expertForShow(experts.get(i));
			expertForShows.add(expertForShow);
		}
		return expertForShows;
	}

	@Override
	public List<Expert> getByField(String field) {
		String hql = "from Expert as expert where expert.fieldName = ?";
		Query query = query(hql);
		query.setString(0, field);
		List<Expert> experts = query.list();
		return experts;
	}

	@Override
	public Map<String, Integer> getAreaByField(String field) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Expert> experts = getByField(field);
		for (int i = 0; i < experts.size(); i++) {
			Expert expert = experts.get(i);
			String area = expert.getArea();
			if (map.containsKey(area)) {
				int val = map.get(area);
				val = val + 1;
				map.put(area, val);
			} else {
				map.put(area, 1);
			}
		}
		return map;
	}

	@Override
	public List<Paper> getPaperFuzzyName(int expertId, String string) {
		List<Paper> papers = getPapersOrderByRefNum(expertId);
		List<Paper> papers2 = new ArrayList<Paper>();
		for (int i = 0; i < papers.size(); i++) {
			Paper paper = papers.get(i);
			String title = paper.getTitle();
			String abs = paper.getAbs();
			// 如果标题包含关键字
			if (title.contains(string)) {
				papers2.add(paper);
			}
		}
		if (papers2.size() == 0)
			return null;
		return papers2;
	}

	@Override
	public List<Paper> getPaperFuzzyAbs(int expertId, String string) {
		List<Paper> papers = getPapersOrderByRefNum(expertId);
		List<Paper> papers2 = new ArrayList<Paper>();
		for (int i = 0; i < papers.size(); i++) {
			Paper paper = papers.get(i);
			String abs = paper.getAbs();
			String title = paper.getTitle();
			// 如果标题包含关键字，而标题不包含
			if (abs.contains(string) && (!title.contains(string))) {
				papers2.add(paper);
			}
		}
		if (papers2.size() == 0)
			return null;
		return papers2;
	}

	@Override
	public List<String> getPoint(int expertId, String string, int num) {
		List<Paper> papers = getPaperFuzzyName(expertId, string);
		List<String> resList = new ArrayList<String>();
		for (int i = 0; i < papers.size(); i++) {
			Paper paper = papers.get(i);
			String abs = paper.getAbs();
			// 如果摘要包含关键字
			if (abs.contains(string)) {
				List<String> strings = StringSplitUtil.stringSplit(abs, "。");
				for (int j = 0; j < strings.size(); j++) {
					String temp = strings.get(j);
					// 以关键字为前缀的句子
					if (temp.startsWith(string)) {
						resList.add(temp);
						if (resList.size() >= num) {
							return resList;
						}
					}
				}

			}
		}
		return resList;
	}
}
