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
		Stage stageBorrarRecetas = new Stage();

		GridPane panelBorrarRecetas = new GridPane();

		panelBorrarRecetas.setAlignment(Pos.CENTER);

		Label lblBorrarNombre = new Label("Borramos a partir del nombre que tenga la receta");

		TextField txtBorrarNombre = new TextField();

		String borrarNombre = txtBorrarNombre.getText();

		// Botones de confirmar y salir

		Button confirmar = new Button("Confirmar");

		// Label

		panelBorrarRecetas.add(lblBorrarNombre, 0, 0);
		panelBorrarRecetas.add(txtBorrarNombre, 0, 1);
		panelBorrarRecetas.add(confirmar, 0, 2);

		panelBorrarRecetas.setMargin(lblBorrarNombre, new Insets(5, 10, 5, 10));
		panelBorrarRecetas.setMargin(txtBorrarNombre, new Insets(5, 10, 5, 10));
		panelBorrarRecetas.setMargin(confirmar, new Insets(5, 10, 5, 10));

		Scene sceneBorrarRecetas = new Scene(panelBorrarRecetas, 800, 600);
		sceneBorrarRecetas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
		sceneBorrarRecetas.getRoot().getStyleClass().add("body");

		lblBorrarNombre.setId("labelRecetas");
		txtBorrarNombre.setId("txtRecetas");
		confirmar.setId("buttonRecetas");

		this.setHalignment(lblBorrarNombre, HPos.CENTER);
		this.setHalignment(txtBorrarNombre, HPos.CENTER);
		this.setHalignment(confirmar, HPos.CENTER);

		stageBorrarRecetas.setScene(sceneBorrarRecetas);
		stageBorrarRecetas.setTitle("Borrar Receta");
		stageBorrarRecetas.show();
	}
}
