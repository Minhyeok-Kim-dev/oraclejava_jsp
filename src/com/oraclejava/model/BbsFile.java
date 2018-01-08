package com.oraclejava.model;

public class BbsFile {
	private int bbsFileNo;
	private String savedFileName;
	private String userFileName;
	private int downloadCount;
	private int bbsNo;
//	
//	public BbsFile() {
//	
//	}
//	
//	public BbsFile(int bbsFileNo, String savedFileName
//			, String userFileName, int downloadCount, int bbsNo) {
//		this.bbsFileNo = bbsFileNo;
//		this.savedFileName = savedFileName;
//		this.userFileName = userFileName;
//		this.downloadCount = downloadCount;
//		this.bbsNo = bbsNo;
//	}
//	
	
	public int getBbsFileNo() {
		return bbsFileNo;
	}
	public void setBbsFileNo(int bbsFileNo) {
		this.bbsFileNo = bbsFileNo;
	}
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public String getUserFileName() {
		return userFileName;
	}
	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	
	@Override
	public String toString() {
		return "BBSFile [bbsFileNo=" + bbsFileNo + ", savedFileName=" + savedFileName + ", userFileName=" + userFileName
				+ ", downloadCount=" + downloadCount + ", bbsNo=" + bbsNo + "]";
	}
	
	
}
