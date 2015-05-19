package com.dag.robot.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.ConferenceDao;
import com.dag.robot.entities.Conference;


@Repository("conferenceDao")
public class ConferenceDaoImpl extends BaseDao implements ConferenceDao{

	@Override
	public void addConference(Conference conference) {
		save(conference);
	}

	@Override
	public void updateConference(Conference conference) {
		update(conference);
	}

	@Override
	public Conference getById(int conferenceId) {
		Conference conference = get(Conference.class, conferenceId);
		return conference;
	}

	@Override
	public List<Conference> getByName(String name) {
		String hql = "from Conference as con where con.name = ?";
		List<Conference> conferences = query(hql).setString(0, name).list();
		return conferences;
	}

	@Override
	public List<Conference> getAllConferences() {
		List<Conference> conferences = getAll("Conference");
		return conferences;
	}

	@Override
	public void deleteConference(Conference conference) {
		delete(conference);
	}

	@Override
	public Conference check(String name) {
		List<Conference> conferences = getByName(name); 
		if(conferences.size() == 0 || conferences == null)
			return null;
		return conferences.get(0);
	}

}
