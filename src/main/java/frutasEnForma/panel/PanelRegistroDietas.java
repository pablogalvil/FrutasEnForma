package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.RegistroDietasDAO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRegistroDietas extends GridPane {

	public static String InsNomRe;

	/**
	 * Panel de registro de dietas
	 */
	public PanelRegistroDietas() {

		Stage stageRegistroDietas = new Stage();

		GridPane panelRegistroDietas = new GridPane();
		panelRegistroDietas.setAlignment(Pos.CENTER);

		Label lblInsNom = new Label("Inserta el nombre de una dieta");

		TextField txtInsNom = new TextField();

		Button confirmar = new Button("Confirm");

		panelRegistroDietas.add(lblInsNom, 0, 0);
		panelRegistroDietas.add(txtInsNom, 1, 0);
		panelRegistroDietas.add(confirmar, 0, 1);

		panelRegistroDietas.setMargin(lblInsNom, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(txtInsNom, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(confirmar, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setHalignment(lblInsNom, HPos.CENTER);
		panelRegistroDietas.setHalignment(txtInsNom, HPos.CENTER);
		panelRegistroDietas.setHalignment(confirmar, HPos.CENTER);

		Scene sceneRegistroDietas = new Scene(panelRegistroDietas, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneRegistroDietas.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneRegistroDietas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneRegistroDietas.getRoot().getStyleClass().add("body");

		stageRegistroDietas.setScene(sceneRegistroDietas);
		stageRegistroDietas.setTitle("Aniadir Registro");
		stageRegistroDietas.show();

		// Llamamos a la funcion cuando pulsan el boton
		confirmar.setOnAction(e -> {
			// Si la funcion falla, salta la alerta
			if (RegistroDietasDAO.seleccionDietas(App.con, txtInsNom.getText()))
				stageRegistroDietas.close();
			else
				alertaRegistro();
		});

	}

	/**
	 * Alerta en caso de error
	 */
	public void alertaRegistro() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No ha introducido correctamente los datos");
		infoAlert.setContentText("Por favor vuelva a intentarlo");
		infoAlert.showAndWait();
	}
}
