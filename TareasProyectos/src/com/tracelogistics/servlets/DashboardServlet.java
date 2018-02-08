package com.tracelogistics.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracelogistics.business.DashboardSession;
import com.tracelogistics.models.Usuario;
import com.tracelogistics.services.ServicioDashboard;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=Logger.getLogger(DashboardServlet.class.getName());
	
	@EJB(lookup="java:global/TareasProyectosEJBs/DashboardSessionBean")
	DashboardSession dBean;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Usuario myuser=session.getAttribute("user")!=null?(Usuario)session.getAttribute("user"):null;
		
		/*ServicioDashboard serv= ServicioDashboard.getInstance();
		
		request.setAttribute("datos_dashboard", serv.getDashboardForUser(myuser.uid) );*/
		request.setAttribute("datos_dashboard", dBean.getDashboardForUser(myuser.uid));
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
