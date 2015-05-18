package com.dag.robot.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.ConferenceDao;
import com.dag.robot.entities.Conference;


@Repository("conferenceDao")
public class ConferenceDaoImpl extends BaseDao implements ConferenceDao{

	@Override
	public void addConference(Conference conference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateConference(Conference conference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conference getById(int conferenceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conference getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conference> getAllConferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteConference(Conference conference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Conference> check(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
