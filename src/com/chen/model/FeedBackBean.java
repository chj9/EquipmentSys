package com.chen.model;

import java.io.Serializable;

public class FeedBackBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String feedback;
	private String userName;
	private String feedtime;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFeedtime() {
		return feedtime;
	}
	public void setFeedtime(String feedtime) {
		this.feedtime = feedtime;
	}
	
}
