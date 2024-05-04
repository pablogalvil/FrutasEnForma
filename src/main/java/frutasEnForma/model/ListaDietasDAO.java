package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaDietasDAO {

	public static int id;
	public static String nombre;
	public static int numCom;

	/**
	 * Funcion que muestra las listas de dietas
	 * 
	 * @param con
	 * @param nombre
	 * @return Devuelve la listas si todo funciona correctamente y devuelve null en
	 *         caso de que no funcione
	 */
	public static ListaDietasDO getListaDietas(Connection con, String nombre) {

		try {

			// Creamos la sentencia a ejecutar
			String query = "SELECT * FROM listaDietas WHERE nombre=?";

			// Primer paso creo un statement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el valor del idListaDietas a la
			// interrogacion
			pstmt.setString(1, nombre);

			// Ejecutamos la query y los resultados
			// quedan en el resulset
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			id = rs.getInt(1);
			nombre = rs.getString(2);
			numCom = rs.getInt(3);
			ListaDietasDO temp = new ListaDietasDO(id, nombre, numCom);
			return temp;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Funcion que inserta los registros de dietas
	 * 
	 * @param con
	 * @param dietas Recoge los datos insertados en los textfields
	 * @return true si todo va bien, false si no
	 *
	 */

	public static boolean aniadirLista(Connection con, ListaDietasDO dietas) {

		try {
			int numAff = -1;
			// Creamos la query con los datos de la lista
			String query = "INSERT INTO listaDietas ( nombre, numComidas  ) VALUES(?,?)";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, dietas.getNombre());
			pstmt.setInt(2, dietas.getNumComidas());

			// Ejecutamos la query
			numAff = pstmt.executeUpdate();
			// Si se cambia una línea en el base de datos devolverá true, si no false
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
	 * Funcion que inserta los registros de dietas
	 * 
	 * @param con
	 * @param idListaDietas Recoge el id para borrar una dieta
	 * @return true si todo va bien, false si no
	 *
	 */

	// Eliminar Lista de Dietas
	public static boolean borrarDieta(Connection con, int idListaDietas) {
		try {
			String sql = "DELETE FROM listaDietas WHERE idListaDietas = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idListaDietas);
			int rowsAffected = ps.executeUpdate();
			// Si se cambia una línea en el base de datos devolverá true, si no false
			if (rowsAffected == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
