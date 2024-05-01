package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelCalculadoraImc extends GridPane {

	public PanelCalculadoraImc() {
		Stage ventanaEmergente = new Stage();

		GridPane panelImc = new GridPane();

		Label lblExplicacion = new Label(
				"Hemos calculado su IMC usando el peso y la altura previamente introducida al registrarse");
		Label lblNota = new Label(
				"(Tenga en cuenta que si no relleno dichos datos al registrarse el resultado será 0)");
		Label lblResultado = new Label(String.valueOf(UsuarioDAO.calculoImc(UsuarioDAO.idUsuario, App.con)));

		panelImc.add(lblExplicacion, 0, 0);
		panelImc.add(lblNota, 0, 1);
		panelImc.add(lblResultado, 0, 2);

		Scene scene = new Scene(panelImc, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Calculadora IMC");
		ventanaEmergente.show();
	}
}
