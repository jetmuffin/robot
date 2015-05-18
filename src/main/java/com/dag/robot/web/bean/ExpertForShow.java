package com.dag.robot.web.bean;

import java.util.List;

import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.Topic;

public class ExpertForShow {
	private Integer expertId;
	private String name;
	private String gender;
	private String email;
	private String address;
	private String homepage;
	private int paperNum;
	private int patentNum;
	private int paperReferedNum;
	private String prize;
	private String experience;
	private String info;
	private String achievement;
	private String activity;
	private List<Paper> papers;
	private List<Patent> patents;
	private List<Topic> topics;
	private List<Orgnization> orgnizations;
	public ExpertForShow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpertForShow(Integer expertId, String name, String gender,
			String email, String address, String homepage, int paperNum,
			int patentNum, int paperReferedNum, String prize,
			String experience, String info, String achievement,
			String activity, List<Paper> papers, List<Patent> patents,
			List<Topic> topics, List<Orgnization> orgnizations) {
		super();
		this.expertId = expertId;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.homepage = homepage;
		this.paperNum = paperNum;
		this.patentNum = patentNum;
		this.paperReferedNum = paperReferedNum;
		this.prize = prize;
		this.experience = experience;
		this.info = info;
		this.achievement = achievement;
		this.activity = activity;
		this.papers = papers;
		this.patents = patents;
		this.topics = topics;
		this.orgnizations = orgnizations;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
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
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public List<Paper> getPapers() {
		return papers;
	}
	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
	public List<Patent> getPatents() {
		return patents;
	}
	public void setPatents(List<Patent> patents) {
		this.patents = patents;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public List<Orgnization> getOrgnizations() {
		return orgnizations;
	}
	public void setOrgnizations(List<Orgnization> orgnizations) {
		this.orgnizations = orgnizations;
	}
}
