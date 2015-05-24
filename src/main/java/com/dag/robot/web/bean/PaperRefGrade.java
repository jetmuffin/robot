package com.dag.robot.web.bean;

public class PaperRefGrade {

	// 引用数量为0
	private int garde1;
	// 引用数量为1-10
	private int garde2;
	// 引用数量为11-50
	private int garde3;
	// 引用数量为51-100
	private int garde4;
	// 引用数量为101以及以上
	private int garde5;
	public PaperRefGrade(int garde1, int garde2, int garde3, int garde4,
			int garde5) {
		super();
		this.garde1 = garde1;
		this.garde2 = garde2;
		this.garde3 = garde3;
		this.garde4 = garde4;
		this.garde5 = garde5;
	}
	public PaperRefGrade() {
		super();
	}
	public int getGarde1() {
		return garde1;
	}
	public void setGarde1(int garde1) {
		this.garde1 = garde1;
	}
	public int getGarde2() {
		return garde2;
	}
	public void setGarde2(int garde2) {
		this.garde2 = garde2;
	}
	public int getGarde3() {
		return garde3;
	}
	public void setGarde3(int garde3) {
		this.garde3 = garde3;
	}
	public int getGarde4() {
		return garde4;
	}
	public void setGarde4(int garde4) {
		this.garde4 = garde4;
	}
	public int getGarde5() {
		return garde5;
	}
	public void setGarde5(int garde5) {
		this.garde5 = garde5;
	}
	
}
