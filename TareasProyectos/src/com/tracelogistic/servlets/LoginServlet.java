package com.tracelogistic.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracelogistic.models.Usuario;
import com.tracelogistics.db.BBDDMock;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns= {"/login","/"})
public class LoginServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger(LoginServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") != null) {
			response.sendRedirect("tareas");
		}else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		logger.log(Level.INFO, "Entramos en post:"+email+":"+pass);
		
		BBDDMock bbdd=BBDDMock.getInstance();
		
		Usuario user=bbdd.getUser(email, pass);
		
		if(user!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("user", user);
			
			//request.getRequestDispatcher("/tareas").forward(request, response);
			response.sendRedirect("tareas");
		}else {
			request.setAttribute("error", "Datos incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
