package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroDietasDAO {
			
			public static int id;
			public static int diasRealizados;
			public static int fechaInicio;
			public static int fechaFin;
			public static int ListaDietas_idListaDietas;

	public static ResultSet getRegistroDietas(Connection con, int idRegistroDietas) {

		try {

			// Creamos la sentencia a ejecutar
			String query = "SELECT * FROM RegistroDietas WHERE idRegistroDietas=?";

			// Primer paso creo un statement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el valor del idRegistroDietas a la
			// interrogacion
			pstmt.setInt(1, idRegistroDietas);

			// Ejecutamos la query y los resultados
			// quedan en el resulset
			ResultSet rs = pstmt.executeQuery();
			
			
			rs.next();
			
			id = rs.getInt(1);
			diasRealizados = rs.getInt(2);
			fechaInicio = rs.getInt(3);
			fechaFin = rs.getInt(4);
			ListaDietas_idListaDietas = rs.getInt(5);
			
			// devolvemos el resulset
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}

}
