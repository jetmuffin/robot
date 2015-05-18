package com.dag.robot.web.bean;

import java.util.List;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Topic;

public class PaperForList {
	
	private Integer paperId;
	private String title;
	private String abs;
	private String keywords;
	private String journal;
	private List<Topic> topics;
	private List<Expert> experts;
	public PaperForList() {
		super();
	}
	public PaperForList(Integer paperId, String title, String abs,
			String keywords, String journal, List<Topic> topics, List<Expert> experts) {
		super();
		this.paperId = paperId;
		this.title = title;
		this.abs = abs;
		this.keywords = keywords;
		this.journal = journal;
		this.topics = topics;
		this.experts = experts;
	}


	public Integer getPaperId() {
		return paperId;
	}
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
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
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public List<Expert> getExperts() {
		return experts;
	}
	public void setExperts(List<Expert> experts) {
		this.experts = experts;
	}
}
