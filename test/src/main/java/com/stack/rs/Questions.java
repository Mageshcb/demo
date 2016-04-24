package com.stack.rs;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Questions {
	private int id;
	private String questions = "";
	private int noans;
	private String username = "";

	// private Date timeval;

	// @Temporal(TemporalType.DATE)
	// @Column(name = "created", nullable = false)

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date timeval = new java.sql.Date(new java.util.Date().getTime());;

	@Override
	public String toString() {
		return "Questions [id=" + id + ", questions=" + questions + ", noans="
				+ noans + ", username=" + username + ", timevalue=" + timeval
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public int getNoans() {
		return noans;
	}

	public void setNoans(int noans) {
		this.noans = noans;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getTimeval() throws ParseException {

		return timeval;
	}

	@PrePersist
	public void setTimeval(Date date) {
		this.timeval = date;

	}

}
