package com.oraclejava.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oraclejava.util.DBUtil;

public class BbsDao {
	// BBS
	public List<Bbs> selectBbs() {
		List<Bbs> list = null;
		String sql = "SELECT * FROM bbs";

		try (Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);){
			
			ResultSet rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			Bbs bbs = null;
			
			while(rs.next()) {
				bbs = new Bbs();
				bbs.setBbsNo(rs.getInt("BBSNO"));
				bbs.setTitle(rs.getString("TITLE"));
				bbs.setUploader(rs.getString("UPLOADER"));
				bbs.setContent(rs.getString("CONTENT"));
				bbs.setReadCount(rs.getInt("READCOUNT"));
				bbs.setRegDate(rs.getDate("REGDATE"));
				
				list.add(bbs);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}
	
	public Bbs selectBbsByBbsNo(int bbsNo) {
		Bbs bbs = null;
		
		String sql = "SELECT * FROM bbs WHERE BBSNO = ?";

		try (Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);){
			pstmt.setInt(1, bbsNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bbs = new Bbs();
				bbs.setBbsNo(rs.getInt("BBSNO"));
				bbs.setTitle(rs.getString("TITLE"));
				bbs.setUploader(rs.getString("UPLOADER"));
				bbs.setContent(rs.getString("CONTENT"));
				bbs.setReadCount(rs.getInt("READCOUNT"));
				bbs.setRegDate(rs.getDate("REGDATE"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return bbs;
	}
	
	public void updateBbsReadCountByBbsNo(int bbsNo) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE bbs SET READCOUNT = READCOUNT + 1");
		sb.append("WHERE BBSNO = " + bbsNo);
		
		try(Connection connection = DBUtil.getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sb.toString())){
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertBbs(Bbs bbs) {
		String sql = "INSERT INTO bbs(BBSNO, TITLE, UPLOADER, CONTENT)"
					+ "VALUES(bbs_seq.nextval, ?, ?, ?)";
		try(Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {
						"bbsno"
				});){

			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getUploader());
			pstmt.setString(3, bbs.getContent());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs != null && rs.next()) {
				Long pk = rs.getLong(1);
				bbs.setBbsNo(pk.intValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// BBS File
	public void insertBbsFile(BbsFile bbsFile) {
		String sql = "INSERT INTO bbsfile(BBSFILENO, SAVEDFILENAME, USERFILENAME, BBSNO)"
					+ "VALUES(bbsfile_seq.nextval, ?, ?, ?)";
	
		try (Connection connection = DBUtil.getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);){
			
			pstmt.setString(1, bbsFile.getSavedFileName());
			pstmt.setString(2, bbsFile.getUserFileName());
			pstmt.setInt(3, bbsFile.getBbsNo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBbsFileDownloadCountByBbsFileNo(int bbsFileNo) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE bbsfile SET DOWNLOADCOUNT = DOWNLOADCOUNT + 1");
		sb.append(" WHERE BBSFILENO = " + bbsFileNo);
		
		try(Connection connection = DBUtil.getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sb.toString())){
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<BbsFile> selectBbsFilesByBbsNo(int bbsNo) {
		List<BbsFile> list = null;
		String sql = "SELECT * FROM bbsfile WHERE BBSNO = ?";

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bbsNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			BbsFile bbsFile = null;
			
			while(rs.next()) {
				bbsFile = new BbsFile();
				bbsFile.setBbsFileNo(rs.getInt("BBSFILENO"));
				bbsFile.setSavedFileName(rs.getString("SAVEDFILENAME"));
				bbsFile.setUserFileName(rs.getString("USERFILENAME"));
				bbsFile.setDownloadCount(rs.getInt("DOWNLOADCOUNT"));
				bbsFile.setBbsNo(rs.getInt("BBSNO"));
				
				list.add(bbsFile);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}
	
	public BbsFile selectBbsFileByBbsFileNo(int bbsFileNo) {
		BbsFile bbsFile = null;
		
		String sql = "SELECT * FROM bbsFile WHERE BBSFILENO = ?";

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, bbsFileNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bbsFile = new BbsFile();
				bbsFile.setBbsFileNo(rs.getInt("BBSFILENO"));
				bbsFile.setSavedFileName(rs.getString("SAVEDFILENAME"));
				bbsFile.setUserFileName(rs.getString("USERFILENAME"));
				bbsFile.setDownloadCount(rs.getInt("DOWNLOADCOUNT"));
				bbsFile.setBbsNo(rs.getInt("BBSNO"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return bbsFile;
	}
	
}
