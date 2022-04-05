package fr.mangatheque.services;

import java.util.Collection;

import javax.persistence.EntityManager;

import fr.mangatheque.metier.Manga;

public class Facade implements IFacade {
	
	// propriétée(s) ------------------------------------------------------------
	private EntityManager em;
	private ServiceManga service;
	

	// constructeur(s) ----------------------------------------------------------
	public Facade (EntityManager em) {
		this.setEm(em);
		this.service = new ServiceManga(em);
	}

	// accesseur(s) -------------------------------------------------------------
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}


	// methode(s) ---------------------------------------------------------------
	@Override
	public Manga getManga(int id) {
		Manga manga = service.findManga(id);
		return manga;
	}

	@Override
	public Collection<Manga> getMangas() {
		Collection<Manga> mangas = service.findAllManga();
		return mangas;
	}

	@Override
	public Manga creerManga(String nom, double prix) {
		Manga manga = service.creerManga(nom, prix);
		return manga;
	}

	@Override
	public Manga modifierManga(int id, String nom, double d) {
		Manga manga = service.modifierManga(id, nom, d);
		return manga;
	}

}
