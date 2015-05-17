package com.dag.robot.db.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.PatentDao;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertPatent;
import com.dag.robot.utils.EntitiesForListUtil;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PatentForList;

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

	@Override
	public Page<PatentForList> page(int pageSize, int currenPage) {
		Query query = query("select count(*) from Patent");
		Long totalCount =  (Long) query.uniqueResult();
		Page<PatentForList> page = new Page<PatentForList>(currenPage, pageSize, totalCount);
		page.init();
		query = query("from Patent");
		query.setFirstResult((currenPage-1) * pageSize);
		query.setMaxResults(pageSize);
		List<Patent> patents = query.list();
		List<PatentForList> patentForLists = EntitiesForListUtil.patentForLists(patents);
		page.setList(patentForLists);
		return page;
	}

}
