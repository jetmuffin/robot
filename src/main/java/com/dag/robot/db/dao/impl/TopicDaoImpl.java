package com.dag.robot.db.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.RelFieldTopic;
import com.dag.robot.entities.Topic;
import com.dag.robot.entities.RelExpertTopic;

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
		return get(Topic.class,topicId);
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
		while(iterator.hasNext()){
			RelExpertTopic relExpertTopic = (RelExpertTopic) iterator.next();
			delete(relExpertTopic);
		}
		
		Set<RelFieldTopic> relFieldTopics = topic.getRelFieldTopics();
		iterator = relFieldTopics.iterator();
		while(iterator.hasNext()){
			RelFieldTopic relFieldTopic = (RelFieldTopic) iterator.next();
			delete(relFieldTopic);
		}
		
		delete(topic);
	}
	
}
