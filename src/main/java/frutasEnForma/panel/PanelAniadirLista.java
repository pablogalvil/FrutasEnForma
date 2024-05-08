package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.ListaDietasDAO;
import frutasEnForma.model.ListaDietasDO;
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

public class PanelAniadirLista extends GridPane {

	public static String InsNom;
	public static int InsCom;

	/**
	 * Panel que añade una dieta a la lista pidiendo el nombre de la dieta y su
	 * numero de comidas.
	 */
	public PanelAniadirLista() {

		Stage stageListaAniadir = new Stage();

		GridPane panelListaAniadir = new GridPane();
		panelListaAniadir.setAlignment(Pos.CENTER);

		Label lblInsNom = new Label("Inserta el nombre de la dieta");
		Label lblInsCom = new Label("Inserta el numero de comidas de la dieta");

		TextField txtInsNom = new TextField();
		TextField txtInsCom = new TextField();

		Button confirmar = new Button("Confirm");

		panelListaAniadir.add(lblInsNom, 0, 0);
		panelListaAniadir.add(txtInsNom, 1, 0);
		panelListaAniadir.add(lblInsCom, 0, 1);
		panelListaAniadir.add(txtInsCom, 1, 1);
		panelListaAniadir.add(confirmar, 0, 2);

		panelListaAniadir.setMargin(lblInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(lblInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(txtInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(txtInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(confirmar, new Insets(5, 10, 5, 10));

		panelListaAniadir.setHalignment(lblInsNom, HPos.CENTER);
		panelListaAniadir.setHalignment(lblInsCom, HPos.CENTER);

		panelListaAniadir.setHalignment(txtInsNom, HPos.CENTER);
		panelListaAniadir.setHalignment(txtInsCom, HPos.CENTER);

		panelListaAniadir.setHalignment(confirmar, HPos.CENTER);

		Scene sceneListaAniadir = new Scene(panelListaAniadir, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneListaAniadir.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneListaAniadir.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneListaAniadir.getRoot().getStyleClass().add("body");

		stageListaAniadir.setResizable(false);
		stageListaAniadir.setScene(sceneListaAniadir);
		stageListaAniadir.setTitle("Aniadir Dieta");
		stageListaAniadir.show();

		confirmar.setOnAction(e -> {
			try {
				ListaDietasDO temp = new ListaDietasDO();
				temp.setNombre(txtInsNom.getText());
				temp.setNumComidas(Integer.valueOf(txtInsCom.getText()));

				// Si da true se cierra la ventana, si da false salta una alerta.
				if (ListaDietasDAO.aniadirLista(App.con, temp)) {
					stageListaAniadir.close();
				} else {
					alertaRegistro();
				}
			} catch (Exception error) {
				// Si salta la excepcion tambien salta la alerta
				error.printStackTrace();
				alertaRegistro();
			}

		});
	}

	/**
	 * Alerta que salta cuando hay problemas al intentar añadir una dieta.
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
