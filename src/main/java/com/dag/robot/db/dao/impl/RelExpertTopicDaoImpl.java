package com.dag.robot.db.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.db.dao.TopicDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.RelExpertTopic;
import com.dag.robot.entities.Topic;
import com.mysql.fabric.xmlrpc.base.Array;

@Repository("relExpertTopicDao")
public class RelExpertTopicDaoImpl extends BaseDao implements RelExpertTopicDao{

	@Autowired
	@Qualifier("topicDao")
	private TopicDao topicDao;
	
	@Override
	public void addRelExeprtTopic(RelExpertTopic relExpertTopic) {
		save(relExpertTopic);
	}
	@Override
	public List<Expert> searchExpertsByTopics(String topic, int num) {
		Topic topic2 = topicDao.getByName(topic);
		if(topic2 == null){
			//没有匹配的,寻找同义词
		}
		Query query = query("from RelExpertTopic as ret where ret.id.topicId = ? order by ret.weight desc");
		query.setInteger(0, topic2.getTopicId());
		query.setMaxResults(num);
		List<RelExpertTopic> relExpertTopics = query.list();
		List<Expert> experts = new ArrayList<Expert>();
		Iterator<RelExpertTopic> iterator = relExpertTopics.iterator();
		while(iterator.hasNext()){
			RelExpertTopic relExpertTopic = iterator.next();
			Expert expert = relExpertTopic.getExpert();
			experts.add(expert);
		}
		return experts;
	}
	
	
}
