package com.dag.robot.entities;

// Generated 2015-5-20 18:46:20 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelFieldTopic generated by hbm2java
 */
@Entity
@Table(name = "rel_field_topic", catalog = "db_expert_robot")
public class RelFieldTopic implements java.io.Serializable {

	private RelFieldTopicId id;
	private Field field;
	private Topic topic;
	private Integer relationType;

	public RelFieldTopic() {
	}

	public RelFieldTopic(RelFieldTopicId id, Field field, Topic topic) {
		this.id = id;
		this.field = field;
		this.topic = topic;
	}

	public RelFieldTopic(RelFieldTopicId id, Field field, Topic topic,
			Integer relationType) {
		this.id = id;
		this.field = field;
		this.topic = topic;
		this.relationType = relationType;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "fieldId", column = @Column(name = "fieldId", nullable = false)),
			@AttributeOverride(name = "topicId", column = @Column(name = "topicId", nullable = false)) })
	public RelFieldTopicId getId() {
		return this.id;
	}

	public void setId(RelFieldTopicId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fieldId", nullable = false, insertable = false, updatable = false)
	public Field getField() {
		return this.field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topicId", nullable = false, insertable = false, updatable = false)
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Column(name = "relationType")
	public Integer getRelationType() {
		return this.relationType;
	}

	public void setRelationType(Integer relationType) {
		this.relationType = relationType;
	}

}
