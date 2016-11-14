package com.common;

public class BaseBean {
	private String page; //当前页
	private Integer pageSize; // 总页数
	private String rows;  //
	private String timesta; 
	private String timeend;
	
	public String getTimesta() {
		return timesta;
	}
	public void setTimesta(String timesta) {
		this.timesta = timesta;
	}
	public String getTimeend() {
		return timeend;
	}
	public void setTimeend(String timeend) {
		this.timeend = timeend;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	
}
