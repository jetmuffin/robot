package com.dag.robot.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.RelExpertPaperDao;
import com.dag.robot.entities.RelExpertPaper;

@Repository("relExpertPaperDao")
public class RelExpertPaperDaoImpl extends BaseDao implements RelExpertPaperDao{

	@Override
	public void addRelExeprtPaper(RelExpertPaper relExpertPaper) {
		save(relExpertPaper);
	}
	
}
