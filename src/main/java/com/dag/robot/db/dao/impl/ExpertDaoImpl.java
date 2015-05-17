package com.dag.robot.db.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.ExpertDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertField;
import com.dag.robot.entities.RelExpertFieldId;
import com.dag.robot.entities.RelExpertOrg;
import com.dag.robot.entities.RelExpertOrgId;
import com.dag.robot.entities.RelExpertPaper;
import com.dag.robot.entities.RelExpertPaperId;
import com.dag.robot.entities.RelExpertPatent;
import com.dag.robot.entities.RelExpertPatentId;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.entities.RelExpertTopicId;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.Page;

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
		Iterator<?> iterator;
		
		Set<RelExpertField> relExpertFields = expert.getRelExpertFields();
		iterator = relExpertFields.iterator();
		while (iterator.hasNext()) {
			RelExpertField relExpertField = (RelExpertField) iterator.next();
			delete(relExpertField);
		}
		
		Set<RelExpertOrg> relExpertOrgs = expert.getRelExpertOrgs();
		iterator = relExpertOrgs.iterator();
		while(iterator.hasNext()){
			RelExpertOrg relExpertOrg = (RelExpertOrg) iterator.next();
			delete(relExpertOrg);
		}
		
		Set<RelExpertPaper> relExpertPapers = expert.getRelExpertPapers();
		iterator = relExpertPapers.iterator();
		while(iterator.hasNext()){
			RelExpertPaper relExpertPaper = (RelExpertPaper) iterator.next();
			delete(relExpertPaper);
		}
		
		Set<RelExpertPatent> relExpertPatents = expert.getRelExpertPatents();
		iterator = relExpertPatents.iterator();
		while(iterator.hasNext()){
			RelExpertPatent relExpertPatent = (RelExpertPatent) iterator.next();
			delete(relExpertPatent);
		}
		
		Set<RelExpertTopic> relExpertTopics = expert.getRelExpertTopics();
		iterator = relExpertTopics.iterator();
		while(iterator.hasNext()){
			RelExpertTopic relExpertTopic = (RelExpertTopic) iterator.next();
			delete(relExpertTopic);
		}
		
		delete(expert);
	}

	@Override
	public void addField(Expert expert, Field field, int weight) {

		saveOrUpdate(expert);
		saveOrUpdate(field);
		RelExpertFieldId relExpertFieldId = new RelExpertFieldId(expert.getExpertId(),
				field.getFieldId());
		RelExpertField relExpertField = new RelExpertField(relExpertFieldId, expert, field,
				weight);
		saveOrUpdate(relExpertField);
	}

	@Override
	public void addTopic(Expert expert, Topic topic, int weight) {

		saveOrUpdate(expert);
		saveOrUpdate(topic);
		RelExpertTopicId relExpertTopicId = new RelExpertTopicId(expert.getExpertId(),
				topic.getTopicId());
		RelExpertTopic relExpertTopic = new RelExpertTopic(relExpertTopicId, expert, topic,
				weight);
		saveOrUpdate(relExpertTopic);

	}

	@Override
	public void addPaper(Expert expert, Paper paper, int authorOrder) {
		saveOrUpdate(expert);
		saveOrUpdate(paper);
		RelExpertPaperId relExpertPaperId = new RelExpertPaperId(expert.getExpertId(),
				paper.getPaperId());
		RelExpertPaper relExpertPaper = new RelExpertPaper(relExpertPaperId, expert, paper,
				authorOrder);
		saveOrUpdate(relExpertPaper);
	}

	@Override
	public void addPatent(Expert expert, Patent patent, int authorOrder) {
		saveOrUpdate(expert);
		saveOrUpdate(patent);
		RelExpertPatentId relExpertPatentId = new RelExpertPatentId(expert.getExpertId(),
				patent.getPatentId());
		RelExpertPatent relExpertPatent = new RelExpertPatent(relExpertPatentId, expert,
				patent, authorOrder);
		saveOrUpdate(relExpertPatent);
	}

	@Override
	public void addOrgnization(Expert expert, Orgnization orgnization,
			String job) {
		saveOrUpdate(expert);
		saveOrUpdate(orgnization);
		RelExpertOrgId relExpertOrgId = new RelExpertOrgId(expert.getExpertId(),
				orgnization.getOrgId());
		RelExpertOrg relExpertOrg = new RelExpertOrg(relExpertOrgId, expert, orgnization,
				job);
		saveOrUpdate(relExpertOrg);
	}

	@Override
	public List<Field> getFields(int expertId) {
		Expert expert = getById(expertId);
		List<Field> fields = new ArrayList<Field>();
		Set<RelExpertField> relExpertFields = expert.getRelExpertFields();
		Iterator<RelExpertField> iterator = relExpertFields.iterator();
		while(iterator.hasNext()){
			RelExpertField relExpertField = iterator.next();
			Field field = relExpertField.getField();
			fields.add(field);
		}
		if(fields.size() == 0)
			return null;
		return fields;
	}

	@Override
	public List<Topic> getTopics(int expertId) {
		Expert expert = getById(expertId);
		List<Topic> topics = new ArrayList<Topic>();
		Set<RelExpertTopic> relExpertTopics = expert.getRelExpertTopics();
		Iterator<RelExpertTopic> iterator = relExpertTopics.iterator();
		while(iterator.hasNext()){
			RelExpertTopic relExpertTopic = iterator.next();
			Topic topic = relExpertTopic.getTopic();
			topics.add(topic);
		}
		if(topics.size() == 0)
			return null;
		return topics;
	}

	@Override
	public List<Paper> getPapers(int expertId) {
		Expert expert = getById(expertId);
		List<Paper> papers = new ArrayList<Paper>();
		Set<RelExpertPaper> relExpertPapers = expert.getRelExpertPapers();
		Iterator<RelExpertPaper> iterator = relExpertPapers.iterator();
		while(iterator.hasNext()){
			RelExpertPaper relExpertPaper = iterator.next();
			Paper paper = relExpertPaper.getPaper();
			papers.add(paper);
		}
		if(papers.size() == 0)
			return null;
		return papers;
	}

	@Override
	public List<Patent> getPatents(int expertId) {
		Expert expert = getById(expertId);
		List<Patent> patents = new ArrayList<Patent>();
		Set<RelExpertPatent> relExpertPatents = expert.getRelExpertPatents();
		Iterator<RelExpertPatent> iterator = relExpertPatents.iterator();
		while(iterator.hasNext()){
			RelExpertPatent relExpertPatent = iterator.next();
			Patent patent = relExpertPatent.getPatent();
			patents.add(patent);
		}
		if(patents.size() == 0)
			return null;
		return patents;
	}

	@Override
	public List<Orgnization> getOrgs(int expertId) {
		Expert expert = getById(expertId);
		List<Orgnization> orgnizations = new ArrayList<Orgnization>();
		Set<RelExpertOrg> relExpertOrgs = expert.getRelExpertOrgs();
		Iterator<RelExpertOrg> iterator = relExpertOrgs.iterator();
		while(iterator.hasNext()){
			RelExpertOrg relExpertOrg = iterator.next();
			Orgnization orgnization = relExpertOrg.getOrgnization();
			orgnizations.add(orgnization);
		}
		if(orgnizations.size() == 0)
			return null;
		return orgnizations;
	}

	@Override
	public Page<Expert> page(int pageSize, int currenPage) {
		Query query = query("select count(*) from Expert");
		Long totalCount =  (Long) query.uniqueResult();
		Page<Expert> page = new Page<Expert>(currenPage, pageSize, totalCount);
		page.init();
		query = query("from Expert");
		query.setFirstResult((currenPage-1) * pageSize);
		query.setMaxResults(pageSize);
		List<Expert> experts = query.list();
		page.setList(experts);
		return page;
	}

	
}
