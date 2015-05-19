package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Journal;

public interface JournalDao {
	
	/**
	 * 添加期刊
	 * @param journal 期刊信息
	 */
	public void addJournal(Journal journal);
	
	/**
	 * 更新期刊信息
	 * @param journal 期刊信息
	 */
	public void updateJournal(Journal journal);
	
	/**
	 * 根据主键检索期刊
	 * @param journalId 期刊id
	 * @return
	 */
	public Journal getById(int journalId);
	
	/**
	 * 根据名称检索期刊
	 * @param journalId 期刊id
	 * @return
	 */
	public List<Journal> getByName(String name);
	
	/**
	 * 获得全部期刊信息
	 * @return 期刊List
	 */
	public List<Journal> getAllJournals();
	
	/**
	 * 删除期刊
	 * @param journal 期刊信息
	 */
	public void deleteJournal(Journal journal);

	/**
	 * 根据名称查重
	 * @param name
	 * @return
	 */
	public List<Journal> check(String name);
}
