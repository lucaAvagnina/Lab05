package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?useTimezone=true&serverTimezone=UTC";
	static private HikariDataSource ds;

	public static Connection getConnection() {

		if (ds == null) {
					
					ds = new HikariDataSource();
		
					ds.setJdbcUrl(jdbcUrl);
					ds.setUsername("root");
					ds.setPassword("mylunchisover");
		
					
		
				}
	
		try {
			
			return ds.getConnection();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
