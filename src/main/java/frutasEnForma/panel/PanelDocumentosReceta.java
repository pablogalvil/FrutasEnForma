package frutasEnForma.panel;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import frutasEnForma.model.RecetasDO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelDocumentosReceta extends GridPane {
	public PanelDocumentosReceta() {

		Stage ventanaEmergente = new Stage();

		GridPane panelInsertarRecetas = new GridPane();

		panelInsertarRecetas.setAlignment(Pos.CENTER);

		// Definimos las label

		Label lblInsNombre = new Label("Insertamos el nombre");
		Label lblInsTiempoPrep = new Label("Insertamos el tiempo Preparación");
		Label lblInsIngred = new Label("Insertamos los ingredientes");
		Label lblInsPasos = new Label("Insertamos los pasos");

		TextField txtInsNombre = new TextField();
		TextField txtInsTiempoPrep = new TextField();
		TextField txtInsIngred = new TextField();
		TextField txtInsPasos = new TextField();

		Button confirmar = new Button("Confirmar");
		Button confirmar1 = new Button("Confirmar");
		Button confirmar2 = new Button("Confirmar");

		panelInsertarRecetas.add(lblInsNombre, 0, 1);
		panelInsertarRecetas.add(txtInsNombre, 0, 2);

		panelInsertarRecetas.add(lblInsTiempoPrep, 0, 3);
		panelInsertarRecetas.add(txtInsTiempoPrep, 0, 4);

		panelInsertarRecetas.add(lblInsIngred, 0, 5);
		panelInsertarRecetas.add(txtInsIngred, 0, 6);

		panelInsertarRecetas.add(lblInsPasos, 0, 7);
		panelInsertarRecetas.add(txtInsPasos, 0, 8);

		panelInsertarRecetas.add(confirmar, 0, 9);
		panelInsertarRecetas.add(confirmar1, 0, 10);
		panelInsertarRecetas.add(confirmar2, 0, 11);

		confirmar.setOnAction(event -> {
			String nombreTemp = txtInsNombre.getText();
			int tiempoTemp = Integer.valueOf(txtInsTiempoPrep.getText());
			String ingredTemp = txtInsIngred.getText();
			String pasosTemp = txtInsPasos.getText();

			RecetasDO temp = new RecetasDO(0, nombreTemp, tiempoTemp, ingredTemp, pasosTemp);

			abrirPDF("D:\\Programación\\FrutasEnForma\\FrutasEnForma\\src\\main\\resources\\doc\\DietaDash.pdf");
		});

		confirmar1.setOnAction(event -> {
			abrirPDF("D:\\Programación\\FrutasEnForma\\FrutasEnForma\\src\\main\\resources\\doc\\DietaFrutariana.pdf");
		});
		confirmar2.setOnAction(event -> {
			abrirPDF(
					"D:\\Programación\\FrutasEnForma\\FrutasEnForma\\src\\main\\resources\\doc\\DietaMediterranea.pdf");
		});

		Scene sceneInsertarRecetas = new Scene(panelInsertarRecetas, 800, 600);

		sceneInsertarRecetas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
		sceneInsertarRecetas.getRoot().getStyleClass().add("body");

		this.setHalignment(lblInsNombre, HPos.CENTER);
		this.setHalignment(txtInsNombre, HPos.CENTER);
		this.setHalignment(lblInsTiempoPrep, HPos.CENTER);
		this.setHalignment(txtInsTiempoPrep, HPos.CENTER);
		this.setHalignment(lblInsIngred, HPos.CENTER);
		this.setHalignment(txtInsIngred, HPos.CENTER);
		this.setHalignment(lblInsPasos, HPos.CENTER);
		this.setHalignment(txtInsPasos, HPos.CENTER);
		this.setHalignment(confirmar, HPos.CENTER);
		this.setHalignment(confirmar1, HPos.CENTER);
		this.setHalignment(confirmar2, HPos.CENTER);

		lblInsNombre.setId("labelRecetas");
		txtInsNombre.setId("txtRecetas");
		lblInsTiempoPrep.setId("labelRecetas");
		txtInsTiempoPrep.setId("txtRecetas");
		lblInsIngred.setId("labelRecetas");
		txtInsIngred.setId("txtRecetas");
		lblInsPasos.setId("labelRecetas");
		txtInsPasos.setId("txtRecetas");
		confirmar.setId("buttonRecetas");
		confirmar1.setId("buttonRecetas");
		confirmar2.setId("buttonRecetas");

		ventanaEmergente.setScene(sceneInsertarRecetas);
		ventanaEmergente.setTitle("Aniadir Receta");
		ventanaEmergente.show();

	}

	// ABRIR UN ARCHIVO PDF

	public static void abrirPDF(String ruta) {

		// RUTA DEL PDF
		String pdfManual = ruta;

		// PARA QUE EL ARCHIVO SE ABRA
		try {

			File file = new File(pdfManual);
			if (file.exists()) {
				Desktop.getDesktop().open(file);
			} else {
				System.out.println("Este pdf no existe con esta ruta");
			}

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error al abrir el pdf " + e.getMessage());
		}
	}

}
