package com.dag.robot.web.bean;

public class NodeBean {
	int id;
	int category;	//0,1,2 叶子结点，中间节点，根节点
	String name;
	int value;
	int depth;
	public NodeBean(int iId,int iCategory,String iName,int iDepth){
		id = iId;
		category = iCategory;
		name = iName;
		value = 10 - iDepth;
	}
	public NodeBean(long iId,int iCategory,String iName,int iDepth){
		id = (int) iId;
		category = iCategory;
		name = iName;
		value = 10 - iDepth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}
