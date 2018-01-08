package com.oraclejava.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oraclejava.util.DBUtil;

public class MemberDao {
	public List<Member> selectMembers() {
		Member member = null;
		
		String sql = "SELECT * FROM Members";
		
		List<Member> list = new ArrayList<>();
		
		try(Connection connection = DBUtil.getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("MEMBERID"));
				member.setPasswd(rs.getString("PASSWD"));
				member.setEmail(rs.getString("EMAIL"));
				member.setUserType(rs.getString("USERTYPE"));
				member.setActive(rs.getString("ACTIVE"));
				member.setRegDate(rs.getDate("REGDATE"));
				
				list.add(member);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}
	public Member selectMemberByIdAndPw(String id, String passwd) {
		Member member = null;
		
		String sql = "SELECT * FROM Members WHERE memberid=? AND passwd=?";
		
		try(Connection connection = DBUtil.getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("MEMBERID"));
				member.setPasswd(rs.getString("PASSWD"));
				member.setEmail(rs.getString("EMAIL"));
				member.setUserType(rs.getString("USERTYPE"));
				member.setActive(rs.getString("ACTIVE"));
				member.setRegDate(rs.getDate("REGDATE"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return member;
	}
	
	public boolean isEntriedId(String id) {
		
		boolean isEntried = false;
		String sql = "SELECT * FROM Members WHERE memberid=?";
		
		try(Connection connection = DBUtil.getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
				isEntried = true;
	
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return isEntried;
	}
	
	public void insertMember(Member member) {
		
		String sql = "INSERT INTO members(MEMBERID, PASSWD, EMAIL, USERTYPE, ACTIVE)"
					+ "VALUES(?, ?, ?, ?, ?)";
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getUserType());
			pstmt.setString(5, member.getActive());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
