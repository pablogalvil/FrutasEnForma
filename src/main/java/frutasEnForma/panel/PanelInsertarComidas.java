package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.ComidasDAO;
import frutasEnForma.model.ComidasDO;
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

public class PanelInsertarComidas extends GridPane {
	/**
	 * Panel para insertar comidas
	 */
	public PanelInsertarComidas() {
		// Creamos el stage
		Stage ventanaInsertarComidas = new Stage();

		// Creamos el panel
		GridPane panelInsertarComidas = new GridPane();
		// Le ponemos la posicion al centro
		panelInsertarComidas.setAlignment(Pos.CENTER);

		// Labels
		Label lblNombre = new Label("Inserta el nombre");
		Label lblCalorias = new Label("Inserta las calorias");
		Label lblIdRecetas = new Label("Inserta el numero de la\nreceta que le corresponde");

		panelInsertarComidas.setMargin(lblNombre, new Insets(5, 10, 5, 10));
		panelInsertarComidas.setMargin(lblCalorias, new Insets(5, 10, 5, 10));
		panelInsertarComidas.setMargin(lblIdRecetas, new Insets(5, 10, 5, 10));

		panelInsertarComidas.setHalignment(lblNombre, HPos.CENTER);
		panelInsertarComidas.setHalignment(lblCalorias, HPos.CENTER);
		panelInsertarComidas.setHalignment(lblIdRecetas, HPos.CENTER);

		// TextFields
		TextField txtNombre = new TextField();
		TextField txtCalorias = new TextField();
		TextField txtIdRecetas = new TextField();

		panelInsertarComidas.setMargin(txtNombre, new Insets(5, 10, 5, 10));
		panelInsertarComidas.setMargin(txtCalorias, new Insets(5, 10, 5, 10));
		panelInsertarComidas.setMargin(txtIdRecetas, new Insets(5, 10, 5, 10));

		panelInsertarComidas.setHalignment(txtNombre, HPos.CENTER);
		panelInsertarComidas.setHalignment(txtCalorias, HPos.CENTER);
		panelInsertarComidas.setHalignment(txtIdRecetas, HPos.CENTER);

		// Boton
		Button btnConfirmar = new Button("Confirmar");

		panelInsertarComidas.setMargin(btnConfirmar, new Insets(5, 10, 5, 10));

		panelInsertarComidas.setHalignment(btnConfirmar, HPos.CENTER);

		// Añadimos todo al panel
		panelInsertarComidas.add(lblNombre, 0, 0);
		panelInsertarComidas.add(txtNombre, 1, 0);
		panelInsertarComidas.add(lblCalorias, 0, 1);
		panelInsertarComidas.add(txtCalorias, 1, 1);
		panelInsertarComidas.add(lblIdRecetas, 0, 2);
		panelInsertarComidas.add(txtIdRecetas, 1, 2);
		panelInsertarComidas.add(btnConfirmar, 0, 3);

		Scene sceneInsertarComidas = new Scene(panelInsertarComidas, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneInsertarComidas.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneInsertarComidas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneInsertarComidas.getRoot().getStyleClass().add("body");

		ventanaInsertarComidas.setScene(sceneInsertarComidas);
		ventanaInsertarComidas.setTitle("Insertar comidas");
		ventanaInsertarComidas.show();

		// Llamamos a la funcion cuando pulsan el boton
		btnConfirmar.setOnAction(e -> {
			ComidasDO temp = new ComidasDO();

			temp.setNombre(txtNombre.getText());
			temp.setCalorias(Integer.valueOf(txtCalorias.getText()));
			temp.setRecetas_idRecetas(Integer.valueOf(txtIdRecetas.getText()));

			// Si la funcion falla, salta la alerta
			if (ComidasDAO.insertComidas(App.con, temp))
				ventanaInsertarComidas.close();
			else
				alertaInsertComidas();
		});
	}

	/**
	 * Alerta en caso de error
	 */
	public void alertaInsertComidas() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No ha introducido correctamente los datos");
		infoAlert.setContentText("Por favor vuelva a intentarlo");
		infoAlert.showAndWait();
	}
}
