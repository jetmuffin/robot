package com.dag.robot.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.UserDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Topic;
import com.dag.robot.entities.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public void addUser(User user) {
		save(user);
	}

	@Override
	public void updateUser(User user) {
		update(user);
	}

	@Override
	public User getById(int userId) {
		return get(User.class,userId);
	}

	@Override
	public List<User> getAllUsers() {
		return getAll("User");
	}

	@Override
	public void deleteUser(User user) {
		delete(user);
	}

	@Override
	public List<Expert> getFollowedExperts(int userId) {
		User user = getById(userId);
		List<Expert> experts = new ArrayList<Expert>();
		experts.addAll(user.getExperts());
		if(experts.size() == 0)
			return null;
		return experts;
	}

	@Override
	public List<Field> getFollowedFields(int userId) {
		User user = getById(userId);
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(user.getFields());
		if(fields.size() == 0)
			return null;
		return fields;
	}

	@Override
	public List<Topic> getFollowedTopics(int userId) {
		User user = getById(userId);
		List<Topic> topics = new ArrayList<Topic>();
		topics.addAll(user.getTopics());
		if(topics.size() == 0)
			return null;
		return topics;
	}

	@Override
	public void followExpert(User user, Expert expert) {
		user.getExperts().add(expert);
		update(user);
	}

	@Override
	public void followTopic(User user, Topic topic) {
		user.getTopics().add(topic);
		update(topic);
	}

	@Override
	public void followField(User user, Field field) {
		user.getFields().add(field);
		update(field);
	}

}
