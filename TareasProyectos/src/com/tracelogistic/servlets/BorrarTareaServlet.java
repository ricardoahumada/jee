package com.tracelogistic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracelogistics.db.BBDDMock;

/**
 * Servlet implementation class BorrarTareaServlet
 */
@WebServlet("/tareas/borrar")
public class BorrarTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(403);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "application/json");

		if (request.getSession().getAttribute("user") != null) {
			BBDDMock bbdd = BBDDMock.getInstance();
			response.getWriter().append("{\"data\":true}");
		}else {
			response.setStatus(403);
		}

	}

}
