package com.dag.robot.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.StaticsDao;
import com.dag.robot.web.bean.Statics;

@Repository("staticsDao")
public class StaticsDaoImpl extends BaseDao implements StaticsDao{

	@Override
	public Statics initStatics() {
		
	}

}
