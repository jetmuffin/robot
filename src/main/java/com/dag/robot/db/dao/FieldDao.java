package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Field;

public interface FieldDao {
	
	/**
	 * 添加领域
	 * @param field 领域信息
	 */
	public void addField(Field field);
	
	/**
	 * 更新领域信息
	 * @param field 领域信息
	 */
	public void updateField(Field field);
	
	/**
	 * 根据主键检索领域
	 * @param fieldId 领域id
	 * @return
	 */
	public Field getById(int fieldId);
	
	/**
	 * 根据name检索领域
	 * @param name
	 * @return
	 */
	public Field getByName(String name);
	
	/**
	 * 获得全部领域信息
	 * @return 领域List
	 */
	public List<Field> getAllFields();
	
	/**
	 * 删除领域
	 * @param field 领域信息
	 */
	public void deleteField(Field field);
}
