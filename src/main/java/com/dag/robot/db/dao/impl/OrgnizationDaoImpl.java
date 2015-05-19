package com.dag.robot.db.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.OrgnizationDao;
import com.dag.robot.entities.Conference;
import com.dag.robot.entities.Orgnization;

@Repository("orgnizationDao")
public class OrgnizationDaoImpl extends BaseDao implements OrgnizationDao {

	@Override
	public void addOrgnization(Orgnization orgnization) {
		save(orgnization);
	}

	@Override
	public void updateOrgnization(Orgnization orgnization) {
		update(orgnization);
	}

	@Override
	public Orgnization getById(int orgnizationId) {
		return get(Orgnization.class,orgnizationId);
	}

	@Override
	public List<Orgnization> getAllOrgnizations() {
		return getAll("Orgnization");
	}

	@Override
	public void deleteOrgnization(Orgnization orgnization) {
		delete(orgnization);
	}

	@Override
	public List<Orgnization> getByName(String orgnizationName) {
		String hql = "from Orgnization as org where org.name = ?";
		List<Orgnization> orgnizations = query(hql).setString(0, orgnizationName).list();
		return orgnizations;
	}

	@Override
	public Orgnization check(String name) {
		String hql = "from Orgnization as org where org.name = ?";
		List<Orgnization> orgnizations = query(hql).setString(0, name).list();
		if(orgnizations.size() == 0)
			return null;
		return orgnizations.get(0);
	}
	
}
