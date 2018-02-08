package com.tracelogistics.db;

import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

public class DAO {
	private static Logger logger = Logger.getLogger("DAO");

	public static DataSource ds;
	public static EntityManagerFactory emf;
	
	protected DAO() {
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:jboss"); 
			this.ds = (DataSource)envContext.lookup("datasources/ProjsAppDS");
		}catch (Exception e) {
			logger.info("Error al instanciar Datasource!!!!");
			e.printStackTrace();
		}
		
		emf = Persistence.createEntityManagerFactory( "com.trace.punit.Projects" );
	}
}
