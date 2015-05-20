package com.dag.robot.web.bean;

public class Statics {
	
	private long expertNum;
	private long paperNum;
	private long patentNum;
	private long topics;
	
	public Statics() {
		super();
	}

	public Statics(long expertNum, long paperNum, long patentNum, long topics) {
		super();
		this.expertNum = expertNum;
		this.paperNum = paperNum;
		this.patentNum = patentNum;
		this.topics = topics;
	}

	public long getExpertNum() {
		return expertNum;
	}

	public void setExpertNum(long expertNum) {
		this.expertNum = expertNum;
	}

	public long getPaperNum() {
		return paperNum;
	}

	public void setPaperNum(long paperNum) {
		this.paperNum = paperNum;
	}

	public long getPatentNum() {
		return patentNum;
	}

	public void setPatentNum(long patentNum) {
		this.patentNum = patentNum;
	}

	public long getTopics() {
		return topics;
	}

	public void setTopics(long topics) {
		this.topics = topics;
	}
}
