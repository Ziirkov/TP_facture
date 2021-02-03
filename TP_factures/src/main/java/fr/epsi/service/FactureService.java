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
import fr.epsi.dao.FactureDao;
import fr.epsi.dao.IArticleDao;
import fr.epsi.dao.IFactureDao;
import fr.epsi.entite.Article;
import fr.epsi.entite.Facture;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureService implements IFactureService{
	
	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;
	
	public List<Facture> getFacture() {
		IFactureDao dao = new FactureDao(em, utx);
		return dao.getFacture();
	}

}
