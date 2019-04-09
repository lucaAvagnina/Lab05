package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String parziale) {
		
		String sql = "SELECT nome FROM parola WHERE nome = ? ";
		
		boolean result = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, parziale);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
		return result;
	}

	
	
}
