package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Topic;
import com.dag.robot.entities.User;

public interface UserDao {
	
	/**
	 * 添加领域
	 * @param user 领域信息
	 */
	public void addUser(User user);
	
	/**
	 * 更新领域信息
	 * @param user 领域信息
	 */
	public void updateUser(User user);
	
	/**
	 * 根据主键检索领域
	 * @param userId 领域id
	 * @return
	 */
	public User getById(int userId);
	
	/**
	 * 获得全部领域信息
	 * @return 领域List
	 */
	public List<User> getAllUsers();
	
	/**
	 * 删除领域
	 * @param user 领域信息
	 */
	public void deleteUser(User user);
	
	/**
	 * 检索用户关注的专家信息
	 * @param userId 用户id
	 * @return 专家List
	 */
	public List<Expert> getFollowedExperts(int userId);
	
	/**
	 * 检索用户关注的领域信息
	 * @param userId 用户id
	 * @return 领域List
	 */
	public List<Field> getFollowedFields(int userId);
	
	/**
	 * 检索用户关注的话题信息
	 * @param userId 用户id
	 * @return 话题List
	 */
	public List<Topic> getFollowedTopics(int userId);
}
