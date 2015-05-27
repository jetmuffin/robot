package com.dag.robot.db.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.math3.analysis.function.Exp;
import org.hibernate.Query;
import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;
import org.springframework.stereotype.Repository;

import scala.Int;

import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.RelFieldTopic;
import com.dag.robot.entities.Topic;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.utils.EntitiesForListUtil;
import com.dag.robot.utils.StringSplitUtil;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.JsonData;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.tools.classfile.Annotation.element_value;

@Repository("topicDao")
public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public void addTopic(Topic topic) {
		save(topic);
	}

	@Override
	public void updateTopic(Topic topic) {
		update(topic);
	}

	@Override
	public Topic getById(int topicId) {
		return get(Topic.class, topicId);
	}

	@Override
	public List<Topic> getAllTopics() {
		return getAll("Topic");
	}

	@Override
	public void deleteTopic(Topic topic) {

		Iterator<?> iterator;

		Set<RelExpertTopic> relExpertTopics = topic.getRelExpertTopics();
		iterator = relExpertTopics.iterator();
		while (iterator.hasNext()) {
			RelExpertTopic relExpertTopic = (RelExpertTopic) iterator.next();
			delete(relExpertTopic);
		}

		Set<RelFieldTopic> relFieldTopics = topic.getRelFieldTopics();
		iterator = relFieldTopics.iterator();
		while (iterator.hasNext()) {
			RelFieldTopic relFieldTopic = (RelFieldTopic) iterator.next();
			delete(relFieldTopic);
		}

		delete(topic);
	}

	@Override
	public Topic getByName(String name) {
		String hql = "from Topic as topic where topic.name = ?";
		@SuppressWarnings("unchecked")
		List<Topic> topics = query(hql).setString(0, name).list();
		if (topics.size() == 0)
			return null;
		return topics.get(0);// 重名的只有一个
	}
	
	@Override
	public List<Expert> getExperts(String topicName) {
		Topic topic = getByName(topicName);
		Set<RelExpertTopic> relExpertTopics = topic.getRelExpertTopics();
		Iterator<RelExpertTopic> iterator = relExpertTopics.iterator();
		List<Expert> experts = new ArrayList<Expert>();
		while (iterator.hasNext()) {
			RelExpertTopic relExpertTopic = iterator.next();
			Expert expert = relExpertTopic.getExpert();
			experts.add(expert);
		}
		return experts;
	}
	
	@Override
	public List<Expert> getExperts(int topicId) {
		Topic topic = getById(topicId);
		Set<RelExpertTopic> relExpertTopics = topic.getRelExpertTopics();
		Iterator<RelExpertTopic> iterator = relExpertTopics.iterator();
		List<Expert> experts = new ArrayList<Expert>();
		while (iterator.hasNext()) {
			RelExpertTopic relExpertTopic = iterator.next();
			Expert expert = relExpertTopic.getExpert();
			experts.add(expert);
		}
		return experts;
	}

	
	@Override
	public List<JsonData> getExpertGenderDatas(int topicId) {
		List<Expert> experts = getExperts(topicId);
		int man = 0;
		int women = 0;
		for (int i = 0; i < experts.size(); i++) {
			if (experts.get(i).getGender().equals("男")) {
				man = man + 1;
			} else {
				women = women + 1;
			}
		}
		List<JsonData> jsonDatas = new ArrayList<JsonData>();
		JsonData j1 = new JsonData("男", man);
		JsonData j2 = new JsonData("女", women);
		jsonDatas.add(j1);
		jsonDatas.add(j2);
		return jsonDatas;
	}

	@Override
	public List<JsonData> getExpertOrgDatas(int topicId, int num) {
		List<Expert> experts = getExperts(topicId);
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < experts.size(); i++) {
			Expert expert = experts.get(i);
			Orgnization orgnization = expert.getOrgnization();
			String org = orgnization.getName();
			if (map.containsKey(org)) {
				int value = map.get(org);
				value = value + 1;
				map.put(org, value);
			} else {
				map.put(org, 1);
			}
		}
		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());
		// 排序
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});

		List<JsonData> jsonDatas = new ArrayList<JsonData>();
		for (int i = 0; i < entries.size(); i++) {
			Map.Entry<String, Integer> entry = entries.get(i);
			JsonData jsonData = new JsonData(entry.getKey(), entry.getValue());
			jsonDatas.add(jsonData);
		}
		return jsonDatas;
	}

	@Override
	public List<JsonData> getExpertAreaDatas(int topicId) {
		List<Expert> experts = getExperts(topicId);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < experts.size(); i++) {
			Expert expert = experts.get(i);
			String area = expert.getArea();
			if (map.containsKey(area)) {
				int value = map.get(area);
				value = value + 1;
				map.put(area, value);
			} else {
				map.put(area, 1);
			}
		}
		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());
		List<JsonData> jsonDatas = new ArrayList<JsonData>();
		for (int i = 0; i < entries.size(); i++) {
			Map.Entry<String, Integer> entry = entries.get(i);
			JsonData jsonData = new JsonData(entry.getKey(), entry.getValue());
			jsonDatas.add(jsonData);
		}
		return jsonDatas;
	}

	@Override
	public List<Topic> getTopicByFuzzyName(String name) {
		String hql = "from Topic as topic where topic.name like ?";
		Query query = query(hql);
		query.setString(0, "%" + name + "%");
		List<Topic> topics = query.list();
		return topics;
	}

	@Override
	public List<Expert> getTopTen(int topicId) {
		List<Expert> expertTemp = getExperts(topicId);
		List<Expert> experts = new ArrayList<Expert>();
		int n = experts.size();
		if(n > 10)
			n = 10;
		for(int i = 0; i < n; i++){
			experts.add(expertTemp.get(i));
		}
		Collections.sort(experts, new Comparator<Expert>() {
			public int compare(Expert o1, Expert o2) {
				return (o2.getRate() - o1.getRate());
			}
		});
		return experts;
	}
	
	@Override
	public List<JsonData> getAreaByTopic(int topicId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Expert> experts = getExperts(topicId);
		for (int i = 0; i < experts.size(); i++) {
			Expert expert = experts.get(i);
			List<String> address = StringSplitUtil.stringSplit(expert.getAddress(), "#");
			String area = address.get(2);
			if (map.containsKey(area)) {
				int val = map.get(area);
				val = val + 1;
				map.put(area, val);
			} else {
				map.put(area, 1);
			}
		}
		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());
		List<JsonData> jsonDatas = new ArrayList<JsonData>();
		for (int i = 0; i < entries.size(); i++) {
			Map.Entry<String, Integer> entry = entries.get(i);
			JsonData jsonData = new JsonData(entry.getKey(), entry.getValue());
			jsonDatas.add(jsonData);
		}
		return jsonDatas;
	}
}
