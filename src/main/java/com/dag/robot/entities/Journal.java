package com.dag.robot.entities;

// Generated 2015-5-21 16:15:36 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Journal generated by hbm2java
 */
@Entity
@Table(name = "journal", catalog = "db_expert_robot")
public class Journal implements java.io.Serializable {

	private Integer jourId;
	private String name;
	private String url;
	private Set<Paper> papers = new HashSet<Paper>(0);

	public Journal() {
	}

	public Journal(String name) {
		this.name = name;
	}

	public Journal(String name, String url, Set<Paper> papers) {
		this.name = name;
		this.url = url;
		this.papers = papers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "jourId", unique = true, nullable = false)
	public Integer getJourId() {
		return this.jourId;
	}

	public void setJourId(Integer jourId) {
		this.jourId = jourId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", length = 50)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "journal")
	public Set<Paper> getPapers() {
		return this.papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}

}
