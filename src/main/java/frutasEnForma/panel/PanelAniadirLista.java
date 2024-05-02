package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
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

		InsNom = txtInsNom.getText();
		InsCom = Integer.valueOf(txtInsCom.getText());

		Button Confirmar = new Button("Confirm");
		Button Salir = new Button("Salir");

		panelListaAniadir.add(lblInsNom, 0, 0);
		panelListaAniadir.add(txtInsNom, 1, 0);
		panelListaAniadir.add(lblInsCom, 0, 1);
		panelListaAniadir.add(txtInsCom, 1, 1);
		panelListaAniadir.add(Confirmar, 0, 2);
		panelListaAniadir.add(Salir, 1, 2);

		panelListaAniadir.setMargin(lblInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(lblInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(txtInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(txtInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(Confirmar, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(Salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelListaAniadir, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Añadir Dieta");
		ventanaEmergente.show();
	}

}
