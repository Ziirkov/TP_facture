package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Article;


public class ArticleDao implements IArticleDao{
	
	EntityManager em;
	UserTransaction utx;
	
	public ArticleDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	
	public void create(Article a) {
		try {
			utx.begin();
			em.persist(a);
			utx.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public List<Article> getArticle() {
		return em.createQuery("select a from Article a", Article.class).getResultList();
	}

}
