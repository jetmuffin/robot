package com.dag.robot.web.bean;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	
	//当前页码
	private int currentPage;
	//每页元素个数
	private int pageSize;
	//总页数
	private Long totalPage;
	//总条数
	private Long totalCount;
	//是否有后页
	private boolean haveNextPage;
	//是否有前页
	private boolean havePrePage;
	//页面元素
	List<T> list = new ArrayList<T>();
	
	public Page() {
		super();
	}

	public Page(int currentPage, int pageSize, Long totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	/**
	 * 在调用有参构造方法后,必须调用此方法
	 */
	public void init(){
		//计算总页数
		totalPage = totalCount / pageSize;
		if(totalCount % pageSize != 0)
			totalPage = totalPage + 1;
		
		havePrePage = true;
		if(currentPage == 1)
			havePrePage = false;
		
		haveNextPage = true;
		if(currentPage == totalPage)
			haveNextPage = false;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isHaveNextPage() {
		return haveNextPage;
	}

	public void setHaveNextPage(boolean haveNextPage) {
		this.haveNextPage = haveNextPage;
	}

	public boolean isHavaPrePage() {
		return havePrePage;
	}

	public void setHavaPrePage(boolean havePrePage) {
		this.havePrePage = havePrePage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	
}
