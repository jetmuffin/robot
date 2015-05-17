package com.dag.robot.web.bean;

public class ExpertBean {

	private String name;
	private String org;
	public ExpertBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpertBean(String name, String org) {
		super();
		this.name = name;
		this.org = org;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	
}
