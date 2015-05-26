package com.dag.robot.web.bean;

public class LinkExpertBean {
	String source;
	String target;
	int weight;
	public LinkExpertBean(String iSource,String iTarget){
		source = iSource;
		target = iTarget;
		weight = 1;
	}
	public LinkExpertBean(long iSource,long iTarget){
		source = String.valueOf(iSource);
		target = String.valueOf(iTarget);
		weight = 1;
	}
	public LinkExpertBean(int iSource,int iTarget){
		source = String.valueOf(iSource);
		target = String.valueOf(iTarget);
		weight = 1;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
