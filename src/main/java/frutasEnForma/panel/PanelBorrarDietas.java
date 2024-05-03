package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.ListaDietasDAO;
import frutasEnForma.model.ListaDietasDO;
import javafx.geometry.Insets;
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

	public void PanelBorrarDietas() {

		Stage ventanaEmergente = new Stage();

		GridPane panelListaBorrar = new GridPane();

		Label lblInsId = new Label("Inserta el Id de la dieta");

		TextField txtInsId = new TextField();

		Button confirmar = new Button("Confirm");
		Button salir = new Button("Salir");

		panelListaBorrar.add(lblInsId, 0, 0);
		panelListaBorrar.add(txtInsId, 1, 0);
		panelListaBorrar.add(confirmar, 0, 2);
		panelListaBorrar.add(salir, 1, 2);

		panelListaBorrar.setMargin(lblInsId, new Insets(5, 10, 5, 10));

		panelListaBorrar.setMargin(txtInsId, new Insets(5, 10, 5, 10));

		panelListaBorrar.setMargin(confirmar, new Insets(5, 10, 5, 10));
		panelListaBorrar.setMargin(salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelListaBorrar, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Borrar Dieta");
		ventanaEmergente.show();

		confirmar.setOnAction(e -> {
			try {
				ListaDietasDO temp = new ListaDietasDO();
				temp.setNumComidas(Integer.valueOf(txtInsId.getText()));

				if (ListaDietasDAO.aniadirLista(App.con, temp)) {
					ventanaEmergente.close();

				} else {
					alertaRegistro();
				}
			} catch (Exception error) {
				error.printStackTrace();
				alertaRegistro();
			}

		});
	}

	public void alertaRegistro() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No ha introducido correctamente los datos");
		infoAlert.setContentText("Por favor vuelva a intentarlo");
		infoAlert.showAndWait();
	}
}
