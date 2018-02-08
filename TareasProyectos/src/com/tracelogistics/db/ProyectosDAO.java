package com.tracelogistics.db;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.tracelogistics.models.Proyecto;
import com.tracelogistics.models.Tarea;

public class ProyectosDAO extends DAO {
	private static final Logger logger = Logger.getLogger(ProyectosDAO.class.getName());
	private static ProyectosDAO instance = null;

	public static ProyectosDAO getInstance() {
		if (instance == null) {
			instance = new ProyectosDAO();
		}
		return instance;
	}

	public Proyecto getProject(int pid) {
		EntityManager em = this.emf.createEntityManager();
		Proyecto elproj = (Proyecto) em.find(Proyecto.class, new Integer(pid));
		em.close();
		return elproj;
	}

	public List<Proyecto> getUserProjects(int uid) {
		EntityManager em = this.emf.createEntityManager();
		List<Proyecto> plist = em.createQuery("SELECT p FROM Proyecto p WHERE propietario=:uid")
				.setParameter("uid", uid).getResultList();
		em.close();
		
		logger.info("Proyectos:"+plist.get(0).getTareas());

		return plist;
	}

	public int addProyecto(Proyecto proj) {
		EntityManager em = this.emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(proj);
		em.getTransaction().commit();
		em.close();
		return proj.getPid();
	}

}
