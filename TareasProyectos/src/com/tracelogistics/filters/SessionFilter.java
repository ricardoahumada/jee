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

import com.tracelogistics.servlets.LoginServlet;

@WebFilter(filterName = "SessionFilter", urlPatterns = { "/tareas","/tareas/*","/dashboard" })
public class SessionFilter implements Filter {
	private static final Logger logger=Logger.getLogger(SessionFilter.class.getName());
	
	public SessionFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("Filtrando requests..."+request.getServletContext());
		
		HttpSession session = ((HttpServletRequest) request).getSession();

		if (session.getAttribute("user") != null) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse)response).sendRedirect("/"+request.getServletContext().getContextPath()+"/login"); 
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
