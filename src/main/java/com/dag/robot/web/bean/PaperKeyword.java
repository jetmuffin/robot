package com.dag.robot.web.bean;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;

public class PaperKeyword {
	
	private String keyword;
	private int num;
	public PaperKeyword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaperKeyword(String keyword, int num) {
		super();
		this.keyword = keyword;
		this.num = num;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "PaperKeyword [keyword=" + keyword + ", num=" + num + "]";
	}
	
}
