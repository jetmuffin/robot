package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.CoreJournal;

public interface CoreJournalDao {
	
	/**
	 * 添加期刊
	 * @param coreJournal 期刊信息
	 */
	public void addCoreJournal(CoreJournal coreJournal);
	
	/**
	 * 更新期刊信息
	 * @param coreJournal 期刊信息
	 */
	public void updateCoreJournal(CoreJournal coreJournal);
	
	/**
	 * 根据主键检索期刊
	 * @param coreJournalId 期刊id
	 * @return
	 */
	public CoreJournal getById(int coreJournalId);
	
	/**
	 * 根据名称检索期刊
	 * @param coreJournalId 期刊id
	 * @return
	 */
	public CoreJournal getByName(String name);
	
	/**
	 * 获得全部期刊信息
	 * @return 期刊List
	 */
	public List<CoreJournal> getAllCoreJournals();
	
	/**
	 * 删除期刊
	 * @param coreJournal 期刊信息
	 */
	public void deleteCoreJournal(CoreJournal coreJournal);

}
