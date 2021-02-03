package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ArticleDao;
import fr.epsi.dao.IArticleDao;
import fr.epsi.entite.Article;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArticleService implements IArticleService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;
	
	public void createArticle(Article a) {
		IArticleDao dao = new ArticleDao(em, utx);
		dao.create(a);
	}

	public List<Article> getArticle() {
		IArticleDao dao = new ArticleDao(em, utx);
		return dao.getArticle();
	}
	

}
