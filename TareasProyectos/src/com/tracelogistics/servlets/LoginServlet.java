package com.tracelogistics.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracelogistics.db.UsuarioDAO;
import com.tracelogistics.models.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(LoginServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") != null) {
			response.sendRedirect("tareas");
		}else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		logger.log(Level.INFO, "Entramos en post:"+email+":"+pass);
		
		UsuarioDAO uDao=UsuarioDAO.getInstance();
		Usuario user=uDao.getUser(email, pass);
		
		logger.info("user:"+user);
		
		if(user!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("user", user);
			
			//request.getRequestDispatcher("/tareas").forward(request, response);
			response.sendRedirect("dashboard");
		}else {
			request.setAttribute("error", "Datos incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
