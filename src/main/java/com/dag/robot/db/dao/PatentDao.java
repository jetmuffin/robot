package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Patent;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.Page;
import com.dag.robot.web.bean.PatentForShow;

public interface PatentDao {
	
	/**
	 * 添加领域
	 * @param patent 领域信息
	 */
	public void addPatent(Patent patent);
	
	/**
	 * 更新领域信息
	 * @param patent 领域信息
	 */
	public void updatePatent(Patent patent);
	
	/**
	 * 根据主键检索领域
	 * @param patentId 领域id
	 * @return
	 */
	public Patent getById(int patentId);
	
	/**
	 * 获得全部领域信息
	 * @return 领域List
	 */
	public List<Patent> getAllPatents();
	
	/**
	 * 删除领域
	 * @param patent 领域信息
	 */
	public void deletePatent(Patent patent);
	
	/**
	 * 分页
	 * @param pageSize 每页条数
	 * @param currenPage 当前页码
	 * @return 
	 */
	public Page<PatentForShow> page(int pageSize, int currenPage);
	
	/**
	 * 修改专利摘要
	 * @param patentId
	 * @param abs
	 */
	public void updateAbs(int patentId, String abs);
	
}
