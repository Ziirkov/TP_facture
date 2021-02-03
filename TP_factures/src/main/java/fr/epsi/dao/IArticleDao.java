package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Article;

public interface IArticleDao {
	
	void create(Article a);
	
	List<Article> getArticle();

}
