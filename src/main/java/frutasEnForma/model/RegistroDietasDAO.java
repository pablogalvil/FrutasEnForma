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
	public static String nombre;

	public static RegistroDietasDO getRegistroDietas(Connection con, int idRegistroDietas) {

		try {

			// Creamos la sentencia a ejecutar
			String query = "SELECT * FROM RegistroDietas WHERE idRegistroDietas=?";

			// Primer paso creo un statement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Asignamos el valor del idRegistroDietas a la
			// interrogacion
			pstmt.setInt(1, idRegistroDietas);

			RegistroDietasDO temp = new RegistroDietasDO();

			// Ejecutamos la query y los resultados
			// quedan en el resulset
			ResultSet rs = pstmt.executeQuery();

			rs.next();

			id = rs.getInt(1);
			diasRealizados = rs.getInt(2);
			fechaInicio = rs.getInt(3);
			fechaFin = rs.getInt(4);
			nombre = rs.getString(5);

			// devolvemos el resulset
			return temp;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}

	public static boolean seleccionDietas(Connection con, String nombre) {
		try {
			int id = 1;
			int idLista = 0;
			String fecha = "";
			boolean existe = false;

			String query = "SELECT NOMBRE, CURDATE(), idListaDietas FROM LISTADIETAS";

			PreparedStatement pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String tempNombre = rs.getString(1);

				if (tempNombre.equals(nombre)) {
					fecha = rs.getString(2);
					idLista = rs.getInt(3);
					existe = true;
				} else
					id++;
				continue;
			}
			if (!existe)
				return false;

			String regis = "INSERT INTO registroDietas (diasRealizados, fechaincio, fechafin, nombre, Usuario_idUsuario) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt2 = con.prepareStatement(regis);

			pstmt2.setInt(1, 1);
			pstmt2.setString(2, fecha);
			pstmt2.setString(3, null);
			pstmt2.setString(4, nombre);
			pstmt2.setInt(5, UsuarioDAO.idUsuario);

			int rowsAffected = pstmt2.executeUpdate();

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
