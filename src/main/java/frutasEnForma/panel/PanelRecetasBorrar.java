package frutasEnForma.panel;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRecetasBorrar extends GridPane {
	public PanelRecetasBorrar() {

		// Creamos el Stage y el GridPane de borrar recetas
		Stage stageBorrarRecetas = new Stage();

		GridPane panelBorrarRecetas = new GridPane();

		// Alineamos el borrar recetas en el centro
		panelBorrarRecetas.setAlignment(Pos.CENTER);

		// Hacemos la label de borrar Nombre y hacemos el TextField

		Label lblBorrarNombre = new Label("Borramos a partir del nombre que tenga la receta");

		TextField txtBorrarNombre = new TextField();

		String borrarNombre = txtBorrarNombre.getText();

		// Boton de confirmar

		Button confirmar = new Button("Confirmar");

		// Ponemos todo los paneles

		panelBorrarRecetas.add(lblBorrarNombre, 0, 0);
		panelBorrarRecetas.add(txtBorrarNombre, 0, 1);
		panelBorrarRecetas.add(confirmar, 0, 2);

		panelBorrarRecetas.setMargin(lblBorrarNombre, new Insets(5, 10, 5, 10));
		panelBorrarRecetas.setMargin(txtBorrarNombre, new Insets(5, 10, 5, 10));
		panelBorrarRecetas.setMargin(confirmar, new Insets(5, 10, 5, 10));

		// Introducimos las escenas

		Scene sceneBorrarRecetas = new Scene(panelBorrarRecetas, 800, 600);
		sceneBorrarRecetas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
		sceneBorrarRecetas.getRoot().getStyleClass().add("body");

		// Ponemos los setHalignment centrados

		this.setHalignment(lblBorrarNombre, HPos.CENTER);
		this.setHalignment(txtBorrarNombre, HPos.CENTER);
		this.setHalignment(confirmar, HPos.CENTER);

		stageBorrarRecetas.setScene(sceneBorrarRecetas);
		stageBorrarRecetas.setTitle("Borrar Receta");
		stageBorrarRecetas.show();
	}
}
