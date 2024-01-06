package com.KoreaIT.java.AM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.AM.dto.Member;

public class MemberDao {
	public List<Member> members;

	public MemberDao() {
		this.members = new ArrayList<>();
	}

	public List<Member> getMembers() {
		return members;
	}

	public Member getMemberList() {
		Member member = null;
		for (int i = members.size() - 1; i >= 0; i--) {
			member = members.get(i);
		}
		return member;
	}

	public Member getMemberByLoginId(String loginId) {
		for (Member member : members) {
			if (loginId.equals(member.getLoginId())) {
				return member;
			}
		}
		return null;

	}

	public void add(Member member) {
		members.add(member);
	}

	public boolean isJoinableLoginId(String loginId) {
		for (Member member : members) {
			if (loginId.equals(member.getLoginId())) {
				return false;
			}
		}
		return true;
	}

}
