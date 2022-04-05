package fr.mangatheque.presentation;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.mangatheque.metier.Manga;
import fr.mangatheque.services.Facade;


public class Principale {
	public static void main (String args[])	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mangatheque");
		EntityManager em = emf.createEntityManager();
		Facade facade = new Facade(em);
		
		// creation de mangas ----------------------------------------------------------------------------
		System.out.println("\n+----------------------------+");
		System.out.println("|     Creation de mangas     |");
		System.out.println("+----------------------------+");
		facade.creerManga("Naruto", 6.85);
		facade.creerManga("Berserk", 6.90);
		facade.creerManga("Promised Neverland", 6.89);
		
		Collection<Manga> mangatheque = facade.getMangas();
		for (Manga m : mangatheque) {
			System.out.println(m);
		}
		
		// modifier le prix de naruto --------------------------------------------------------------------
		/*System.out.println("\n+---------------------------------+");
		System.out.println("|     modification d'un manga     |");
		System.out.println("+---------------------------------+");
		em.getTransaction().begin();
		Manga naruto = service.changerPrix(1, 6.85);
		em.getTransaction().commit();
		
		mangatheque = service.findAllManga();
		for (Manga m : mangatheque) {
			System.out.println(m);
		}*/
		
		// supprimer berserk -----------------------------------------------------------------------------
		/*System.out.println("\n+--------------------------------+");
		System.out.println("|     Suppression d'un manga     |");
		System.out.println("+--------------------------------+");
		em.getTransaction().begin();
		service.supprimerManga(2);
		em.getTransaction().commit();
		
		mangatheque = service.findAllManga();
		for (Manga m : mangatheque) {
			System.out.println(m);
		}*/
		
		// fermeture em et emf ---------------------------------------------------------------------------
		em.close();
		emf.close();
		
	}
}
