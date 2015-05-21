package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Topic;
import com.dag.robot.entities.User;

public interface UserDao {
	
	/**
	 * 添加用户
	 * @param user 用户信息
	 */
	public void addUser(User user);
	
	/**
	 * 更新用户信息
	 * @param user 用户信息
	 */
	public void updateUser(User user);
	
	/**
	 * 根据主键检索用户
	 * @param userId 用户id
	 * @return
	 */
	public User getById(int userId);
	
	/**
	 * 获得全部用户信息
	 * @return 用户List
	 */
	public List<User> getAllUsers();
	
	/**
	 * 删除用户
	 * @param user 用户信息
	 */
	public void deleteUser(User user);
	
	/**
	 * 检索用户关注的专家信息
	 * @param userId 用户id
	 * @return 专家List
	 */
	public List<Expert> getFollowedExperts(int userId);
	
	/**
	 * 检索用户关注的用户信息
	 * @param userId 用户id
	 * @return 用户List
	 */
	public List<Field> getFollowedFields(int userId);
	
	/**
	 * 检索用户关注的话题信息
	 * @param userId 用户id
	 * @return 话题List
	 */
	public List<Topic> getFollowedTopics(int userId);
	
	/**
	 * 存储用户关注专家
	 * @param user
	 * @param expert
	 */
	public void followExpert(User user, Expert expert);
	
	/**
	 * 存储用户关注话题
	 * @param user
	 * @param topic
	 */
	public void followTopic(User user, Topic topic);
	
	/**
	 * 存储用户关注领域
	 * @param user
	 * @param field
	 */
	public void followField(User user, Field field);
	
}
