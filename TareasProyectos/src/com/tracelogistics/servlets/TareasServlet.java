package com.tracelogistics.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracelogistics.db.TareasDAO;
import com.tracelogistics.models.Usuario;

/**
 * Servlet implementation class TareasServlet
 */
//@WebServlet("/tareas")
public class TareasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		Usuario myuser=session.getAttribute("user")!=null?(Usuario)session.getAttribute("user"):null;
		
		if( myuser!= null) {
			TareasDAO tDAO= TareasDAO.getInstance();
			
			request.setAttribute("tareas", tDAO.getTareasForUser(myuser.getUid()) );
			request.getRequestDispatcher("tareas.jsp").forward(request, response);
		}/*else {
			response.sendRedirect("logout");
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
