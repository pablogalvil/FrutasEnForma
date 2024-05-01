package frutasEnForma.panel;

import java.sql.Connection;

import frutasEnForma.model.UsuarioDAO;
import frutasEnForma.utils.UtilsFEF;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelCalculadoraCalorias extends GridPane {

	private Connection con = UtilsFEF.conectarBD();

	public PanelCalculadoraCalorias() {

		Stage ventanaEmergente = new Stage();

		GridPane panelImc = new GridPane();

		Label lblExplicacion = new Label(
				"Hemos calculado sus calorias diarias usando el peso, la altura, la edad y el sexo previamente introducida al registrarse");
		Label lblNota = new Label(
				"(Tenga en cuenta que si no relleno dichos datos al registrarse el resultado será 0)");
		Label lblResultado = new Label(String.valueOf(UsuarioDAO.calculoCalorias(1, con)));

		panelImc.add(lblExplicacion, 0, 0);
		panelImc.add(lblNota, 0, 1);
		panelImc.add(lblResultado, 0, 2);

		Scene scene = new Scene(panelImc, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Calculadora calorias");
		ventanaEmergente.show();
	}
}
