package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Conference;

public interface ConferenceDao {
	
	/**
	 * 添加会议
	 * @param conference 会议信息
	 */
	public void addConference(Conference conference);
	
	/**
	 * 更新会议信息
	 * @param conference 会议信息
	 */
	public void updateConference(Conference conference);
	
	/**
	 * 根据主键检索会议
	 * @param conferenceId 会议id
	 * @return
	 */
	public Conference getById(int conferenceId);
	
	/**
	 * 根据名称检索会议
	 * @param conferenceId 会议id
	 * @return
	 */
	public List<Conference> getByName(String name);
	
	/**
	 * 获得全部会议信息
	 * @return 会议List
	 */
	public List<Conference> getAllConferences();
	
	/**
	 * 删除会议
	 * @param conference 会议信息
	 */
	public void deleteConference(Conference conference);

	/**
	 * 根据名称查重
	 * @param name
	 * @return
	 */
	public List<Conference> check(String name);
}
