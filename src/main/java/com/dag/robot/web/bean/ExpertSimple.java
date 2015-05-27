package com.dag.robot.web.bean;

public class ExpertSimple {
	
	private int expertId;
	private String name;
	private String org;
	private String url;
	private int rate;
	public ExpertSimple() {
		super();
	}
	public ExpertSimple(int expertId, String name, String org, String url, int rate) {
		super();
		this.expertId = expertId;
		this.name = name;
		this.org = org;
		this.url = url;
		this.rate = rate;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
