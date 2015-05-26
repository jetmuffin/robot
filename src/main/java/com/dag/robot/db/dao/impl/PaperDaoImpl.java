package com.dag.robot.db.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.PaperDao;
import com.dag.robot.entities.Paper;
import com.dag.robot.utils.EntitiesForListUtil;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperForShow;

@Repository("paperDao")
public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public void addPaper(Paper paper) {
		save(paper);
	}

	@Override
	public void updatePaper(Paper paper) {
		update(paper);
	}

	@Override
	public Paper getById(int paperId) {
		return get(Paper.class,paperId);
	}

	@Override
	public List<Paper> getAllPapers() {
		return getAll("Paper");
	}

	@Override
	public void deletePaper(Paper paper) {
		delete(paper);
	}

	@Override
	public Page<PaperForShow> page(int pageSize, int currenPage) {

		Query query = query("select count(*) from Paper");
		Long totalCount =  (Long) query.uniqueResult();
		Page<PaperForShow> page = new Page<PaperForShow>(currenPage, pageSize, totalCount);
		page.init();
		query = query("from Paper");
		query.setFirstResult((currenPage-1) * pageSize);
		query.setMaxResults(pageSize);
		List<Paper> papers = query.list();
		List<PaperForShow> paperForLists = EntitiesForListUtil.paperForLists(papers);
		page.setList(paperForLists);
		return page;
	}

	@Override
	public void updateAbs(int paperId, String abs) {
		Paper paper = getById(paperId);
		paper.setAbs(abs);
		update(paper);
	}

	@Override
	public void updateKeywords(int paperId, String keywords) {
		Paper paper = getById(paperId);
		paper.setKeywords(keywords);
		update(paper);
	}

	@Override
	public List<PaperForShow> getAbsFuzzy(String string) {
		String hql = "from Paper as paper where paper.abs like ? order by referencedNum desc";
		Query query = query(hql);
		query.setString(0, "%" + string + "%");
		List<Paper> papers = query.list(); 
		return EntitiesForListUtil.paperForLists(papers);
	}

	@Override
	public List<PaperForShow> getByFuzzyName(String name) {
		String hql = "from Paper as paper where paper.title like ? order by referencedNum desc";
		Query query = query(hql);
		query.setString(0, "%" + name + "%");
		List<Paper> papers = query.list(); 
		return EntitiesForListUtil.paperForLists(papers);
	}
	
}
