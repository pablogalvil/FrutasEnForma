package frutasEnForma.panel;

import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

public class PanelPrincipal extends GridPane {

	public PanelPrincipal() {

		MenuBar menu = new MenuBar();
		menu.getStyleClass().add("menubar");

		Menu mUser = new Menu("Cuenta");
		MenuItem iInicioSesion = new MenuItem("Iniciar sesion");

		Menu mCalculadora = new Menu("Calculadora");
		MenuItem iCalculadoraImc = new MenuItem("Calcular Imc");
		MenuItem iCalculadoraCalorias = new MenuItem("Calcular Calorias");

		mCalculadora.getItems().addAll(iCalculadoraImc, iCalculadoraCalorias);

		mUser.getItems().addAll(iInicioSesion, mCalculadora);

		Menu mListaDietas = new Menu("Lista de Dietas");
		MenuItem iListaDietasVer = new MenuItem("Ver Listas de Dietas");

		Menu mOpcionesLista = new Menu("Opciones");
		MenuItem iListaDietasAniadir = new MenuItem("Añadir Listas de Dietas");
		MenuItem iListaDietasBorrar = new MenuItem("Borrar Listas de Dietas");

		mOpcionesLista.getItems().addAll(iListaDietasAniadir, iListaDietasBorrar);

		mListaDietas.getItems().addAll(iListaDietasVer, mOpcionesLista);

		Menu mRegistroDietas = new Menu("Registro");
		MenuItem iRegistroDietasVer = new MenuItem("Ver Registro");
		MenuItem iRegistroDietasAniadir = new MenuItem("Añadir Registro");

		mRegistroDietas.getItems().addAll(iRegistroDietasVer, iRegistroDietasAniadir);

		Menu mAyuda = new Menu("Ayuda");
		MenuItem iManual = new MenuItem("Manual");
		MenuItem iAcercaDe = new MenuItem("Acerca de");

		mAyuda.getItems().addAll(iManual, iAcercaDe);

		menu.getMenus().addAll(mUser, mListaDietas, mRegistroDietas, mAyuda);

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
		Button btnRegistroDietas = new Button("Ver Registros");
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

		this.add(menu, 0, 0);
		this.add(lblInicio, 0, 1);
		this.add(btnInicio, 0, 2);
		this.add(lblAviso, 0, 3);
		this.add(btnListaDietas, 0, 4);
		this.add(lblCalculadoraImc, 0, 5);
		this.add(btnCalculadoraImc, 0, 6);
		this.add(lblCalculadoraCalorias, 0, 7);
		this.add(btnCalculadoraCalorias, 0, 8);
		this.add(lblAyuda, 0, 9);
		this.add(btnAcercaDe, 0, 10);

		// MenuItem inicio de sesion
		iInicioSesion.setOnAction(e -> {
			PanelInicioSesion panelInicio = new PanelInicioSesion();
		});

		// MenuItems de calculadora
		iCalculadoraImc.setOnAction(e -> {
			PanelCalculadoraImc calculoImc = new PanelCalculadoraImc();
		});
		iCalculadoraCalorias.setOnAction(e -> {
			PanelCalculadoraCalorias calculoCalorias = new PanelCalculadoraCalorias();
		});

		// MenuItems de lista dietas
		iListaDietasVer.setOnAction(e -> {
			PanelListaDietas Listas = new PanelListaDietas();
		});

		// MenuItems de registro dietas
		iRegistroDietasAniadir.setOnAction(e -> {
			PanelRegistroDietas registro = new PanelRegistroDietas();
		});

		// MenuItems de ayuda
		iAcercaDe.setOnAction(e -> {
			acercaDe();
		});

		/*
		 * BOTONES
		 */

		// Boton de inicio de sesion
		btnInicio.setOnAction(e -> {
			PanelInicioSesion panelInicio = new PanelInicioSesion();
		});

		// Botones de lista de dietas
		/*
		 * btnListaDietas.setOnAction(e -> { PanelListaDietas Listas = new
		 * PanelListaDietas(); });
		 */

		// Botones de registro de dietas
		btnListaDietas.setOnAction(e -> {
			// PanelRegistroDietas registro = new PanelRegistroDietas();
			PanelDocumentosReceta pdr = new PanelDocumentosReceta();
		});

		// Botones de calculadora
		btnCalculadoraImc.setOnAction(e -> {
			PanelCalculadoraImc calculoImc = new PanelCalculadoraImc();
		});
		btnCalculadoraCalorias.setOnAction(e -> {
			PanelCalculadoraCalorias panelCalorias = new PanelCalculadoraCalorias();
		});

		// Botones de ayuda
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
