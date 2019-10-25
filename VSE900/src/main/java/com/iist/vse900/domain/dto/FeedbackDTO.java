package com.iist.vse900.domain.dto;

import java.util.Date;

public class FeedbackDTO {
	private Long feedbackId;
	private String fullName;
	private String email;
	private String phoneNumber;
	private String content;
	private char isActive;
	private Date createdDate;
	private String createdBy;

	public FeedbackDTO() {

	}

	public FeedbackDTO(Long feedbackId, String fullName, String email, String phoneNumber, String content,
			char isActive, Date createdDate, String createdBy) {

		this.feedbackId = feedbackId;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.content = content;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}
	

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
}

