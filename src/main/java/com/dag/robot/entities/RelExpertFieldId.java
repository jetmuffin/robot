package com.dag.robot.entities;

// Generated 2015-5-19 14:04:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RelExpertFieldId generated by hbm2java
 */
@Embeddable
public class RelExpertFieldId implements java.io.Serializable {

	private int expertId;
	private int fieldId;

	public RelExpertFieldId() {
	}

	public RelExpertFieldId(int expertId, int fieldId) {
		this.expertId = expertId;
		this.fieldId = fieldId;
	}

	@Column(name = "expertId", nullable = false)
	public int getExpertId() {
		return this.expertId;
	}

	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}

	@Column(name = "fieldId", nullable = false)
	public int getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RelExpertFieldId))
			return false;
		RelExpertFieldId castOther = (RelExpertFieldId) other;

		return (this.getExpertId() == castOther.getExpertId())
				&& (this.getFieldId() == castOther.getFieldId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getExpertId();
		result = 37 * result + this.getFieldId();
		return result;
	}

}
