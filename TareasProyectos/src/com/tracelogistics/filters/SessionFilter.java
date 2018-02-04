package com.tracelogistics.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracelogistic.servlets.LoginServlet;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = { "/tareas","tareas/*" })
public class SessionFilter implements Filter {
	private static final Logger logger=Logger.getLogger(SessionFilter.class.getName());
	
	public SessionFilter() {
		// TODO Auto-generated constructor stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("Filtrando requests...");
		
		HttpSession session = ((HttpServletRequest) request).getSession();

		if (session.getAttribute("user") != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("login"); 
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
