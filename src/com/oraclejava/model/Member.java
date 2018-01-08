package com.oraclejava.model;

import java.util.Date;

public class Member {
	private String memberId;
	private String passwd;
	private String email;
	private String userType;
	private String active;
	private Date regDate;
	
	public Member() {}
	public Member(String memberid, String passwd, String email
			, String userType, String active, Date regDate) {
		this.memberId = memberid;
		this.passwd = passwd;
		this.email = email;
		this.userType = userType;
		this.active = active;
		this.regDate = regDate;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", passwd=" + passwd + ", email=" + email + ", userType=" + userType
				+ ", active=" + active + ", regDate=" + regDate + "]";
	}
	
	
}
