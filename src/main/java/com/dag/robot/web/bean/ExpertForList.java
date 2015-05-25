package com.dag.robot.web.bean;

public class ExpertForList {
	
	private Integer expertId;
	private String name;
	private String gender;
	private String email;
	private String org;
	private int paperNum = 0;
	private int patentNum = 0;
	private int paperReferedNum = 0;
	private int rate = 0;
	public ExpertForList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpertForList(Integer expertId, String name, String gender,
			String email, String org, int paperNum, int patentNum) {
		super();
		this.expertId = expertId;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.org = org;
		this.paperNum = paperNum;
		this.patentNum = patentNum;
	}
	public Integer getExpertId() {
		return expertId;
	}
	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public int getPaperNum() {
		return paperNum;
	}
	public void setPaperNum(int paperNum) {
		this.paperNum = paperNum;
	}
	public int getPatentNum() {
		return patentNum;
	}
	public void setPatentNum(int patentNum) {
		this.patentNum = patentNum;
	}
	public int getPaperReferedNum() {
		return paperReferedNum;
	}
	public void setPaperReferedNum(int paperReferedNum) {
		this.paperReferedNum = paperReferedNum;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
