package com.xiaoguo.model;

public class PageParams {
	//要查询的页码
	private Integer pageNum;
	//每页显示的行数
	private Integer pageRowNum;
	
	
	public PageParams() {}

	public PageParams(Integer pageNum, Integer pageRowNum) {
		super();
		this.pageNum = pageNum;
		this.pageRowNum = pageRowNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageRowNum() {
		return pageRowNum;
	}

	public void setPageRowNum(Integer pageRowNum) {
		this.pageRowNum = pageRowNum;
	}
	
	
}
