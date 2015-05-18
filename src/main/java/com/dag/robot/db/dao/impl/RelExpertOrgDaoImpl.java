package com.dag.robot.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.RelExpertOrgDao;
import com.dag.robot.entities.RelExpertOrg;

@Repository("relExpertOrgDao")
public class RelExpertOrgDaoImpl extends BaseDao implements RelExpertOrgDao{

	@Override
	public void addRelExeprtOrg(RelExpertOrg relExpertOrg) {
		save(relExpertOrg);
	}

}
