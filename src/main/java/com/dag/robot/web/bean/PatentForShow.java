package com.dag.robot.web.bean;

import java.util.Date;
import java.util.List;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;

public class PatentForShow {
	private int patentId;
	private String title;
	private String abs;
	private Date date;
	private String applicant;
	private String inventor;
	private List<Expert> experts;
	private Orgnization orgnization;
	private String type;
	
	public PatentForShow() {
		super();
	}

	public PatentForShow(int patentId, String title, String abs, Date date,
			String applicant, String inventor, List<Expert> experts,
			Orgnization orgnization, String type) {
		super();
		this.patentId = patentId;
		this.title = title;
		this.abs = abs;
		this.date = date;
		this.applicant = applicant;
		this.inventor = inventor;
		this.experts = experts;
		this.orgnization = orgnization;
		this.type = type;
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

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
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

	public List<Expert> getExperts() {
		return experts;
	}

	public void setExperts(List<Expert> experts) {
		this.experts = experts;
	}

	public Orgnization getOrgnization() {
		return orgnization;
	}

	public void setOrgnization(Orgnization orgnization) {
		this.orgnization = orgnization;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
