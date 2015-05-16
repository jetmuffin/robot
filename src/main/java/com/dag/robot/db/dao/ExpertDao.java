package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.Topic;

public interface ExpertDao {
	
	/**
	 * 增加专家信息
	 * @param expert 专家信息
	 */
	public void addExpert(Expert expert);
	
	/**
	 * 更新专家信息
	 * @param expert 专家信息
	 */
	public void updateExpert(Expert expert);
	
	/**
	 * 根据姓名检索专家
	 * @param name 专家姓名
	 */
	public List<Expert> getByName(String name);
	
	/**
	 * 根据id检索专家
	 * @param expertId 专家id
	 */
	public Expert getById(int expertId);
	
	/**
	 * 删除专家信息
	 * @param expert 专家
	 * 	 */
	public void deleteExpert(Expert expert);
	
	/**
	 * 增加专家相关领域
	 * @param expert 专家
	 * @param field  领域
	 * @param weight 权值
	 */
	public void addField(Expert expert, Field field, int weight);
	
	/**
	 * 增加专家相关话题
	 * @param expert 专家
	 * @param topic 话题
	 * @param weight
	 */
	public void addTopic(Expert expert, Topic topic, int weight);
	
	/**
	 * 增加专家论文信息
	 * @param expert 专家
	 * @param paper 论文
	 * @param authorNum 作者次序
	 */
	public void addPaper(Expert expert, Paper paper, int authorOrder);
	
	/**
	 * 增加专家专利信息
	 * @param expert 专家
	 * @param patent 专利
	 * @param authorOrder 作者次序
	 */
	public void addPatent(Expert expert, Patent patent, int authorOrder);
	
	/**
	 * 增加专家所属组织信息
	 * @param expert 专家
	 * @param orgnization 组织
	 * @param job 工作
	 */
	public void addOrgnization(Expert expert, Orgnization orgnization, String job);
	
	/**
	 * 检索专家领域信息
	 * @param expertId 专家id
	 * @return 领域List
	 */
	public List<Field> getFields(int expertId);
	
	/**
	 * 检索专家话题信息
	 * @param expertId 专家id
	 * @return 话题List
	 */
	public List<Topic> getTopics(int expertId);
	
	/**
	 * 检索专家论文信息
	 * @param expertId 专家id
	 * @return 论文List
	 */
	public List<Paper> getPapers(int expertId);
	
	/**
	 * 检索专家专利信息
	 * @param expertId 专家id
	 * @return 专利List
	 */
	public List<Patent> getPatents(int expertId);
	
	/**
	 * 检索专家组织信息
	 * @param expertId 专家id
	 * @return 组织List
	 */
	public List<Orgnization> getOrgs(int expertId);
}
