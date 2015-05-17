package com.dag.robot.web.bean;

public class PaperForList {
	
	private Integer paperId;
	private String title;
	private String abs;
	private String keywords;
	private String journal;
	private String topic;
	public PaperForList() {
		super();
	}
	public PaperForList(Integer paperId, String title, String abs,
			String keywords, String journal, String topic) {
		super();
		this.paperId = paperId;
		this.title = title;
		this.abs = abs;
		this.keywords = keywords;
		this.journal = journal;
		this.topic = topic;
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

}
