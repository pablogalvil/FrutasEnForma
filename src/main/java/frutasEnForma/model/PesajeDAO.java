package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class PesajeDAO {

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

			// Ejecutamos la función guardarImc para guardar el imc que ha dado el cálculo
			guardarImc(imc, id, con);

			return imc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Funcion para guardar en base de datos el imc del usuario una vez lo
	 * calculamos
	 * 
	 * @param imc
	 * @param id
	 * @param con
	 */
	private static void guardarImc(double imc, int id, Connection con) {
		try {
			String query = "UPDATE USUARIO SET PESAJE_IMC = ? WHERE IDUSUARIO = ?";

			// Creamos el preparedStatement y le asignamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Le damos los valores a la query
			pstmt.setDouble(1, imc);
			pstmt.setInt(2, id);

			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			String query = "SELECT PESO, ALTURA, EDAD, SEXO FROM PESAJE WHERE IDUSUARIO = ?";

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
