package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
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

		InsId = Integer.valueOf(txtInsId.getText());

		Button Confirmar = new Button("Confirm");
		Button Salir = new Button("Salir");

		panelListaBorrar.add(lblInsId, 0, 0);
		panelListaBorrar.add(txtInsId, 1, 0);
		panelListaBorrar.add(Confirmar, 0, 2);
		panelListaBorrar.add(Salir, 1, 2);

		panelListaBorrar.setMargin(lblInsId, new Insets(5, 10, 5, 10));

		panelListaBorrar.setMargin(txtInsId, new Insets(5, 10, 5, 10));

		panelListaBorrar.setMargin(Confirmar, new Insets(5, 10, 5, 10));
		panelListaBorrar.setMargin(Salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelListaBorrar, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Borrar Dieta");
		ventanaEmergente.show();
	}
}
