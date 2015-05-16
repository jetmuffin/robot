package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Topic;

public interface TopicDao {
	
	/**
	 * 添加领域
	 * @param topic 领域信息
	 */
	public void addTopic(Topic topic);
	
	/**
	 * 更新领域信息
	 * @param topic 领域信息
	 */
	public void updateTopic(Topic topic);
	
	/**
	 * 根据主键检索领域
	 * @param topicId 领域id
	 * @return
	 */
	public Topic getById(int topicId);
	
	/**
	 * 获得全部领域信息
	 * @return 领域List
	 */
	public List<Topic> getAllTopics();
	
	/**
	 * 删除领域
	 * @param topic 领域信息
	 */
	public void deleteTopic(Topic topic);
}
