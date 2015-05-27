package com.dag.robot.web.bean;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;

public class ExpertSimple {
	
	private int expertId;
	private String name;
	private String org;
	private String url;
	public ExpertSimple() {
		super();
	}
	public ExpertSimple(int expertId, String name, String org, String url) {
		super();
		this.expertId = expertId;
		this.name = name;
		this.org = org;
		this.url = url;
	}
	public int getExpertId() {
		return expertId;
	}
	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
