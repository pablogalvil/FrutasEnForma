package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaDietasDAO {

	public static String añadirDieta (int idListaDietas, Connection con ) {
		
		
		try {
		String query = "INSERT INTO listadietas idListaDietas=? nombre=? numComidas=?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
