package com.dag.robot.web.bean;

import org.neo4j.cypher.internal.compiler.v2_1.docbuilders.internalDocBuilder;

public class PaperKeyword {
	
	private String name;
	private int value;
	public PaperKeyword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaperKeyword(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int getvalue() {
		return value;
	}
	public void setvalue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Papername [name=" + name + ", value=" + value + "]";
	}
	
}
