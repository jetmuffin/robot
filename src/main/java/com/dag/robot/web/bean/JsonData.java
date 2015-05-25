package com.dag.robot.web.bean;

public class JsonData {
	
	private String name;
	private int value;
	public JsonData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JsonData(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
