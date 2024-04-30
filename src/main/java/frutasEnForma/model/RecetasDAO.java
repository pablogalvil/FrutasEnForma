package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecetasDAO {

	// INSERTAR

	public static boolean insertRecetas(Connection con, RecetasDO recetas) {

		try {

			int numAff = -1;

			// Creamos la query con los datos que tenemos

			String query = ("INSERT INTO Recetas (idRecetas, nombre, tiempoPreparacion, ingredientes, pasos) VALUES(?,?,?)");

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(2, recetas.getNombre());
			pstmt.setInt(3, recetas.getTiempoPreparacion());
			pstmt.setString(4, recetas.getIngredientes());
			pstmt.setString(5, recetas.getPasos());

			// Ejecutamos la query
			numAff = pstmt.executeUpdate();

			if (numAff == 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	// ELIMINAR
	public static boolean borrarRecetas(Connection con, int idrecetas) {

		try {
			String query = "DELETE FROM Recetas WHERE idRecetas = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idrecetas);
			int Affected = pstmt.executeUpdate();

			if (Affected == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
