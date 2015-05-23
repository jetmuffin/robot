package com.dag.robot.db.dao.impl;

import org.springframework.stereotype.Repository;

@Repository
public class SessionDao extends BaseDao{
	
	public void merge(Object object){
		getSession().merge(object);
	}
	
	public void clear(){
		getSession().clear();
	}

	public void evict(Object object){
		getSession().evict(object);
	}
}
