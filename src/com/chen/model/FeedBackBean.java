package com.chen.model;

import java.io.Serializable;

import com.common.BaseBean;

public class FeedBackBean extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String feedback;
	private String userName;
	private String contact;
	private String feedtime;

	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
