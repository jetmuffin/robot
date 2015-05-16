package com.dag.robot.db.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.PatentDao;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertPatent;

@Repository("patentDao")
public class PatentDaoImpl extends BaseDao implements PatentDao {

	@Override
	public void addPatent(Patent patent) {
		save(patent);
	}

	@Override
	public void updatePatent(Patent patent) {
		update(patent);
	}

	@Override
	public Patent getById(int patentId) {
		return get(Patent.class, patentId);
	}

	@Override
	public List<Patent> getAllPatents() {
		return getAll("Patent");
	}

	@Override
	public void deletePatent(Patent patent) {

		Set<RelExpertPatent> relExpertPatents = patent.getRelExpertPatents();
		Iterator<RelExpertPatent> iterator = relExpertPatents.iterator();
		while (iterator.hasNext()) {
			RelExpertPatent relExpertPatent = iterator.next();
			delete(relExpertPatent);
		}

		delete(patent);
	}

}
