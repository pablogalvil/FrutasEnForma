package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaDietasDAO {

	public static ResultSet getListaDietas(Connection con, int idListaDietas) {

		try {

			// Creamos la sentencia a ejecutar
			String query = "SELECT * FROM CLIENTE WHERE idCliente=?";

			// Primer paso creo un statement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el valor del idListaDietas a la
			// interrogacion
			pstmt.setInt(1, idListaDietas);

			// Ejecutamos la query y los resultados
			// quedan en el resulset
			ResultSet rs = pstmt.executeQuery();

			// devolvemos el resulset
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}

	public static boolean añadirLista(Connection con, ListaDietasDO dietas) {

		try {
			int numAff = -1;
			// Creamos la query con los datos de la lista
			String query = "INSERT INTO listaDietas ( nombre, numComidas  ) VALUES(?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(2, dietas.getNombre());
			pstmt.setInt(3, dietas.getNumComidas());

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

	// Eliminar Lista de Dietas
	public static boolean borrarDieta(Connection con, int idListaDietas) {
		try {
			String sql = "DELETE FROM listaDietas WHERE idListaDietas = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idListaDietas);
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
