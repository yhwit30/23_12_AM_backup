package com.KoreaIT.java.AM;

import com.KoreaIT.java.AM.dao.ArticleDao;
import com.KoreaIT.java.AM.dao.MemberDao;
import com.KoreaIT.java.AM.service.ArticleService;
import com.KoreaIT.java.AM.service.MemberService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;

	public static ArticleService articleService;
	public static MemberService memberService;

	public static void init() {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();

		articleService = new ArticleService();
		memberService = new MemberService();
	}
}