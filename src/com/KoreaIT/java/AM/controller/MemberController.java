package com.KoreaIT.java.AM.controller;

import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.Container;
import com.KoreaIT.java.AM.dto.Member;
import com.KoreaIT.java.AM.service.MemberService;
import com.KoreaIT.java.Util.Util;

public class MemberController extends Controller {

	private Scanner sc;
	private String cmd;
	private String actionMethodName;
	MemberService memberService;

	public MemberController(Scanner sc) {
		memberService = Container.memberService;
		this.sc = sc;
	}

	public void doAction(String actionMethodName, String cmd) {
		this.actionMethodName = actionMethodName;
		this.cmd = cmd;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "list":
			showList();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		default:
			System.out.println("명령어를 확인해주세요");
			break;

		}
	}

	private void showList() {

		Member member = memberService.getMemberList();

		System.out.println("==회원목록==");
		System.out.printf("  %d  /  %s   /   %s   /   %s   /   %s\n", member.getId(), member.getRegDate(),
				member.getLoginId(), member.getLoginPw(), member.getName());

	}

	private void doLogout() {
		loginedMember = null;
		System.out.println("로그아웃 되었습니다.");

	}

	private void doLogin() {
		if (isLogined()) {
			System.out.println("이미 로그인 상태입니다.");
			return;
		}

		System.out.print("로그인 아이디 : ");
		String loginId = sc.nextLine();
		System.out.print("로그인 비밀번호 : ");
		String loginPw = sc.nextLine();

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			System.out.println("일치하는 회원이 없어");
			return;
		}

		if (!member.getLoginPw().equals(loginPw)) {
			System.out.println("비밀번호 다시 확인해주세요");
			return;
		}

		loginedMember = member;

		System.out.printf("%s님 환영합니다.\n", member.getName());
	}

	int lastMemberId = 0;

	private void doJoin() {
		System.out.println();
		System.out.println("==회원가입==");

		int id = lastMemberId + 1;
		String regDate = Util.getNowDate_TimeStr();
		String loginId = null;
		while (true) {
			System.out.print("로그인 아이디 : ");
			loginId = sc.nextLine();
			if (memberService.isJoinableLoginId(loginId) == false) {
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
				System.out.println("비밀번호 다시 확인해주세요");
				continue;
			}
			break;
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();

		Member member = new Member(id, regDate, loginId, loginPw, name);
		memberService.add(member);

		System.out.println();
		System.out.printf("%d번 회원이 가입되었습니다. %s님 환영합니다.\n", id, name);
		lastMemberId++;

	}

}
