package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.RelExpertTopic;

public interface RelExpertTopicDao {
	
	/**
	 * 存储专家话题的关联信息
	 * @param relExpertTopic
	 */
	public void addRelExeprtTopic(RelExpertTopic relExpertTopic);
	
	/**
	 * 根据话题检索相关专家
 	 * @param topic 话题
	 * @param num 检索专家的数量(按照评级排序)
	 * @return
	 */
	public List<Expert> searchExpertsByTopics(String topic, int num);

}
