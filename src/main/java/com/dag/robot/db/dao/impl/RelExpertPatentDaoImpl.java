package com.dag.robot.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.RelExpertPatentDao;
import com.dag.robot.entities.RelExpertPatent;

@Repository("relExpertPatentDao")
public class RelExpertPatentDaoImpl extends BaseDao implements RelExpertPatentDao{

	@Override
	public void addRelExeprtPatent(RelExpertPatent relExpertPatent) {
		save(relExpertPatent);
	}
	
}
