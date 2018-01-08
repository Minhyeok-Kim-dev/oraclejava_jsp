package com.oraclejava.model;

public class MemberService {
	public void insertMember(Member member) throws AlreadyEntryException {
		MemberDao dao = new MemberDao();
		
		if(dao.isEntriedId(member.getMemberId())) {
			throw new AlreadyEntryException();
		} 
		
		dao.insertMember(member);
	}
}
