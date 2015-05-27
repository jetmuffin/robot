package com.dag.robot.web.bean;

import java.util.List;

public class RobotResponse {
	
	private String point;
	List<String> paper;
	List<String> patents;
	public RobotResponse() {
		super();
	}
	public RobotResponse(String point, List<String> paper, List<String> patents) {
		super();
		this.point = point;
		this.paper = paper;
		this.patents = patents;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public List<String> getPaper() {
		return paper;
	}
	public void setPaper(List<String> paper) {
		this.paper = paper;
	}
	public List<String> getPatents() {
		return patents;
	}
	public void setPatents(List<String> patents) {
		this.patents = patents;
	}
	
}
