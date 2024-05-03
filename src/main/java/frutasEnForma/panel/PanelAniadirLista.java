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

public class PanelAniadirLista extends GridPane {

	public static String InsNom;
	public static int InsCom;

	public void PanelAniadirLista() {

		Stage ventanaEmergente = new Stage();

		GridPane panelListaAniadir = new GridPane();

		Label lblInsNom = new Label("Inserta el nombre de la dieta");
		Label lblInsCom = new Label("Inserta el numero de comidas de la dieta");

		TextField txtInsNom = new TextField();
		TextField txtInsCom = new TextField();

		Button confirmar = new Button("Confirm");
		Button salir = new Button("Salir");

		panelListaAniadir.add(lblInsNom, 0, 0);
		panelListaAniadir.add(txtInsNom, 1, 0);
		panelListaAniadir.add(lblInsCom, 0, 1);
		panelListaAniadir.add(txtInsCom, 1, 1);
		panelListaAniadir.add(confirmar, 0, 2);
		panelListaAniadir.add(salir, 1, 2);

		panelListaAniadir.setMargin(lblInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(lblInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(txtInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(txtInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(confirmar, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelListaAniadir, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Aniadir Dieta");
		ventanaEmergente.show();

		confirmar.setOnAction(e -> {
			try {
				ListaDietasDO temp = new ListaDietasDO();
				temp.setNombre(txtInsNom.getText());
				temp.setNumComidas(Integer.valueOf(txtInsCom.getText()));

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
