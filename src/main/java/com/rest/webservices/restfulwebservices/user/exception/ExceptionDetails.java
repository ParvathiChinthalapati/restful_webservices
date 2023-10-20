package com.rest.webservices.restfulwebservices.user.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {

	private LocalDateTime date;
	private String description;
	private String msg;
	
	public ExceptionDetails(LocalDateTime localDateTime, String description, String msg) {
		super();
		this.date = localDateTime;
		this.description = description;
		this.msg = msg;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
