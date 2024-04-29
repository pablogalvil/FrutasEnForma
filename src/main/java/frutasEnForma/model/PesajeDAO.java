package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.stage.Popup;

public class PesajeDAO {

	public static double calculoImc(int id, Connection con) {
		try {
			String query = "SELECT PESO, ALTURA FROM USUARIO WHERE IDUSUARIO = ?";

			double peso = 0;
			int altura = 0;

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			rs.next();

			peso = rs.getDouble(1);
			altura = rs.getInt(2);

			altura = (altura / 100) * (altura / 100);

			double imc = peso / altura;

			guardarImc(imc, id, con);

			return imc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	private static void guardarImc(double imc, int id, Connection con) {
		try {
			String query = "UPDATE USUARIO SET PESAJE_IMC = ? WHERE IDUSUARIO = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setDouble(1, imc);
			pstmt.setInt(2, id);

			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int calculoCalorias(int id, Connection con) {
		try {
			Popup asd = new Popup();
			String query = "SELECT PESO, ALTURA, EDAD, SEXO FROM PESAJE WHERE IDUSUARIO = ?";

			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			double peso = rs.getDouble(1);
			int altura = rs.getInt(2);
			int edad = rs.getInt(3);
			char sexo = rs.getString(4).charAt(0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

}
