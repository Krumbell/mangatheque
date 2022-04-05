package fr.mangatheque.services;

import java.util.Collection;
import fr.mangatheque.metier.Manga;

public interface IFacade {
	public Manga getManga (int id);
	public Collection<Manga> getMangas ();
	public Manga creerManga (String nom, double prix);
	public Manga modifierManga (int id, String nom, double d);
}
