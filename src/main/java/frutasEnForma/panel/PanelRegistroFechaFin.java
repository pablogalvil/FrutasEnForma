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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRegistroFechaFin extends GridPane {
	/**
	 * Panel para actualizar la fechaFin
	 */
	public PanelRegistroFechaFin() {
		Stage stagePanelFechaFin = new Stage();

		GridPane panelFechaFin = new GridPane();
		panelFechaFin.setAlignment(Pos.CENTER);

		Label lblFechaFin = new Label("Inserta un nombre de registro y elige la fecha de finalizacion");

		TextField txtNombre = new TextField();

		DatePicker fechaFin = new DatePicker();

		Button btnFechaFin = new Button("Confirmar");

		panelFechaFin.setHalignment(lblFechaFin, HPos.CENTER);
		panelFechaFin.setHalignment(txtNombre, HPos.CENTER);
		panelFechaFin.setHalignment(fechaFin, HPos.CENTER);
		panelFechaFin.setHalignment(btnFechaFin, HPos.CENTER);

		panelFechaFin.add(lblFechaFin, 0, 0);
		panelFechaFin.add(txtNombre, 0, 1);
		panelFechaFin.add(fechaFin, 0, 2);
		panelFechaFin.add(btnFechaFin, 0, 3);

		panelFechaFin.setMargin(txtNombre, new Insets(5, 10, 5, 10));
		panelFechaFin.setMargin(fechaFin, new Insets(5, 10, 5, 10));

		Scene scenePanelFechaFin = new Scene(panelFechaFin, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			scenePanelFechaFin.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			scenePanelFechaFin.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		scenePanelFechaFin.getRoot().getStyleClass().add("body");

		stagePanelFechaFin.setResizable(false);
		stagePanelFechaFin.setScene(scenePanelFechaFin);
		stagePanelFechaFin.setTitle("Editar usuario");
		stagePanelFechaFin.show();

		btnFechaFin.setOnAction(e -> {
			String StringFechaFin = String.valueOf(fechaFin.getValue());

			if (RegistroDietasDAO.insertFechaFin(App.con, StringFechaFin, txtNombre.getText())) {
				infoFechaFin();
				stagePanelFechaFin.close();
			} else {
				alertaFechaFin();
			}

		});

	}

	/**
	 * Alerta que salta si hay problemas con la funcion de cambiar la fecha fin.
	 */
	public void alertaFechaFin() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No ha introducido correctamente los datos");
		infoAlert.setContentText("Por favor vuelva a intentarlo");
		infoAlert.showAndWait();
	}

	/**
	 * Alerta que salta si todo ha ido bien.
	 */
	public void infoFechaFin() {
		AlertType tipoAlerta = Alert.AlertType.INFORMATION;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle(":)");
		infoAlert.setHeaderText("Todo ha ido bien");
		infoAlert.setContentText("Volviendo al menu principal");
		infoAlert.showAndWait();
	}
}
