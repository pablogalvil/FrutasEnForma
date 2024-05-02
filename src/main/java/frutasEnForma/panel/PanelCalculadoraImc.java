package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelCalculadoraImc extends GridPane {

	public PanelCalculadoraImc() {
		Stage ventanaImc = new Stage();

		GridPane panelImc = new GridPane();
		panelImc.setAlignment(Pos.TOP_CENTER);

		Label lblExplicacion = new Label(
				"Hemos calculado su IMC usando el peso y la altura previamente introducida al registrarse");
		Label lblNota = new Label(
				"(Tenga en cuenta que si no relleno dichos datos al registrarse el resultado será 0)");
		Label lblResultado = new Label(String.valueOf(UsuarioDAO.calculoImc(UsuarioDAO.idUsuario, App.con)));

		panelImc.setHalignment(lblExplicacion, HPos.CENTER);
		panelImc.setHalignment(lblNota, HPos.CENTER);
		panelImc.setHalignment(lblResultado, HPos.CENTER);

		panelImc.add(lblExplicacion, 0, 0);
		panelImc.add(lblNota, 0, 1);
		panelImc.add(lblResultado, 0, 2);

		Scene sceneImc = new Scene(panelImc, 600, 600);
		sceneImc.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
		sceneImc.getRoot().getStyleClass().add("body");

		lblExplicacion.setId("labelCalculadora");
		lblNota.setId("labelCalculadora");
		lblResultado.setId("labelResultadoCalculadora");

		ventanaImc.setScene(sceneImc);
		ventanaImc.setTitle("Calculadora IMC");
		ventanaImc.show();
	}
}
