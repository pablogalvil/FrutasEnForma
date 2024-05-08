package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.ListaDietasDAO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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

		ChoiceBox chbEligeDieta = new ChoiceBox();
		chbEligeDieta.getItems().addAll("Dieta Dash", "Dieta Frutariana", "Dieta Mediterranea");

		Button confirmar = new Button("Mostrar Dietas");

		Label lblDietas = new Label("Dietas");
		Label lblNombreDietas = new Label("Nombre Dietas");
		Label lblNumComidas = new Label("Numero Comidas");

		panelRegistroListaDietas.add(chbEligeDieta, 0, 0);
		panelRegistroListaDietas.add(lblDietas, 0, 1);
		lblDietas.setVisible(false);
		panelRegistroListaDietas.add(lblNombreDietas, 0, 2);
		lblNombreDietas.setVisible(false);
		panelRegistroListaDietas.add(lblNumComidas, 0, 3);
		lblNumComidas.setVisible(false);
		panelRegistroListaDietas.add(confirmar, 0, 4);

		panelRegistroListaDietas.setMargin(chbEligeDieta, new Insets(5, 10, 5, 10));

		panelRegistroListaDietas.setMargin(lblDietas, new Insets(5, 10, 5, 10));
		panelRegistroListaDietas.setMargin(lblNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroListaDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroListaDietas.setMargin(confirmar, new Insets(5, 10, 5, 10));

		panelRegistroListaDietas.setHalignment(chbEligeDieta, HPos.CENTER);

		panelRegistroListaDietas.setHalignment(lblDietas, HPos.CENTER);
		panelRegistroListaDietas.setHalignment(lblNombreDietas, HPos.CENTER);
		panelRegistroListaDietas.setHalignment(lblNumComidas, HPos.CENTER);

		panelRegistroListaDietas.setHalignment(confirmar, HPos.CENTER);

		Scene sceneRegistroListaDietas = new Scene(panelRegistroListaDietas, 600, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneRegistroListaDietas.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneRegistroListaDietas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneRegistroListaDietas.getRoot().getStyleClass().add("body");

		stageRegistroListaDietas.setResizable(false);
		stageRegistroListaDietas.setScene(sceneRegistroListaDietas);
		stageRegistroListaDietas.setTitle("Mostrar Dieta");
		stageRegistroListaDietas.show();

		// Una vez presiona en confirmar, muestra todos los datos en labels y pone
		// visibles las que estaban invisibles
		confirmar.setOnAction(e -> {
			Label lblMuestraDieta = new Label(String.valueOf(ListaDietasDAO
					.getListaDietas(App.con, String.valueOf(chbEligeDieta.getValue())).getIdListaDietas()));
			Label lblMuestraNombreDietas = new Label(String.valueOf(
					ListaDietasDAO.getListaDietas(App.con, String.valueOf(chbEligeDieta.getValue())).getNombre()));
			Label lblMuestraNumComidas = new Label(String.valueOf(
					ListaDietasDAO.getListaDietas(App.con, String.valueOf(chbEligeDieta.getValue())).getNumComidas()));

			lblDietas.setVisible(true);
			lblNombreDietas.setVisible(true);
			lblNumComidas.setVisible(true);
			chbEligeDieta.setVisible(false);
			confirmar.setVisible(false);

			panelRegistroListaDietas.add(lblMuestraDieta, 1, 1);
			panelRegistroListaDietas.add(lblMuestraNombreDietas, 1, 2);
			panelRegistroListaDietas.add(lblMuestraNumComidas, 1, 3);

			panelRegistroListaDietas.setMargin(lblMuestraDieta, new Insets(5, 10, 5, 10));
			panelRegistroListaDietas.setMargin(lblMuestraNombreDietas, new Insets(5, 10, 5, 10));
			panelRegistroListaDietas.setMargin(lblMuestraNumComidas, new Insets(5, 10, 5, 10));

			panelRegistroListaDietas.setHalignment(lblMuestraDieta, HPos.CENTER);
			panelRegistroListaDietas.setHalignment(lblMuestraNombreDietas, HPos.CENTER);
			panelRegistroListaDietas.setHalignment(lblMuestraNumComidas, HPos.CENTER);
		});
	}

}