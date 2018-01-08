package com.oraclejava.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class GsonTest {
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		Member member1 = new Member("fox1", "1111", "fox1@naver.com", "user", "1", new Date());
		Member member2 = new Member("fox2", "2222", "fox2@naver.com", "user", "1", new Date());
		
		List<Member> userList = new ArrayList<>();
		userList.add(member1);
		userList.add(member2);
		
		System.out.println("사용자 : " + gson.toJson(userList));
	}
}
