package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelCalculadoraCalorias extends GridPane {

	public PanelCalculadoraCalorias() {
		double resultado = UsuarioDAO.calculoCalorias(UsuarioDAO.idUsuario, App.con);

		Stage ventanaCalorias = new Stage();

		GridPane panelCalorias = new GridPane();
		panelCalorias.setAlignment(Pos.CENTER);

		Label lblExplicacion = new Label(
				"Hemos calculado sus calorias diarias usando el peso, la altura, la edad y el sexo previamente introducida al registrarse");
		Label lblNota = new Label(
				"(Tenga en cuenta que si no relleno dichos datos al registrarse el resultado será 0)");
		Label lblResultado = new Label(String.valueOf(resultado));
		Label lblAdelgazar = new Label(
				"Si su objetivo es adelgazar, deberá restar entre 300 y 500 calorias, por ello,\na continuación le diremos el rango que debe cumplir para lograrlo");
		Label lblRango = new Label("Entre " + (resultado - 300) + " y " + String.valueOf(resultado - 500));

		panelCalorias.setHalignment(lblExplicacion, HPos.CENTER);
		panelCalorias.setHalignment(lblNota, HPos.CENTER);
		panelCalorias.setHalignment(lblResultado, HPos.CENTER);
		panelCalorias.setHalignment(lblAdelgazar, HPos.CENTER);
		panelCalorias.setHalignment(lblRango, HPos.CENTER);

		panelCalorias.add(lblExplicacion, 0, 0);
		panelCalorias.add(lblNota, 0, 1);
		panelCalorias.add(lblResultado, 0, 2);
		panelCalorias.add(lblAdelgazar, 0, 3);
		panelCalorias.add(lblRango, 0, 4);

		Scene sceneCalorias = new Scene(panelCalorias, 800, 600);

		sceneCalorias.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
		sceneCalorias.getRoot().getStyleClass().add("body");

		lblExplicacion.setId("labelCalculadora");
		lblNota.setId("labelCalculadora");
		lblResultado.setId("labelResultadoCalculadora");
		lblAdelgazar.setId("labelCalculadora");
		lblRango.setId("labelResultadoCalculadora");

		ventanaCalorias.setScene(sceneCalorias);
		ventanaCalorias.setTitle("Calculadora calorias");
		ventanaCalorias.show();
	}
}
