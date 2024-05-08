package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroDietasDAO {

	/**
	 * Funcion que muestra los registros de dietas
	 * 
	 * @param con
	 * @param insNombre
	 * @return Devuelve los resgistros si todo funciona correctamente y devuelve
	 *         null en caso de que no funcione
	 *
	 */
	public static RegistroDietasDO getRegistroDietas(Connection con, String insNombre) {

		try {
			int id = 0;
			int diasRealizados = 0;
			String fechaInicio = "";
			String fechaFin = "";
			String nombre = "";

			// Creamos la sentencia a ejecutar
			String query = "SELECT * FROM RegistroDietas WHERE nombre = ? AND Usuario_idUsuario = ?";

			// Primer paso creo un statement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el valor del idRegistroDietas a la
			// interrogacion
			pstmt.setString(1, insNombre);
			pstmt.setInt(2, UsuarioDAO.idUsuario);

			RegistroDietasDO temp = new RegistroDietasDO();

			// Ejecutamos la query y los resultados
			// quedan en el resulset
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			id = rs.getInt(1);
			diasRealizados = rs.getInt(2);
			fechaInicio = rs.getString(3);
			fechaFin = rs.getString(4);
			nombre = rs.getString(5);

			// Para que se vea mas bonito, si la fechaFin es null, lo pasamos al valor 0.
			if (fechaFin == null)
				fechaFin = "0";

			temp.setIdRegistroDietas(id);
			temp.setDiasRealizados(diasRealizados);
			temp.setFechaInicio(fechaInicio);
			temp.setFechaFin(fechaFin);
			temp.setNombre(nombre);

			// devolvemos el resulset
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
	 * @param nombre Recoge los datos insertados en los textfields
	 * @return true si todo va bien, false si no
	 *
	 */

	public static boolean seleccionDietas(Connection con, String nombre) {
		try {
			int id = 1;
			int idLista = 0;
			String fecha = "";
			boolean existe = false;

			String query = "SELECT NOMBRE, CURDATE(), idListaDietas FROM LISTADIETAS";

			PreparedStatement pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			// Mientras hayan rows en la base de datos sueguirá el ciclo
			while (rs.next()) {
				String tempNombre = rs.getString(1);
				// Si el nombre que hemos sacado de la base de datos coincide con el que se haya
				// puesto te mostrará el registro
				if (tempNombre.equals(nombre)) {
					fecha = rs.getString(2);
					idLista = rs.getInt(3);
					existe = true;
				} else
					id++;
				continue;
			}
			// En caso de que no exista el nombre en la base de datos se devolverá false
			if (!existe)
				return false;

			String regis = "INSERT INTO registroDietas (diasRealizados, fechainicio, fechafin, nombre, Usuario_idUsuario) VALUES (?,?,?,?,?)";
			PreparedStatement pstmt2 = con.prepareStatement(regis);

			pstmt2.setInt(1, 1);
			pstmt2.setString(2, fecha);
			pstmt2.setString(3, null);
			pstmt2.setString(4, nombre);
			pstmt2.setInt(5, UsuarioDAO.idUsuario);

			int rowsAffected = pstmt2.executeUpdate();
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

	public static boolean insertFechaFin(Connection con, String fechafin, String nombre) {

		try {

			int numAff = -1;

			// Creamos la query con los datos que tenemos

			String query = ("UPDATE REGISTRODIETAS SET fechaFin = ? WHERE nombre = ? AND Usuario_idUsuario = ?");

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, fechafin);
			pstmt.setString(2, nombre);
			pstmt.setInt(3, UsuarioDAO.idUsuario);

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
