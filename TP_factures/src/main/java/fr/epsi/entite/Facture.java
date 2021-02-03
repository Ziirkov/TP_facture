package fr.epsi.entite;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	
	private String numero;
	
	private Double prix;
	
	@ManyToOne
	@JoinColumn(name = "client_fk")
	Client client;
	
	public Date getDate() {
		return this.date;
	}
	
	public void setNom(Date date) {
		this.date = date;
		
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
		
	}
	
	public Double getPrix() {
		return this.prix;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
		
	}
	
	public Client getClient() {
		return this.client;
	}
}
