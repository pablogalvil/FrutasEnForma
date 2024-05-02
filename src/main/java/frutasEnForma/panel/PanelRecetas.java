package frutasEnForma.panel;

import frutasEnForma.model.RecetasDO;
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
		Scene scene = new Scene(panelRegistroRecetas, 100, 100);

		// INSERTAR
	}

	public void InsertarLista() {

		Stage ventanaEmergente = new Stage();

		GridPane panelInsertarRecetas = new GridPane();

		// Definimos las label

		Label lblInsNombre = new Label("Insertamos el nombre");
		Label lblInsTiempoPrep = new Label("Insertamos el tiempo Preparación");
		Label lblInsIngred = new Label("Insertamos los ingredientes");
		Label lblInsPasos = new Label("Insertamos los pasos");

		TextField txtInsNombre = new TextField();
		TextField txtInsTiempoPrep = new TextField();
		TextField txtInsIngred = new TextField();
		TextField txtInsPasos = new TextField();

		String nombreTemp = txtInsNombre.getText();
		int tiempoTemp = Integer.valueOf(txtInsTiempoPrep.getText());
		String ingredTemp = txtInsIngred.getText();
		String pasosTemp = txtInsPasos.getText();

		RecetasDO temp = new RecetasDO(0, nombreTemp, tiempoTemp, ingredTemp, pasosTemp);

		Scene scene = new Scene(panelInsertarRecetas, 200, 200);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Añadir Receta");
		ventanaEmergente.show();

	}

	// BORRAR

	/*
	 * Stage ventanaEmergente = new Stage();
	 * 
	 * GridPane panelBorrarRecetas = new GridPane();
	 * 
	 * Label lblBorrarNombre = new
	 * Label("Borramos a partir del nombre que tenga la receta");
	 * 
	 * TextField txtBorrarNombre = new TextField();
	 * 
	 * BorrarNombre=Integer.valueOf(txtBorrarNombre.getText());
	 * 
	 * // Botones de confirmar y salir
	 * 
	 * Button Confirmar = new Button("Confirmar"); Button Salir = new
	 * Button("Salir");
	 */

}
