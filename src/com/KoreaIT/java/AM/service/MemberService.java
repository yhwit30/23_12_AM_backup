package com.KoreaIT.java.AM.service;

import java.util.List;

import com.KoreaIT.java.AM.Container;
import com.KoreaIT.java.AM.dao.MemberDao;
import com.KoreaIT.java.AM.dto.Member;

public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		memberDao = Container.memberDao;
	}

	public List<Member> getMembers() {
		return memberDao.getMembers();
	}

	public Member getMemberList() {
		return memberDao.getMemberList();
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);

	}

	public void add(Member member) {
		memberDao.add(member);

	}

	public boolean isJoinableLoginId(String loginId) {
		return memberDao.isJoinableLoginId(loginId);
	}
}
