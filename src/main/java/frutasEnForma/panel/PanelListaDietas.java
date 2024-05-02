package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelListaDietas extends GridPane {
	/**
	 * En este Panel se pueden ver las listas de las dietas
	 */

	public PanelListaDietas() {
		Stage ventanaEmergente = new Stage();

		GridPane panelRegistroDietas = new GridPane();

		Label lblDietas = new Label("Dietas");
		Label lblNombreDietas = new Label("Nombre Dietas");
		Label lblNumComidas = new Label("Numero Comidas");

		Label lblMuestraDieta = new Label();
		Label lblMuestraNombreDietas = new Label();
		Label lblMuestraNumComidas = new Label();

		Button Salir = new Button("Confirm");

		panelRegistroDietas.add(lblDietas, 0, 0);
		panelRegistroDietas.add(lblMuestraDieta, 1, 0);
		panelRegistroDietas.add(lblNombreDietas, 0, 1);
		panelRegistroDietas.add(lblMuestraNombreDietas, 1, 1);
		panelRegistroDietas.add(lblNumComidas, 0, 2);
		panelRegistroDietas.add(Salir, 0, 3);

		panelRegistroDietas.setMargin(lblDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(lblMuestraDieta, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblMuestraNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(Salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelRegistroDietas, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Regristro Dieta");
		ventanaEmergente.show();
	}
}