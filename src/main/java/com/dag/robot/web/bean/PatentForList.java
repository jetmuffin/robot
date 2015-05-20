package com.dag.robot.web.bean;

import java.util.Date;
import java.util.List;

import com.dag.robot.entities.Expert;

public class PatentForList {
	private int patentId;
	private String title;
	private Date date;
	private String applicant;
	private String inventor;
	
	public PatentForList() {
		super();
	}

	public PatentForList(int patentId, String title, Date date,
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
