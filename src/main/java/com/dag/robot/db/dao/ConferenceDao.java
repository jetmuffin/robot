package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Conference;

public interface ConferenceDao {
	
	/**
	 * 添加领域
	 * @param conference 领域信息
	 */
	public void addConference(Conference conference);
	
	/**
	 * 更新领域信息
	 * @param conference 领域信息
	 */
	public void updateConference(Conference conference);
	
	/**
	 * 根据主键检索领域
	 * @param conferenceId 领域id
	 * @return
	 */
	public Conference getById(int conferenceId);
	
	/**
	 * 获得全部领域信息
	 * @return 领域List
	 */
	public List<Conference> getAllConferences();
	
	/**
	 * 删除领域
	 * @param conference 领域信息
	 */
	public void deleteConference(Conference conference);
}
