package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Client;

public interface IClientDao {

void create(Client c);
	
	List<Client> getClient();
}
