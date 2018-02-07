package com.tracelogistics.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracelogistics.db.TareasDAO;
import com.tracelogistics.models.Tarea;
import com.tracelogistics.models.Usuario;

//@WebServlet("/tareas")
public class TareasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=Logger.getLogger(TareasServlet.class.getName());
	
	@PersistenceUnit(unitName= "com.trace.punit.Projects")
	private EntityManagerFactory emf;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usuario myuser=session.getAttribute("user")!=null?(Usuario)session.getAttribute("user"):null;
		
		if( myuser!= null) {
			/*TareasDAO tDAO= TareasDAO.getInstance();
			
			request.setAttribute("tareas", tDAO.getTareasForUser(myuser.getUid()) );*/
			
			EntityManager em = emf.createEntityManager();
			
			 List<Tarea> tlist = em.createQuery("SELECT t FROM Tarea t WHERE propietario=:uid")
					 .setParameter("uid", myuser.getUid())
					 .getResultList();
			
			request.setAttribute("tareas",tlist); 
			
			request.getRequestDispatcher("tareas.jsp").forward(request, response);
		}/*else {
			response.sendRedirect("logout");
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
