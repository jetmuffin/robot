package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Paper;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PaperForShow;

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
	
	/**
	 * 分页
	 * @param pageSize 每页条数
	 * @param currenPage 当前页码
	 * @return
	 */
	public Page<PaperForShow> page(int pageSize, int currenPage);
	
	/**
	 * 修改论文的摘要
	 * @param paperId
	 * @param abs
	 */
	public void updateAbs(int paperId, String abs);
	
	/**
	 * 修改论文的关键字
	 * @param paperId
	 * @param abs
	 */
	public void updateKeywords(int paperId, String keywords);
	
	public List<PaperForShow> getAbsFuzzy(String string);
}
