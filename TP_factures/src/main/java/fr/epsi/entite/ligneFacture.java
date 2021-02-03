package fr.epsi.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ligneFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int qte;
	
	private Double prix;
	
	@ManyToOne
	@JoinColumn(name = "facture_fk")
	Facture facture;
	
	@ManyToOne
	@JoinColumn(name = "article_fk")
	Article article;
	
	public int getQte() {
		return this.qte;
	}
	
	public void setQte(int qte) {
		this.qte = qte;
		
	}
	
	public Double getPrix() {
		return this.prix;
	}
	
	public void setPrix(Double prix) {
		this.prix = prix;
		
	}
}
