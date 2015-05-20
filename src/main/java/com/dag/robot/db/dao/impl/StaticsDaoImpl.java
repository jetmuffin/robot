package com.dag.robot.db.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.StaticsDao;
import com.dag.robot.web.bean.Statics;

@Repository("staticsDao")
public class StaticsDaoImpl extends BaseDao implements StaticsDao{

	@Override
	public Statics initStatics() {
		Statics statics = new Statics(0, 0, 0, 0);
		Query query;
		query = query("select count(*) from Expert");
		statics.setExpertNum((Long) query.uniqueResult());
		query = query("select count(*) from Paper");
		statics.setPaperNum((long) query.uniqueResult());
		query = query("select count(*) from Patent");
		statics.setPatentNum((long) query.uniqueResult());
		query = query("select count(*) from Topic");
		statics.setTopics((long) query.uniqueResult());
		return statics;
	}

}
