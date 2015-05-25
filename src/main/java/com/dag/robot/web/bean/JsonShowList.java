package com.dag.robot.web.bean;

import java.util.List;

public class JsonShowList {
	List<NodeBean> nodes;
	List<LinkBean> links;
	public List<NodeBean> getNodes() {
		return nodes;
	}
	public void setNodes(List<NodeBean> nodes) {
		this.nodes = nodes;
	}
	public List<LinkBean> getLinks() {
		return links;
	}
	public void setLinks(List<LinkBean> links) {
		this.links = links;
	}
	
}
