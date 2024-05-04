package frutasEnForma.panel;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import frutasEnForma.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelDocumentosReceta extends GridPane {
	private static String valor;

	public PanelDocumentosReceta() {

		Stage stageDocumentosRecetas = new Stage();

		GridPane panelMostrarRecetas = new GridPane();

		panelMostrarRecetas.setAlignment(Pos.CENTER);

		ChoiceBox chbEligeDieta = new ChoiceBox();
		chbEligeDieta.getItems().addAll("Dieta Dash", "Dieta Frutariana", "Dieta Mediterranea");

		Button confirmar = new Button("Mostrar Recetas");

		panelMostrarRecetas.add(chbEligeDieta, 0, 0);
		panelMostrarRecetas.add(confirmar, 0, 1);

		chbEligeDieta.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				valor = (String) chbEligeDieta.getValue();
			}
		});

		confirmar.setOnAction(event -> {
			if (valor.equals("Dieta Dash"))
				abrirPDF("C:\\Programación\\FrutasEnForma\\src\\main\\resources\\doc\\DietaDash.pdf");
			else if (valor.equals("Dieta Frutariana"))
				abrirPDF("C:\\Programación\\FrutasEnForma\\src\\main\\resources\\doc\\DietaFrutariana.pdf");
			else if (valor.equals("Dieta Mediterranea"))
				abrirPDF("C:\\Programación\\FrutasEnForma\\src\\main\\resources\\doc\\DietaMediterranea.pdf");
		});

		Scene sceneMostrarRecetas = new Scene(panelMostrarRecetas, 800, 600);

		if (App.configuracion.getTheme() == 1)
			sceneMostrarRecetas.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneMostrarRecetas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneMostrarRecetas.getRoot().getStyleClass().add("body");

		this.setHalignment(chbEligeDieta, HPos.CENTER);
		this.setHalignment(confirmar, HPos.CENTER);

		panelMostrarRecetas.setMargin(chbEligeDieta, new Insets(5, 10, 5, 10));
		panelMostrarRecetas.setMargin(confirmar, new Insets(5, 10, 5, 10));

		stageDocumentosRecetas.setScene(sceneMostrarRecetas);
		stageDocumentosRecetas.setTitle("Aniadir Receta");
		stageDocumentosRecetas.show();

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
