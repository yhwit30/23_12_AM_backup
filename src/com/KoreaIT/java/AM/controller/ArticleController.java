package com.KoreaIT.java.AM.controller;

import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.AM.Container;
import com.KoreaIT.java.AM.dto.Article;
import com.KoreaIT.java.AM.dto.Member;
import com.KoreaIT.java.AM.service.ArticleService;
import com.KoreaIT.java.AM.service.MemberService;
import com.KoreaIT.java.Util.Util;

public class ArticleController extends Controller {

	int lastArticleId = 3;

	private Scanner sc;
	private String cmd;
	private String actionMethodName;
	
	ArticleService articleService;
	MemberService memberService;

	List<Member> members;

	public ArticleController(Scanner sc) {
		this.articleService = Container.articleService;
		this.memberService = Container.memberService;
		members = memberService.getMembers();
		this.sc = sc;
	}

	public void doAction(String actionMethodName, String cmd) {
		this.actionMethodName = actionMethodName;
		this.cmd = cmd;

		switch (actionMethodName) {
		case "write":
			doWrite();
			break;
		case "list":
			showList();
			break;
		case "detail":
			showDetail();
			break;
		case "modify":
			doModify();
			break;
		case "delete":
			doDelete();
			break;
		default:
			System.out.println("명령어를 확인해주세요4");
			break;
		}
	}

	public void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성했습니다.");
		articleService.add(new Article(1, "2023-12-12 12:12:12", Util.getNowDate_TimeStr(), 1, "테스트제목1", "테스트내용1", 11));
		articleService.add(new Article(2, "2024-01-01 12:12:12", Util.getNowDate_TimeStr(), 2, "테스트제목2", "테스트내용2", 22));
		articleService.add(new Article(3, Util.getNowDate_TimeStr(), Util.getNowDate_TimeStr(), 2, "테스트제목3", "테스트내용3", 33));
	}

	private void doDelete() {
		String[] cmdDiv = cmd.split(" ");

		int id = 0;

		try {
			id = Integer.parseInt(cmdDiv[2]);
		} catch (Exception e) {
			System.out.println("번호는 정수로 입력해");
			return;
		}

		Article foundArticle = articleService.getArticleById(id);
		
		if (foundArticle == null) {
			System.out.printf("%d번 게시글은 없습니다\n", id);
			return;
		}

		if (loginedMember.getId() != foundArticle.getMemberId()) {
			System.out.println("권한 없음");
			return;
		}

		articleService.remove(foundArticle);
		System.out.println(id + "번 글이 삭제되었습니다.");

	}

	private void doModify() {

		String[] cmdDiv = cmd.split(" ");

		int id = 0;

		try {
			id = Integer.parseInt(cmdDiv[2]);
		} catch (Exception e) {
			System.out.println("번호는 정수로 입력해");
			return;
		}

		Article foundArticle = articleService.getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시글은 없습니다\n", id);
			return;
		}

		if (loginedMember.getId() != foundArticle.getMemberId()) {
			System.out.println("권한 없음");
			return;
		}

		System.out.println("기존 제목 : " + foundArticle.getTitle());
		System.out.println("기존 내용 : " + foundArticle.getBody());
		System.out.print("새 제목 : ");
		String newTitle = sc.nextLine();
		System.out.print("새 내용 : ");
		String newBody = sc.nextLine();

		foundArticle.setUpdateDate(Util.getNowDate_TimeStr());
		foundArticle.setTitle(newTitle);
		foundArticle.setBody(newBody);
		System.out.println(id + "번 글이 수정되었습니다.");

	}

	private void showDetail() {
		String[] cmdDiv = cmd.split(" ");

		int id = 0;

		try {
			id = Integer.parseInt(cmdDiv[2]);
		} catch (Exception e) {
			System.out.println("번호는 정수로 입력해");
			return;
		}

		Article foundArticle = articleService.getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시글은 없습니다\n", id);
			return;
		}
		System.out.println("번호 : " + foundArticle.getId());
		System.out.println("작성 날짜 : " + foundArticle.getRegDate());
		System.out.println("수정 날짜 : " + foundArticle.getUpdateDate());
		System.out.println("제목 : " + foundArticle.getTitle());
		System.out.println("내용 : " + foundArticle.getBody());
		System.out.println("조회 : " + foundArticle.getHit());

		foundArticle.setHit(foundArticle.getHit() + 1);

	}

	private void showList() {
		System.out.println();
		System.out.println("==게시글 목록==");
		if (articleService.getSize() == 0) {
			System.out.println("아무것도 없어");
			return;
		}

		String searchKeyword = cmd.substring("article list".length()).trim();

		List<Article> forPrintArticles = articleService.getForPrintArticles(searchKeyword);

		String writerName = null;

		System.out.println("  번호  /  제목    /   작성일     /   조회");
		for (int i = forPrintArticles.size() - 1; i >= 0; i--) {
			Article article = forPrintArticles.get(i);

			for (Member member : members) {
				if (article.getMemberId() == member.getId()) {
					writerName = member.getName();
					break;
				}
			}

			if (Util.getNowDate_TimeStr().split(" ")[0].equals(article.getRegDate().split(" ")[0])) {
				System.out.printf("  %4d  /   %5s    /     %s   /   %s  /    %d\n", article.getId(),
						article.getRegDate().split(" ")[1], writerName, article.getTitle(), article.getHit());
			} else {
				System.out.printf("  %4d  /   %5s    /     %s   /   %s  /    %d\n", article.getId(),
						article.getRegDate().split(" ")[0], writerName, article.getTitle(), article.getHit());
			}
		}

	}

	private void doWrite() {
		System.out.println();
		System.out.println("==게시글 작성==");
		int id = lastArticleId + 1;
		String regDate = Util.getNowDate_TimeStr();
		String updateDate = regDate;
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String body = sc.nextLine();

		Article article = new Article(id, regDate, updateDate, loginedMember.getId(), title, body);
		articleService.add(article);

		System.out.printf("%d번 글이 생성 되었습니다.\n", id);
		lastArticleId++;

	}
}
