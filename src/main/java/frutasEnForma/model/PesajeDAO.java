package frutasEnForma.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
