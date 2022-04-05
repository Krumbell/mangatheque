package fr.mangatheque.services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.mangatheque.metier.Manga;

public class ServiceManga {
	// propriétée(s) --------------------------------------------------------------------------
	protected EntityManager em;
	
	// constructeur(s) ------------------------------------------------------------------------
	public ServiceManga (EntityManager em) {
		this.em = em;
	}
	
	// methode(s) -----------------------------------------------------------------------------
	public Manga findManga (int id) {
		return em.find(Manga.class, id);
	}
	
	public Manga creerManga (String nom, double d) {
		Manga m = new Manga ();
		m.setNom(nom);
		m.setPrix(d);
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		return m;
	}
	
	public void supprimerManga (int id) {
		Manga m = findManga(id);
		if (m != null) {
			em.remove(m);
		}
	}
	
	public Manga changerPrix (int id, double d) {
		Manga m = findManga(id);
		if (m != null) {
			m.setPrix(d);
		}
		return m;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Manga> findAllManga () {
		Query requete = em.createQuery("SELECT m FROM Manga m");
		return (Collection<Manga>) requete.getResultList();
	}
}
