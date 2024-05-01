package frutasEnForma.panel;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PanelPrincipal extends GridPane {

	public PanelPrincipal() {
		
		Label lblInicio = new Label("Bienvenido, por favor inicie sesion antes de continuar utilizando la aplicacion.");
		Label lblAviso = new Label("Tenga en cuenta que al no iniciar sesion no podra usar algunas partes de la aplicacion.");

		Button inicio = new Button("Ir al inicio de sesion");
		Button acercaDe = new Button("Acerca de");
		Button listaDietas = new Button ("Ver Dietas");
		Button calculadoraImc = new Button ("Calcular imc");
		
		this.add(lblInicio, 0, 0);
		this.add(inicio, 0, 1);
		this.add(lblAviso, 0, 2);
		this.add(acercaDe, 0, 3);
		this.add(listaDietas, 0, 4);
		this.add(calculadoraImc, 0, 5);
		
		inicio.setOnAction(e -> {
			PanelInicioSesion panelInicio = new PanelInicioSesion();
		});
		acercaDe.setOnAction(e -> {
			acercaDe();
		});
		listaDietas.setOnAction(e -> {
			PanelListaDietas registro = new PanelListaDietas();
		});
		calculadoraImc.setOnAction(e -> {
			PanelCalculadoraImc calculoImc = new PanelCalculadoraImc();
		});
	}
	
	/**
	 * Panel de la opcion de ayuda acerca de
	 */
	public void acercaDe() {
		AlertType tipoAlerta = Alert.AlertType.INFORMATION;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Acerca de");
		infoAlert.setHeaderText("©FrutasEnForma");
		
		String url = "https://github.com/pablogalvil/FrutasEnForma";
		
		infoAlert.setContentText(url);
		infoAlert.showAndWait();
	}
}
