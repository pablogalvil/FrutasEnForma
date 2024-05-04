package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecetasDAO {

	/**
	 * Funcion que inserta recetas
	 * 
	 * @param con
	 * @param recetas recogiendo los datos insertados en los textfields
	 * @return true si todo va bien, false si no
	 */
	public static boolean insertRecetas(Connection con, RecetasDO recetas) {

		try {

			int numAff = -1;

			// Creamos la query con los datos que tenemos

			String query = ("INSERT INTO Recetas (nombre, tiempoPreparacion, ingredientes, pasos) VALUES(?,?,?,?)");

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, recetas.getNombre());
			pstmt.setInt(2, recetas.getTiempoPreparacion());
			pstmt.setString(3, recetas.getIngredientes());
			pstmt.setString(4, recetas.getPasos());

			// Ejecutamos la query
			numAff = pstmt.executeUpdate();

			if (numAff == 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Funcion que borra recetas
	 * 
	 * @param con
	 * @param nombre insertado en el textfield
	 * @return true si todo va bien, false si no
	 */
	public static boolean borrarRecetas(Connection con, String nombre) {

		try {
			String query = "DELETE FROM Recetas WHERE nombre = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			int Affected = pstmt.executeUpdate();

			if (Affected == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
