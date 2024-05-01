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
			int altura = 0;

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
			DecimalFormat df = new DecimalFormat("##.#");
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
				resultado = 655 + (9.6 * peso) + (5 * altura) - (4.7 * edad);
			}

			return resultado;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
