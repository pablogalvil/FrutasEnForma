package frutasEnForma.panel;

import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PanelPrincipal extends GridPane {

	public PanelPrincipal() {

		Label lblInicio = new Label("Bienvenido, por favor inicie sesion antes de continuar utilizando la aplicacion.");
		Label lblAviso = new Label(
				"Tenga en cuenta que al no iniciar sesion no podra usar algunas partes de la aplicacion.");
		Label lblCalculadoraImc = new Label(
				"En nuestra aplicacion disponemos de una calculadora para saber cual es su índice de masa corporal (IMC)");
		Label lblCalculadoraCalorias = new Label(
				"Por otro lado, disponemos de una calculadora para saber las calorias diarias que puede consumir");
		Label lblAyuda = new Label(
				"Para mas información, le dejamos abajo un manual y un acerca de con un enlace a nuestro github");

		lblInicio.setId("labelPrincipal");
		lblAviso.setId("labelPrincipal");
		lblCalculadoraImc.setId("labelPrincipal");
		lblCalculadoraCalorias.setId("labelPrincipal");
		lblAyuda.setId("labelPrincipal");

		this.setHalignment(lblInicio, HPos.CENTER);
		this.setHalignment(lblAviso, HPos.CENTER);
		this.setHalignment(lblCalculadoraImc, HPos.CENTER);
		this.setHalignment(lblCalculadoraCalorias, HPos.CENTER);
		this.setHalignment(lblAyuda, HPos.CENTER);

		Button btnInicio = new Button("Ir al inicio de sesion");
		Button btnListaDietas = new Button("Ver Dietas");
		Button btnCalculadoraImc = new Button("Calcular imc");
		Button btnCalculadoraCalorias = new Button("Calcular calorias");
		Button btnAcercaDe = new Button("Acerca de");

		btnInicio.setId("buttonPrincipal");
		btnListaDietas.setId("buttonPrincipal");
		btnCalculadoraImc.setId("buttonPrincipal");
		btnCalculadoraCalorias.setId("buttonPrincipal");
		btnAcercaDe.setId("buttonPrincipal");

		this.setHalignment(btnInicio, HPos.CENTER);
		this.setHalignment(btnListaDietas, HPos.CENTER);
		this.setHalignment(btnCalculadoraImc, HPos.CENTER);
		this.setHalignment(btnCalculadoraCalorias, HPos.CENTER);
		this.setHalignment(btnAcercaDe, HPos.CENTER);

		this.add(lblInicio, 0, 0);
		this.add(btnInicio, 0, 1);
		this.add(lblAviso, 0, 2);
		this.add(btnListaDietas, 0, 3);
		this.add(lblCalculadoraImc, 0, 4);
		this.add(btnCalculadoraImc, 0, 5);
		this.add(lblCalculadoraCalorias, 0, 6);
		this.add(btnCalculadoraCalorias, 0, 7);
		this.add(lblAyuda, 0, 8);
		this.add(btnAcercaDe, 0, 9);

		btnInicio.setOnAction(e -> {
			PanelInicioSesion panelInicio = new PanelInicioSesion();
		});
		btnListaDietas.setOnAction(e -> {
			PanelListaDietas registro = new PanelListaDietas();
		});
		btnCalculadoraImc.setOnAction(e -> {
			PanelCalculadoraImc calculoImc = new PanelCalculadoraImc();
		});
		btnCalculadoraCalorias.setOnAction(e -> {
			PanelCalculadoraCalorias calculoCalo = new PanelCalculadoraCalorias();
		});
		btnAcercaDe.setOnAction(e -> {
			acercaDe();
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
