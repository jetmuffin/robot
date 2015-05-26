package com.dag.robot.web.bean;

import java.util.ArrayList;
import java.util.List;

public class JsonExpertList {
	List<NodeBean> nodes = new ArrayList<NodeBean>();
	List<LinkExpertBean> links = new ArrayList<LinkExpertBean>();
	public List<NodeBean> getNodes() {
		return nodes;
	}
	public void setNodes(List<NodeBean> nodes) {
		this.nodes = nodes;
	}
	public List<LinkExpertBean> getLinks() {
		return links;
	}
	public void setLinks(List<LinkExpertBean> links) {
		this.links = links;
	}
	
	
}
