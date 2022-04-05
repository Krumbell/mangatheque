package fr.mangatheque.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mangatheque.metier.Manga;
import fr.mangatheque.services.Facade;

/**
 * Servlet implementation class ServletListe
 */
@WebServlet("/Liste/*")
public class ServletListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	
	private static final String LIST_ALL = "get-all";
	private static final String ADD = "add-one";
	private static final String ALTER = "alter-one";
	private static final String ALTERED = "alter-done";
	private static final String DELETE = "delete-one";
	
	@Override
	public void init() throws ServletException {
		emf = (EntityManagerFactory)getServletContext().getAttribute("EMF");
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans le doGet");
		// instanciation de la facade -----------------------------------------------------------------------------------
		Facade facade = new Facade (emf.createEntityManager());
		
		if(request.getParameter(LIST_ALL) != null) {
			Collection<Manga> mangas = facade.getMangas();
			request.setAttribute("mangas", mangas);
			
			request.getRequestDispatcher("mes-mangas.jsp").forward(request, response);
		}
		
		if(request.getParameter(ADD) != null) {
			String title = request.getParameter("title");
			double price = Double.parseDouble(request.getParameter("price"));
			
			Manga manga = facade.creerManga(title, price);
			request.setAttribute("manga", manga);
			
			request.getRequestDispatcher("ajout-manga.jsp").forward(request, response);
		}
		
		if(request.getParameter(ALTER) != null) {
			Manga manga = facade.getManga(Integer.parseInt(request.getParameter("idAlter")));
			request.setAttribute("manga", manga);
			request.getRequestDispatcher("alter-manga.jsp").forward(request, response);
		}
		
		if(request.getParameter(ALTERED) != null) {
			int id = Integer.parseInt(request.getParameter("idAltered"));
			String title = request.getParameter("title");
			double prix = Double.parseDouble(request.getParameter("price"));
			facade.modifierManga(id, title, prix);
			Collection<Manga> mangas = facade.getMangas();
			request.setAttribute("mangas", mangas);
			request.getRequestDispatcher("mes-mangas.jsp").forward(request, response);
		}
		
		if(request.getParameter(DELETE) != null) {
			Manga manga = facade.getManga(Integer.parseInt(request.getParameter("idAlter")));
			String title = manga.getNom();
			request.setAttribute("title", title);
			request.getRequestDispatcher("delete-manga.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
