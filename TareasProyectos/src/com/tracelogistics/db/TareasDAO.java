package com.tracelogistics.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.tracelogistics.models.Tarea;

public class TareasDAO extends DAO {
	private static final Logger logger = Logger.getLogger(TareasDAO.class.getName());
	private static TareasDAO instance = null;

	public static TareasDAO getInstance() {
		if (instance == null) {
			instance = new TareasDAO();
		}
		return instance;
	}
	
	public List<Tarea> getTareasForUser(int uid){
		List<Tarea> listaTareas=null;
		Connection conn=null;
		try {
			conn=this.ds.getConnection();
			PreparedStatement psmt= conn.prepareStatement("SELECT * FROM tarea WHERE propietario=?");
			psmt.setInt(1, uid);
			
			ResultSet rs= psmt.executeQuery();
			
			listaTareas=new ArrayList<Tarea>();
			Tarea tarea=null;
			
			while(rs.next()) {
				tarea=new Tarea(
						rs.getInt("tid"), 
						rs.getString("descripcion"), 
						rs.getInt("estimado"), 
						rs.getInt("dedicado"), 
						rs.getInt("restante"), 
						rs.getInt("estado"),
						null
					);
				listaTareas.add(tarea);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return listaTareas;
	}
	
	public boolean deleteTarea(int tid) {
		boolean isOk=false;
		Connection conn=null;
		try {
			conn=this.ds.getConnection();
			PreparedStatement psmt= conn.prepareStatement("DELETE FROM tarea WHERE tid=?");
			psmt.setInt(1, tid);
			
			int rs= psmt.executeUpdate();
			isOk=rs>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return isOk;
	}
}
