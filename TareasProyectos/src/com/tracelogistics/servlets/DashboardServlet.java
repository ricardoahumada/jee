package com.tracelogistics.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracelogistics.models.Usuario;
import com.tracelogistics.services.ServicioDashboard;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usuario myuser=session.getAttribute("user")!=null?(Usuario)session.getAttribute("user"):null;
		
		ServicioDashboard serv= ServicioDashboard.getInstance();
		
		request.setAttribute("datos_dashboard", serv.getDashboardForUser(myuser.uid) );
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
