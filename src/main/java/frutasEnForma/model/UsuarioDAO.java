package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class UsuarioDAO {

	public static int idUsuario;

	/**
	 * Funcion que busca en la base de datos al usuario introducido en el textField
	 * y compara las contraseñas para saber si la contraseña es correcta o no.
	 * 
	 * @param nombre      introducido en el TextField
	 * @param contrasenia introducida en el TextField
	 * @param con
	 * @return true si coinciden, false si no.
	 */
	public static boolean login(String nombre, String contrasenia, Connection con) {
		try {
			String query = "SELECT CONTRASENIA, IDUSUARIO FROM USUARIO WHERE NOMBRE = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, nombre);

			ResultSet rs = pstmt.executeQuery();

			// Bucle que pasa por todos los usuarios con el mismo nombre para ver si
			// coincide la contraseña
			while (rs.next()) {
				String tempContrasenia = rs.getString(1);

				if (tempContrasenia.equals(contrasenia)) {
					idUsuario = rs.getInt(2);
					return true;
				} else
					continue;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Funcion para calcular el imc del usuario usando su peso y altura, sacados de
	 * la base de datos
	 * 
	 * @param id  del usuario
	 * @param con
	 * @return double con el imc calculado
	 */
	public static double calculoImc(int id, Connection con) {
		try {
			String query = "SELECT PESO, ALTURA FROM USUARIO WHERE IDUSUARIO = ?";

			// Variables de peso y altura
			double peso = 0;
			double altura = 0;

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Hacemos ResultSet para sacar los resultados de la query
			ResultSet rs = pstmt.executeQuery();

			// Hacemos rs.next() para sacar el peso y la altura dados por la query
			rs.next();

			// Guardamos los resultados en las variables
			peso = rs.getDouble(1);
			altura = rs.getInt(2);

			// Pasamos la altura, dada en centimetros, a metros cuadrados para poder
			// calcular el imc
			altura = (altura / 100) * (altura / 100);

			// Calculamos el imc
			double imc = peso / altura;

			// Creamos un DecimalFormat para que el double solo tenga 1 decimal
			DecimalFormat df = new DecimalFormat("##,##");
			// Creamos una string para formatearlo
			String result = df.format(imc);

			// Pasamos el resultado formateado a la variable del imc
			imc = Double.parseDouble(result);

			return imc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Esta funcion calcula las calorias que puedes consumir en funcion de tu peso,
	 * altura, edad y sexo, que estan guardadas en la base de datos
	 * 
	 * @param id  del usuario
	 * @param con
	 * @return double con el numero de calorias
	 */
	public static double calculoCalorias(int id, Connection con) {
		try {
			String query = "SELECT PESO, ALTURA, EDAD, SEXO FROM USUARIO WHERE IDUSUARIO = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Hacemos ResultSet para sacar los resultados de la query
			ResultSet rs = pstmt.executeQuery();

			// rs.next() para sacar los valores de la primera fila
			rs.next();

			// Creamos las variables que usaremos y les asignamos el resultado del ResultSet
			double peso = rs.getDouble(1);
			int altura = rs.getInt(2);
			int edad = rs.getInt(3);
			char sexo = rs.getString(4).toLowerCase().charAt(0);

			double resultado = 0;

			// Condición para hacer calculos separados en caso de que sea hombre o mujer, ya
			// que sus cuerpos funcionan de distinta forma
			if (sexo == 'h') {
				resultado = 66 + (13.7 * peso) + (5 * altura) - (6.8 * edad);
			} else if (sexo == 'm') {
				resultado = 65 + (9.6 * peso) + (5 * altura) - (4.7 * edad);
			}

			// Creamos un DecimalFormat para que el double solo tenga 1 decimal
			DecimalFormat df = new DecimalFormat("####,####");
			// Creamos una string para formatearlo
			String result = df.format(resultado);

			resultado = Double.parseDouble(result);

			return resultado;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public static boolean aniadirUsuario(Connection con, UsuarioDO usuario) {

		try {
			int numAff = -1;
			// Creamos la query con los datos de la lista
			String query = "INSERT INTO usuario (nombre, contrasenia, peso, altura, sexo, edad ) VALUES(?,?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, usuario.getNombre());
			pstmt.setString(2, usuario.getContrasenia());
			pstmt.setDouble(3, usuario.getPeso());
			pstmt.setInt(4, usuario.getAltura());
			pstmt.setString(5, String.valueOf(usuario.getSexo()));
			pstmt.setInt(6, usuario.getEdad());

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

	public static boolean updateUsuario(Connection con, double peso, int altura, int edad) {
		try {
			String query = "UPDATE USUARIO SET peso=?, altura=?, edad=? WHERE idUsuario = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setDouble(1, peso);
			pstmt.setInt(2, altura);
			pstmt.setInt(3, edad);
			pstmt.setInt(4, idUsuario);

			int numAff = pstmt.executeUpdate();

			if (numAff == 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
