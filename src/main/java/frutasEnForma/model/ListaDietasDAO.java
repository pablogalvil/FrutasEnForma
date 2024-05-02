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
	 * Coge la lista de dietas
	 * 
	 * @param con
	 * @param idListaDietas
	 */
	public static ListaDietasDO getListaDietas(Connection con, int idListaDietas) {

		try {

			// Creamos la sentencia a ejecutar
			String query = "SELECT * FROM listaDietas WHERE idListaDietas=?";

			// Primer paso creo un statement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el valor del idListaDietas a la
			// interrogacion
			pstmt.setInt(1, idListaDietas);

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

	public static boolean AniadirLista(Connection con, ListaDietasDO dietas) {

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

	public static boolean SeleccionDietas(Connection con, RegistroDietasDO registro) {
		try {
			String NombreRegristro;

			String query = "SELECT NOMBRE FROM LISTADIETAS";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, nombre);

			ResultSet rs = pstmt.executeQuery();
			ListaDietasDO temp = getListaDietas(con, id);

			pstmt.setString(1, temp.getNombre());
			pstmt.setInt(1, registro.getIdRegistroDietas());

			while (rs.next()) {
				String tempNombre = rs.getString(2);

				if (tempNombre.equals(nombre)) {
					NombreRegristro = rs.getString(2);
				} else
					continue;
			}

			String Regris = "INSERT INTO registroDietas (diasRealizados, fechaincio, fechafin, nombre) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(Regris);

		} catch (SQLException e) {

		}
		return false;
	}
}
