package frutasEnForma.panel;

import java.sql.Connection;

import frutasEnForma.model.UsuarioDAO;
import frutasEnForma.utils.UtilsFEF;
import javafx.geometry.HPos;
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
		Label lblAdelgazar = new Label(
				"Si su objetivo es adelgazar, deberá restar entre 300 y 500 calorias, por ello, a continuación le diremos el rango que debe cumplir para lograrlo");
		Label lblRango = new Label("Entre " + String.valueOf(UsuarioDAO.calculoCalorias(1, con) - 300) + " y "
				+ String.valueOf(UsuarioDAO.calculoCalorias(1, con) - 500));

		lblExplicacion.setId("labelCalculadora");
		lblNota.setId("labelCalculadora");
		lblResultado.setId("labelResultadoCalculadora");
		lblAdelgazar.setId("labelCalculadora");
		lblRango.setId("labelResultadoCalculadora");

		this.setHalignment(lblExplicacion, HPos.CENTER);
		this.setHalignment(lblNota, HPos.CENTER);
		this.setHalignment(lblResultado, HPos.CENTER);
		this.setHalignment(lblAdelgazar, HPos.CENTER);
		this.setHalignment(lblRango, HPos.CENTER);

		panelImc.add(lblExplicacion, 0, 0);
		panelImc.add(lblNota, 0, 1);
		panelImc.add(lblResultado, 0, 2);
		panelImc.add(lblAdelgazar, 0, 3);
		panelImc.add(lblRango, 0, 4);

		Scene scene = new Scene(panelImc, 600, 600);
		scene.getRoot().setStyle("Calculadora");

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Calculadora calorias");
		ventanaEmergente.show();
	}
}
