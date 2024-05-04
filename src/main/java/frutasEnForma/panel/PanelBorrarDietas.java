package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.ListaDietasDAO;
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

public class PanelBorrarDietas extends GridPane {

	public static int InsId;

	/**
	 * Panel que borra dietas a partir de su id.
	 */
	public PanelBorrarDietas() {

		Stage stageListaBorrar = new Stage();

		GridPane panelListaBorrar = new GridPane();
		panelListaBorrar.setAlignment(Pos.CENTER);

		Label lblInsId = new Label("Inserta el numero de la dieta\n(usa la funcion de ver para saberlo)");

		TextField txtInsId = new TextField();

		Button confirmar = new Button("Confirm");

		panelListaBorrar.add(lblInsId, 0, 0);
		panelListaBorrar.add(txtInsId, 1, 0);
		panelListaBorrar.add(confirmar, 0, 2);

		panelListaBorrar.setMargin(lblInsId, new Insets(5, 10, 5, 10));
		panelListaBorrar.setHalignment(lblInsId, HPos.CENTER);

		panelListaBorrar.setMargin(txtInsId, new Insets(5, 10, 5, 10));
		panelListaBorrar.setHalignment(txtInsId, HPos.CENTER);

		panelListaBorrar.setMargin(confirmar, new Insets(5, 10, 5, 10));
		panelListaBorrar.setHalignment(confirmar, HPos.CENTER);

		Scene sceneListaBorrar = new Scene(panelListaBorrar, 600, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneListaBorrar.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneListaBorrar.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneListaBorrar.getRoot().getStyleClass().add("body");

		stageListaBorrar.setScene(sceneListaBorrar);
		stageListaBorrar.setTitle("Borrar Dieta");
		stageListaBorrar.show();

		confirmar.setOnAction(e -> {
			try {
				// Si es true se cierra la ventana, si es false salta una alerta
				if (ListaDietasDAO.borrarDieta(App.con, Integer.valueOf(txtInsId.getText()))) {
					stageListaBorrar.close();
				} else {
					alertaBorrar();
				}
			} catch (Exception error) {
				// En el error muestra la alerta tambien.
				error.printStackTrace();
				alertaBorrar();
			}

		});
	}

	/**
	 * Alerta que salta si hay problemas al borrar la dieta
	 */
	public void alertaBorrar() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No ha introducido correctamente los datos");
		infoAlert.setContentText("Por favor vuelva a intentarlo");
		infoAlert.showAndWait();
	}
}
