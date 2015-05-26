package com.dag.robot.web.bean;

import com.dag.robot.entities.Field;

public class TopicForShow {
	
	private Integer topicId;
	private String name;
	private Field field;
	public TopicForShow(Integer topicId, String name, Field field) {
		super();
		this.topicId = topicId;
		this.name = name;
		this.field = field;
	}
	public TopicForShow() {
		super();
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}

}
