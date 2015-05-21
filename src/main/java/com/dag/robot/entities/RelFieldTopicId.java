package com.dag.robot.entities;

// Generated 2015-5-21 16:15:36 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RelFieldTopicId generated by hbm2java
 */
@Embeddable
public class RelFieldTopicId implements java.io.Serializable {

	private int fieldId;
	private int topicId;

	public RelFieldTopicId() {
	}

	public RelFieldTopicId(int fieldId, int topicId) {
		this.fieldId = fieldId;
		this.topicId = topicId;
	}

	@Column(name = "fieldId", nullable = false)
	public int getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	@Column(name = "topicId", nullable = false)
	public int getTopicId() {
		return this.topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RelFieldTopicId))
			return false;
		RelFieldTopicId castOther = (RelFieldTopicId) other;

		return (this.getFieldId() == castOther.getFieldId())
				&& (this.getTopicId() == castOther.getTopicId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getFieldId();
		result = 37 * result + this.getTopicId();
		return result;
	}

}
