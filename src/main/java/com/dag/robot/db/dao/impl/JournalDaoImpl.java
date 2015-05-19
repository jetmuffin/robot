package com.dag.robot.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dag.robot.db.dao.JournalDao;
import com.dag.robot.entities.Journal;


@Repository("journalDao")
public class JournalDaoImpl extends BaseDao implements JournalDao{

	@Override
	public void addJournal(Journal journal) {
		save(journal);
	}

	@Override
	public void updateJournal(Journal journal) {
		update(journal);
	}

	@Override
	public Journal getById(int journalId) {
		Journal journal = get(Journal.class, journalId);
		return journal;
	}

	@Override
	public List<Journal> getByName(String name) {
		String hql = "from Journal journal con where journal.name = ?";
		List<Journal> journals = query(hql).setString(0, name).list();
		return journals;
	}

	@Override
	public List<Journal> getAllJournals() {
		List<Journal> journals = getAll("Journal");
		return journals;
	}

	@Override
	public void deleteJournal(Journal journal) {
		delete(journal);
	}

	@Override
	public Journal check(String name) {
		List<Journal> journals = getByName(name); 
		if(journals.size() == 0 || journals == null)
			return null;
		return journals.get(0);
	}

}
