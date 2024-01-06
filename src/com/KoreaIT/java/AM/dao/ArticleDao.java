package com.KoreaIT.java.AM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.AM.dto.Article;

public class ArticleDao {
	public List<Article> articles;

	public ArticleDao() {
		this.articles = new ArrayList<>();

	}

	public List<Article> getArticles() {
		return articles;
	}

	public void remove(Article foundArticle) {
		articles.remove(foundArticle);
	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public int getSize() {
		return articles.size();
	}

	public void add(Article article) {
		articles.add(article);
		
	}
}
