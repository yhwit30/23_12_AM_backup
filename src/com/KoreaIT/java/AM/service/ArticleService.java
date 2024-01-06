package com.KoreaIT.java.AM.service;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.AM.Container;
import com.KoreaIT.java.AM.dao.ArticleDao;
import com.KoreaIT.java.AM.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public void add(Article article) {
		articleDao.add(article);

	}

	public List<Article> getForPrintArticles(String searchKeyword) {
		List<Article> forPrintArticles = new ArrayList<Article>();

		if (searchKeyword.length() > 0 || searchKeyword != null) {
			forPrintArticles = new ArrayList<Article>();
			for (Article article : articleDao.getArticles()) {
				if (article.getTitle().contains(searchKeyword)) {
					forPrintArticles.add(article);
				}
			}

			if (forPrintArticles.size() == 0) {
				System.out.println("검색 결과 없음");
				return forPrintArticles;
			}
		}
		return forPrintArticles;
	}

	public int getSize() {
		return articleDao.getSize();
	}

	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);
		
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

}
