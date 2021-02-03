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
import fr.epsi.entite.Client;

public class ClientDao implements IClientDao{

	EntityManager em;
	UserTransaction utx;
	
	public ClientDao(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	} 
	
	public void create(Client c) {
		try {
			utx.begin();
			em.persist(c);
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

	public List<Client> getClient() {
	 return em.createQuery("select c from Client c", Client.class).getResultList();
	}
}
