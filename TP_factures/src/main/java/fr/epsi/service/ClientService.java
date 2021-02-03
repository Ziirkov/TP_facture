package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ClientDao;
import fr.epsi.dao.IClientDao;
import fr.epsi.entite.Client;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientService implements IClientService{

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;
	
	
	public void createClient(Client a) {
		IClientDao dao = new ClientDao(em, utx);
		dao.create(a);
	}
	
	public List<Client> getClient() {
		IClientDao dao = new ClientDao(em, utx);
		return dao.getClient();
	}


	
	
}
