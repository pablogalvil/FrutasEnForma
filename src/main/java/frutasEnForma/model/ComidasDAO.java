package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComidasDAO {

	// INSERTAR

	/**
	 * Funcion que inserta comidas en la base de datos
	 * 
	 * @param con
	 * @param comida objeto creado a partir de los datos introducidos en los
	 *               textfields
	 * @return true si todo va bien, false si no
	 */
	public static boolean insertComidas(Connection con, ComidasDO comida) {

		try {

			int numAff = -1;

			// Creamos la query con los datos que tenemos

			String query = ("INSERT INTO COMIDAS (nombre, calorias, Recetas_idRecetas) VALUES(?,?,?)");

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, comida.getNombre());
			pstmt.setInt(2, comida.getCalorias());
			pstmt.setInt(3, comida.getRecetas_idRecetas());

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

}
