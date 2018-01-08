package com.oraclejava.model;

import java.util.Date;

public class Bbs {
	private int bbsNo;
	private String title;
	private String uploader;
	private String content;
	private int readCount;
	private Date regDate;
//	
//	public Bbs() {
//		
//	}
//	
//	public Bbs(int bbsNo, String title, String uploader
//			, String content, int readCount) {
//		this.bbsNo = bbsNo;
//		this.title = title;
//		this.uploader = uploader;
//		this.content = content;
//		this.readCount = readCount;
//		//this.regDate = regDate;
//	}
//	
	
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "BBS [bbsNo=" + bbsNo + ", title=" + title + ", uploader=" + uploader + ", content=" + content
				+ ", readCount=" + readCount + ", regDate=" + regDate + "]";
	}
	
	
}
