package com.dag.robot.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.RelExpertTopicDao;
import com.dag.robot.entities.RelExpertTopic;

@Repository("relExpertTopicDao")
public class RelExpertTopicDaoImpl extends BaseDao implements RelExpertTopicDao{

	@Override
	public void addRelExeprtTopic(RelExpertTopic relExpertTopic) {
		save(relExpertTopic);
	}
	
}
