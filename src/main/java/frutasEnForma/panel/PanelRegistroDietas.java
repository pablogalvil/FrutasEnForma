package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRegistroDietas extends GridPane {

	public static String InsNomRe;

	public PanelRegistroDietas() {

		Stage ventanaEmergente = new Stage();

		GridPane panelListaAniadir = new GridPane();

		Label lblInsNom = new Label("Inserta el nombre de una dieta");

		TextField txtInsNom = new TextField();

		InsNomRe = txtInsNom.getText();

		Button confirmar = new Button("Confirm");
		Button salir = new Button("Salir");

		panelListaAniadir.add(lblInsNom, 0, 0);
		panelListaAniadir.add(txtInsNom, 1, 0);
		panelListaAniadir.add(confirmar, 0, 1);
		panelListaAniadir.add(salir, 1, 1);

		panelListaAniadir.setMargin(lblInsNom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(txtInsNom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(confirmar, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelListaAniadir, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Aniadir Registro");
		ventanaEmergente.show();

		salir.setOnAction(e -> {
			ventanaEmergente.close();

		});

		confirmar.setOnAction(e -> {
			ventanaEmergente.close();

		});

	}
}
