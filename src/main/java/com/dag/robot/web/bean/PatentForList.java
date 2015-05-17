package com.dag.robot.web.bean;

public class PatentForList {
	private int patentId;
	private String title;
	private String date;
	private String applicant;
	private String inventor;
	
	public PatentForList() {
		super();
	}
	public PatentForList(int patentId, String title, String date,
			String applicant, String inventor) {
		super();
		this.patentId = patentId;
		this.title = title;
		this.date = date;
		this.applicant = applicant;
		this.inventor = inventor;
	}
	public int getPatentId() {
		return patentId;
	}
	public void setPatentId(int patentId) {
		this.patentId = patentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getInventor() {
		return inventor;
	}
	public void setInventor(String inventor) {
		this.inventor = inventor;
	}
	
}
