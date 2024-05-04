package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.ListaDietasDAO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
		Stage stageRegistroListaDietas = new Stage();

		GridPane panelRegistroListaDietas = new GridPane();
		panelRegistroListaDietas.setAlignment(Pos.CENTER);

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

		panelRegistroListaDietas.add(lblDietas, 0, 0);
		panelRegistroListaDietas.add(lblMuestraDieta, 1, 0);
		panelRegistroListaDietas.add(lblNombreDietas, 0, 1);
		panelRegistroListaDietas.add(lblMuestraNombreDietas, 1, 1);
		panelRegistroListaDietas.add(lblNumComidas, 0, 2);
		panelRegistroListaDietas.add(salir, 0, 3);

		panelRegistroListaDietas.setMargin(lblDietas, new Insets(5, 10, 5, 10));
		panelRegistroListaDietas.setMargin(lblNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroListaDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroListaDietas.setMargin(lblMuestraDieta, new Insets(5, 10, 5, 10));
		panelRegistroListaDietas.setMargin(lblMuestraNombreDietas, new Insets(5, 10, 5, 10));

		panelRegistroListaDietas.setMargin(salir, new Insets(5, 10, 5, 10));

		panelRegistroListaDietas.setHalignment(lblDietas, HPos.CENTER);
		panelRegistroListaDietas.setHalignment(lblNombreDietas, HPos.CENTER);
		panelRegistroListaDietas.setHalignment(lblNumComidas, HPos.CENTER);

		panelRegistroListaDietas.setHalignment(lblMuestraDieta, HPos.CENTER);
		panelRegistroListaDietas.setHalignment(lblMuestraNombreDietas, HPos.CENTER);

		panelRegistroListaDietas.setHalignment(salir, HPos.CENTER);

		Scene sceneRegistroListaDietas = new Scene(panelRegistroListaDietas, 600, 600);

		if (App.configuracion.getTheme() == 1)
			sceneRegistroListaDietas.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneRegistroListaDietas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneRegistroListaDietas.getRoot().getStyleClass().add("body");

		stageRegistroListaDietas.setScene(sceneRegistroListaDietas);
		stageRegistroListaDietas.setTitle("Regristro Dieta");
		stageRegistroListaDietas.show();

		salir.setOnAction(e -> {
			stageRegistroListaDietas.close();

		});
	}

}