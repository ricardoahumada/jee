package com.tracelogistics.services;

import java.util.HashMap;
import java.util.logging.Logger;

import com.tracelogistics.db.ProyectosDAO;
import com.tracelogistics.db.TareasDAO;
import com.tracelogistics.db.UsuarioDAO;

public class ServicioDashboard {
	private static final Logger logger = Logger.getLogger(ServicioDashboard.class.getName());
	private static ServicioDashboard instance = null;

	public static ServicioDashboard getInstance() {
		if (instance == null) {
			instance = new ServicioDashboard();
		}
		return instance;
	}

	public HashMap<String, Object> getDashboardForUser(int uid) {
		HashMap<String, Object> hash= new HashMap<>();
		
		UsuarioDAO uDAO = UsuarioDAO.getInstance();
		hash.put("datos_usuario", uDAO.getUser(uid));

		TareasDAO tDAO = TareasDAO.getInstance();
		hash.put("lista_tareas_usuario", tDAO.getTareasForUser(uid));
		
		ProyectosDAO pDAO = ProyectosDAO.getInstance();
		hash.put("lista_proyectos_usuario", pDAO.getUserProjects(uid));
		
		
		logger.info("Hashmap dashboard:"+hash);
		
		return hash;
	}
}
