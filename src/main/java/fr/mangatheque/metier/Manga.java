package fr.mangatheque.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manga {
	
	// propriétée(s) ---------------------------------------------------------------------------
	@Id
	@GeneratedValue
	int id;
	String nom;
	double prix;
	
	// constructeur(s) -------------------------------------------------------------------------
	public Manga () { 
		this.id ++;
	}


	// accesseur(s) ----------------------------------------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	// toString --------------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Manga : [ id : " + id + ", nom : " + nom + ", prix : " + prix + " € ]";
	}
	
}
