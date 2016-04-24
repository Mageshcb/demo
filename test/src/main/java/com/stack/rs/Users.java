package com.stack.rs;

public class Users {

	private String UserName = "";
	private String Emailid = "";
	private String Password = "";
	private int id;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	@Override
	public String toString() {
		return "Users [ name=" + UserName + ", emailId=" + Emailid
				+ ", password=" + Password + "]";
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String Emailid) {
		this.Emailid = Emailid;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

}