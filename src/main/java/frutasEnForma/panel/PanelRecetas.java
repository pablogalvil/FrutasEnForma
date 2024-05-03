package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRecetas extends GridPane {

	private int PNLidRec;
	private String PNLnombre;
	private int PNLtiempoPreparacion;
	private String PNLingredientes;
	private String PNLpasos;

	public PanelRecetas() {
		Stage ventanaEmergente = new Stage();

		GridPane panelRegistroRecetas = new GridPane();

		// Definimos las label
		Label lblRecetas = new Label("Recetas");
		Label lblNombre = new Label("Nombre");
		Label lblTiempoPrep = new Label("Tiempo Preparación");
		Label lblIngred = new Label("Ingredientes");
		Label lblPasos = new Label("Pasos");

		// Definimos los TextField

		TextField txtRecetas = new TextField();
		TextField txtNombre = new TextField();
		TextField txtTiempoPrep = new TextField();
		TextField txtIngred = new TextField();
		TextField txtPasos = new TextField();

		// Ponemos el boton de salir
		Button Salir = new Button("Confirmar");

		// Hacemos el panel de registros de Recetas
		panelRegistroRecetas.add(lblRecetas, 0, 0);
		panelRegistroRecetas.add(lblNombre, 0, 1);
		panelRegistroRecetas.add(lblTiempoPrep, 0, 2);
		panelRegistroRecetas.add(lblIngred, 0, 3);
		panelRegistroRecetas.add(lblPasos, 0, 4);

		panelRegistroRecetas.add(txtRecetas, 1, 0);
		panelRegistroRecetas.add(txtNombre, 1, 1);
		panelRegistroRecetas.add(txtTiempoPrep, 1, 2);
		panelRegistroRecetas.add(txtIngred, 1, 3);
		panelRegistroRecetas.add(txtPasos, 1, 4);

		// Hacemos los setMargin
		panelRegistroRecetas.setMargin(lblRecetas, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(lblNombre, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(lblTiempoPrep, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(lblIngred, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(lblPasos, new Insets(5, 10, 5, 10));

		panelRegistroRecetas.setMargin(txtRecetas, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(txtNombre, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(txtTiempoPrep, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(txtIngred, new Insets(5, 10, 5, 10));
		panelRegistroRecetas.setMargin(txtPasos, new Insets(5, 10, 5, 10));

		// Hago el panel de salir
		panelRegistroRecetas.setMargin(Salir, new Insets(5, 10, 5, 10));

		// La scene
		Scene scene = new Scene(panelRegistroRecetas, 800, 600);

		// INSERTAR
	}

	// BORRAR
	public void BorrarRecetas() {
		Stage ventanaEmergente = new Stage();

		GridPane panelBorrarRecetas = new GridPane();

		Label lblBorrarNombre = new Label("Borramos a partir del nombre que tenga la receta");

		TextField txtBorrarNombre = new TextField();

		String BorrarNombre = txtBorrarNombre.getText();

		// Botones de confirmar y salir

		Button Confirmar = new Button("Confirmar");
		Button Salir = new Button("Salir");

		// Label

		panelBorrarRecetas.add(lblBorrarNombre, 0, 0);
		panelBorrarRecetas.add(txtBorrarNombre, 0, 1);
		panelBorrarRecetas.add(Confirmar, 0, 2);
		panelBorrarRecetas.add(Salir, 0, 3);

		panelBorrarRecetas.setMargin(lblBorrarNombre, new Insets(5, 10, 5, 10));
		panelBorrarRecetas.setMargin(txtBorrarNombre, new Insets(5, 10, 5, 10));
		panelBorrarRecetas.setMargin(Confirmar, new Insets(5, 10, 5, 10));
		panelBorrarRecetas.setMargin(Salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelBorrarRecetas, 800, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Borrar Receta");
		ventanaEmergente.show();

	}
}
