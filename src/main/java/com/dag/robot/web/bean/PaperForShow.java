package com.dag.robot.web.bean;

import java.util.List;

import com.dag.robot.entities.Conference;
import com.dag.robot.entities.CoreJournal;
import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Journal;
import com.dag.robot.entities.Topic;

public class PaperForShow {
	
	private Integer paperId;
	private String title;
	private String abs;
	private String keywords;
	private int referencedNum;
	private String type;
	private Conference conferences;
	private Journal journal;
	
	private List<Topic> topics;
	private List<Expert> experts;
	private List<CoreJournal> coreJournals;

	public PaperForShow() {
		super();
	}

	public PaperForShow(Integer paperId, String title, String abs,
			String keywords, int referencedNum, String type,
			Conference conferences, Journal journal, List<Topic> topics,
			List<Expert> experts, List<CoreJournal> coreJournals) {
		super();
		this.paperId = paperId;
		this.title = title;
		this.abs = abs;
		this.keywords = keywords;
		this.referencedNum = referencedNum;
		this.type = type;
		this.conferences = conferences;
		this.journal = journal;
		this.topics = topics;
		this.experts = experts;
		this.coreJournals = coreJournals;
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

	public int getReferencedNum() {
		return referencedNum;
	}

	public void setReferencedNum(int referencedNum) {
		this.referencedNum = referencedNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Conference getConferences() {
		return conferences;
	}

	public void setConferences(Conference conferences) {
		this.conferences = conferences;
	}

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
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

	public List<CoreJournal> getCoreJournals() {
		return coreJournals;
	}

	public void setCoreJournals(List<CoreJournal> coreJournals) {
		this.coreJournals = coreJournals;
	}
}
