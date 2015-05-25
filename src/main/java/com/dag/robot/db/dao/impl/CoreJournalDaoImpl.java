package com.dag.robot.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.CoreJournalDao;
import com.dag.robot.entities.CoreJournal;


@Repository("coreJournalDao")
public class CoreJournalDaoImpl extends BaseDao implements CoreJournalDao{

	@Override
	public void addCoreJournal(CoreJournal CoreJournal) {
		save(CoreJournal);
	}

	@Override
	public void updateCoreJournal(CoreJournal CoreJournal) {
		update(CoreJournal);
	}

	@Override
	public CoreJournal getById(int CoreJournalId) {
		CoreJournal CoreJournal = get(CoreJournal.class, CoreJournalId);
		return CoreJournal;
	}

	@Override
	public CoreJournal getByName(String name) {
		String hql = "from CoreJournal as cj where cj.name = ?";
		List<CoreJournal> coreJournals = query(hql).setString(0, name).list();
		if(coreJournals != null)
			return null;
		return coreJournals.get(0);
	}

	@Override
	public List<CoreJournal> getAllCoreJournals() {
		List<CoreJournal> CoreJournals = getAll("CoreJournal");
		return CoreJournals;
	}

	@Override
	public void deleteCoreJournal(CoreJournal CoreJournal) {
		delete(CoreJournal);
	}

}
