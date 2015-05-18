package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Orgnization;

public interface OrgnizationDao {
	
	/**
	 * 添加组织
	 * @param Orgnization 组织信息
	 */
	public void addOrgnization(Orgnization orgnization);
	
	/**
	 * 更新组织信息
	 * @param Orgnization 组织信息
	 */
	public void updateOrgnization(Orgnization orgnization);
	
	/**
	 * 根据主键检索组织
	 * @param OrgnizationId 组织id
	 * @return
	 */
	public Orgnization getById(int orgnizationId);
	
	/**
	 * 获得全部组织信息
	 * @return 组织List
	 */
	public List<Orgnization> getAllOrgnizations();
	
	/**
	 * 删除组织
	 * @param Orgnization 组织信息
	 */
	public void deleteOrgnization(Orgnization orgnization);
}
