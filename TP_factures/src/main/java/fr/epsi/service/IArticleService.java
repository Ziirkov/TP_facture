package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Article;

public interface IArticleService {

	void createArticle(Article a);
	
	List<Article> getArticle();
}
