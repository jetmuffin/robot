package com.dag.robot.db.dao;

import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForShow;
import com.dag.robot.web.bean.JsonData;

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
	
	/**
	 * 根据话题检索专家
	 * @param topic
	 * @return
	 */
	public List<Expert> getExperts(String topic);
	
	/**
	 * 获取某话题下的专家的性别统计信息
	 * @param topic　
	 * @return　
	 */
	public List<JsonData> getExpertGenderDatas(String topic);
	
	/**
	 * 
	 * @param topic
	 * @return
	 */
	public List<JsonData> getExpertOrgDatas(String topic, int num);
	
	/**
	 * 获取某方向专家的省份分布
	 * @param topic
	 * @return
	 */
	public List<JsonData> getExpertAreaDatas(String topic);
	
	/**
	 * 根据名称模糊查询
	 * @param name
	 * @return
	 */
	public List<Topic> getTopicByFuzzyName(String name);
	
}
