package com.dag.robot.web.bean;

public class ExpertForCheck {

	private int expertId;
	private String name;
	private String org;
	public ExpertForCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpertForCheck(int expertId, String name, String org) {
		super();
		this.expertId = expertId;
		this.name = name;
		this.org = org;
	}
	
	public int getExpertId() {
		return expertId;
	}
	public void setExpertId(int expertId) {
		this.expertId = expertId;
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
