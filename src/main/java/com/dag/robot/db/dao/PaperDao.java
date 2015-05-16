package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Paper;

public interface PaperDao {
	
	/**
	 * 添加领域
	 * @param Paper 领域信息
	 */
	public void addPaper(Paper paper);
	
	/**
	 * 更新领域信息
	 * @param Paper 领域信息
	 */
	public void updatePaper(Paper paper);
	
	/**
	 * 根据主键检索领域
	 * @param PaperId 领域id
	 * @return
	 */
	public Paper getById(int paperId);
	
	/**
	 * 获得全部领域信息
	 * @return 领域List
	 */
	public List<Paper> getAllPapers();
	
	/**
	 * 删除领域
	 * @param Paper 领域信息
	 */
	public void deletePaper(Paper paper);
}
