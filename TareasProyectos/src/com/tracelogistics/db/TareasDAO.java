package com.tracelogistics.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tracelogistics.models.Proyecto;
import com.tracelogistics.models.Tarea;

public class TareasDAO extends DAO {
	private static final Logger logger = Logger.getLogger(TareasDAO.class.getName());
	private static TareasDAO instance = null;
	private static EntityManagerFactory emf;

	public static TareasDAO getInstance() {
		emf = Persistence.createEntityManagerFactory("com.trace.punit.Projects");
		if (instance == null) {
			instance = new TareasDAO();
		}
		return instance;
	}

	public List<Tarea> getTareasForUser(int uid) {
		EntityManager em = emf.createEntityManager();

		List<Tarea> tlist = em.createQuery("SELECT t FROM Tarea t WHERE propietario=:uid").setParameter("uid", uid)
				.getResultList();

		em.close();

		return tlist;
	}

	public boolean deleteTarea(int tid) {
		EntityManager em = emf.createEntityManager();

		Tarea tareaABorrar = em.find(Tarea.class, new Integer(tid));
		if (tareaABorrar != null) {
			em.getTransaction().begin();
			em.remove(tareaABorrar);
			em.getTransaction().commit();
		}

		em.close();
		return true;
	}
	
	public int addTarea(Tarea unaTarea) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
        em.persist(unaTarea);
        em.getTransaction().commit();
        em.close();
		return unaTarea.getTid();
        
	}

	public List<Tarea> _getTareasForUser(int uid) {
		List<Tarea> listaTareas = null;
		Connection conn = null;
		try {
			conn = this.ds.getConnection();
			PreparedStatement psmt = conn.prepareStatement("SELECT * FROM tarea WHERE propietario=?");
			psmt.setInt(1, uid);

			ResultSet rs = psmt.executeQuery();

			listaTareas = new ArrayList<Tarea>();
			Tarea tarea = null;

			while (rs.next()) {
				tarea = new Tarea(rs.getInt("tid"), rs.getString("descripcion"), rs.getInt("estimado"),
						rs.getInt("dedicado"), rs.getInt("restante"), rs.getInt("estado"), null);
				listaTareas.add(tarea);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaTareas;
	}

	public boolean _deleteTarea(int tid) {
		boolean isOk = false;
		Connection conn = null;
		try {
			conn = this.ds.getConnection();
			PreparedStatement psmt = conn.prepareStatement("DELETE FROM tarea WHERE tid=?");
			psmt.setInt(1, tid);

			int rs = psmt.executeUpdate();
			isOk = rs > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return isOk;
	}
}
