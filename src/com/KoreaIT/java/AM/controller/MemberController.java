package com.KoreaIT.java.AM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.dto.Member;
import com.KoreaIT.java.Util.Util;

public class MemberController extends Controller {
	List<Member> members;
	private Scanner sc;
	private String cmd;
	private String actionMethodName;

	public MemberController(Scanner sc) {
		this.members = new ArrayList<Member>();
		this.sc = sc;

	}

	public void doAction(String actionMethodName, String cmd) {
		this.actionMethodName = actionMethodName;
		this.cmd = cmd;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		default:
			System.out.println("명령어를 확인해주세요5");
			break;
		}
	}

	int lastMemberId = 0;

	public void doJoin() {

		System.out.println();
		System.out.println("==회원가입==");

		int id = lastMemberId + 1;
		String regDate = Util.getNowDate_TimeStr();
		String loginId = null;
		while (true) {
			System.out.print("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (isJoinableLoginId(loginId) == false) {
				System.out.println("중복된 아이디입니다.");
				continue;
			}
			break;
		}
		String loginPw = null;
		while (true) {
			System.out.print("로그인 비밀번호 : ");
			loginPw = sc.nextLine();
			System.out.print("로그인 비밀번호 확인 : ");
			String loginPwConfirm = sc.nextLine();
			if (!loginPw.equals(loginPwConfirm)) {
				System.out.println("비밀번호를 다시 확인해주세요.");
				continue;
			}
			break;
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();

		Member member = new Member(id, regDate, loginId, loginPw, name);
		members.add(member);

		System.out.printf("%d번 회원이 가입되었습니다. %s님 환영합니다.\n", id, name);
		lastMemberId++;

	}

	private boolean isJoinableLoginId(String loginId) {
		for (Member member : members) {
			if (member.getLoginId().equals(loginId)) {
				return false;
			}
		}
		return true;
	}
}
