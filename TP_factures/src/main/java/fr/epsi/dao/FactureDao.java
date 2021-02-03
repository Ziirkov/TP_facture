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
import fr.epsi.entite.Facture;

public class FactureDao implements IFactureDao{

	EntityManager em;
	UserTransaction utx;
	
	public FactureDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	
	public void create(Facture f) {
		try {
			utx.begin();
			em.persist(f);
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

	public List<Facture> getFacture() {
		
		return em.createQuery("select f from Facture f", Facture.class).getResultList();
	}
	
}
