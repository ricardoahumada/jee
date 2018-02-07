package com.tracelogistics.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.tracelogistics.models.Usuario;

public class UsuarioDAO extends DAO {
	private static final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());
	private static UsuarioDAO instance = null;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public Usuario getUser(String email, String pass) {
		Usuario user=null;
		Connection conn=null;
		try {
			conn=this.ds.getConnection();
			PreparedStatement psmt= conn.prepareStatement("SELECT * FROM usuario WHERE email=? AND password=?");
			psmt.setString(1, email);
			psmt.setString(2, pass);
			
			ResultSet rs= psmt.executeQuery();
			
			if(rs.next()) {
				user = new Usuario();
				user.setUid(rs.getInt("uid"));
				user.setEmail(rs.getString("email"));
				user.setApellido(rs.getString("apellido"));
				user.setNombre(rs.getString("nombre"));
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return user;
	}
}
