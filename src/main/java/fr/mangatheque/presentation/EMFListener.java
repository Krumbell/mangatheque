package fr.mangatheque.presentation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EMEFListener
 *
 */
@WebListener
public class EMFListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	EntityManagerFactory emf = (EntityManagerFactory)sce.getServletContext().getAttribute("EMF");
    	if (emf != null) {
    		emf.close();
       		System.out.println("EntityManagerFactory fermée...");
    	}
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         EntityManagerFactory emf;
         ServletContext ctx = sce.getServletContext();
         
         emf = Persistence.createEntityManagerFactory("MangathequeWeb");
         ctx.setAttribute("EMF", emf);
    	 System.out.println("EntityManagerFactory placée dans le contexte...");
    }
	
}
