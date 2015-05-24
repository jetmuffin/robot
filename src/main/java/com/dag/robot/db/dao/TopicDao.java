package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Topic;

public interface TopicDao {
	
	/**
	 * 添加话题
	 * @param topic 话题信息
	 */
	public void addTopic(Topic topic);
	
	/**
	 * 更新话题信息
	 * @param topic 话题信息
	 */
	public void updateTopic(Topic topic);
	
	/**
	 * 根据主键检索话题
	 * @param topicId 话题id
	 * @return
	 */
	public Topic getById(int topicId);
	
	/**
	 * 根据话题名称检索话题
	 * @param name
	 * @return
	 */
	public Topic getByName(String name);
	
	/**
	 * 获得全部话题信息
	 * @return 话题List
	 */
	public List<Topic> getAllTopics();
	
	/**
	 * 删除话题
	 * @param topic 话题信息
	 */
	public void deleteTopic(Topic topic);
}
