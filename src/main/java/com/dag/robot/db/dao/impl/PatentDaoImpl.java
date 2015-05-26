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
import com.dag.robot.web.bean.PatentForShow;

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
		delete(patent);
	}

	@Override
	public Page<PatentForShow> page(int pageSize, int currenPage) {
		Query query = query("select count(*) from Patent");
		Long totalCount =  (Long) query.uniqueResult();
		Page<PatentForShow> page = new Page<PatentForShow>(currenPage, pageSize, totalCount);
		page.init();
		query = query("from Patent");
		query.setFirstResult((currenPage-1) * pageSize);
		query.setMaxResults(pageSize);
		List<Patent> patents = query.list();
		List<PatentForShow> patentForLists = EntitiesForListUtil.patentForLists(patents);
		page.setList(patentForLists);
		return page;
	}

	@Override
	public void updateAbs(int patentId, String abs) {
		Patent patent = getById(patentId);
		patent.setAbs(abs);
		update(patent);
	}

	@Override
	public List<PatentForShow> getFuzzyAbs(String string) {
		String hql = "from Patent as patent where patent.abs like ?";
		Query query = query(hql);
		query.setString(0, "%" + string + "%");
		List<Patent> patents = query.list();
		return EntitiesForListUtil.patentForLists(patents);
	}

	@Override
	public List<PatentForShow> getByFuzzyName(String name) {
		String hql = "from Patent as patent where patent.title like ?";
		Query query = query(hql);
		query.setString(0, "%" + name + "%");
		List<Patent> patents = query.list();
		return EntitiesForListUtil.patentForLists(patents);
	}

}
