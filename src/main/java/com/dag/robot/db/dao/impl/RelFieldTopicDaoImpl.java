package com.dag.robot.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.RelFieldTopicDao;
import com.dag.robot.entities.RelFieldTopic;

@Repository("relFieldTopicDao")
public class RelFieldTopicDaoImpl extends BaseDao implements RelFieldTopicDao {

	@Override
	public void addRelFieldTopic(RelFieldTopic relFieldTopic) {
		saveOrUpdate(relFieldTopic);
	}

}
