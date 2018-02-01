package com.tracelogistic.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracelogistics.db.BBDDMock;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
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
		request.setAttribute("error", "");
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
//		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		logger.log(Level.INFO, "Entramos en post:"+email+":"+pass);
		
		BBDDMock bbdd=BBDDMock.getInstance();
		
		if(bbdd.getUser(email, pass)!=null) {
			//request.getRequestDispatcher("/tareas").forward(request, response);
			response.sendRedirect("tareas");
		}else {
			request.setAttribute("error", "Datos incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
