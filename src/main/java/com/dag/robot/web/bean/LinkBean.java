package com.dag.robot.web.bean;

public class LinkBean {
	int source;
	int target;
	int weight;
	public LinkBean(long iSource,long iTarget){
		source = (int) iSource;
		target = (int) iTarget;
		weight = 1;
	}
	public LinkBean(int iSource,int iTarget){
		source = iSource;
		target = iTarget;
		weight = 1;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
