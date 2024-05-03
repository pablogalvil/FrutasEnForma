package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.ListaDietasDAO;
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

		Label lblMuestraDieta = new Label(
				String.valueOf(ListaDietasDAO.getListaDietas(App.con, ListaDietasDAO.id).getIdListaDietas()));
		Label lblMuestraNombreDietas = new Label(
				String.valueOf(ListaDietasDAO.getListaDietas(App.con, ListaDietasDAO.id).getNombre()));
		Label lblMuestraNumComidas = new Label(
				String.valueOf(ListaDietasDAO.getListaDietas(App.con, ListaDietasDAO.id).getNumComidas()));

		Button salir = new Button("Confirm");

		panelRegistroDietas.add(lblDietas, 0, 0);
		panelRegistroDietas.add(lblMuestraDieta, 1, 0);
		panelRegistroDietas.add(lblNombreDietas, 0, 1);
		panelRegistroDietas.add(lblMuestraNombreDietas, 1, 1);
		panelRegistroDietas.add(lblNumComidas, 0, 2);
		panelRegistroDietas.add(salir, 0, 3);

		panelRegistroDietas.setMargin(lblDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(lblMuestraDieta, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblMuestraNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelRegistroDietas, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Regristro Dieta");
		ventanaEmergente.show();

		salir.setOnAction(e -> {
			ventanaEmergente.close();

		});
	}

}