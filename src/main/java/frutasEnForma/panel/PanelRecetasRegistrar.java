package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.RecetasDAO;
import frutasEnForma.model.RecetasDO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRecetasRegistrar extends GridPane {

	private int PNLidRec;
	private String PNLnombre;
	private int PNLtiempoPreparacion;
	private String PNLingredientes;
	private String PNLpasos;

	public PanelRecetasRegistrar() {
		// Creamos el Stage y el GridPane
		Stage stageRegistrarRecetas = new Stage();

		GridPane panelRegistroRecetas = new GridPane();

		panelRegistroRecetas.setAlignment(Pos.CENTER);

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

		Button confirmar = new Button("Confirmar");

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

		panelRegistroRecetas.add(txtPasos, 0, 5);

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

		panelRegistroRecetas.setMargin(confirmar, new Insets(5, 10, 5, 10));

		// La scene
		Scene sceneRegistrarRecetas = new Scene(panelRegistroRecetas, 800, 600);

		sceneRegistrarRecetas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
		sceneRegistrarRecetas.getRoot().getStyleClass().add("body");

		// Ponemos los setHalignment alineados en el centro

		this.setHalignment(lblRecetas, HPos.CENTER);
		this.setHalignment(lblNombre, HPos.CENTER);
		this.setHalignment(lblTiempoPrep, HPos.CENTER);
		this.setHalignment(lblIngred, HPos.CENTER);
		this.setHalignment(lblPasos, HPos.CENTER);

		this.setHalignment(txtRecetas, HPos.CENTER);
		this.setHalignment(txtNombre, HPos.CENTER);
		this.setHalignment(txtTiempoPrep, HPos.CENTER);
		this.setHalignment(txtIngred, HPos.CENTER);
		this.setHalignment(txtPasos, HPos.CENTER);

		this.setHalignment(confirmar, HPos.CENTER);

		stageRegistrarRecetas.setScene(sceneRegistrarRecetas);
		stageRegistrarRecetas.setTitle("Borrar Receta");
		stageRegistrarRecetas.show();

		RecetasDO temp = new RecetasDO();

		temp.setNombre(txtNombre.getText());
		temp.setTiempoPreparacion(Integer.valueOf(txtTiempoPrep.getText()));
		temp.setIngredientes(txtIngred.getText());
		temp.setPasos(txtPasos.getText());

		confirmar.setOnAction(e -> {
			RecetasDAO.insertRecetas(App.con, temp);
		});
	}
}
