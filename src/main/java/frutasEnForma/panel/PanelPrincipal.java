package frutasEnForma.panel;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

import frutasEnForma.App;
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
		this.setHalignment(menu, HPos.CENTER);

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

		Menu mRecetas = new Menu("Recetas");
		MenuItem iMostrarRecetas = new MenuItem("Mostrar recetas");
		MenuItem iRegistrarRecetas = new MenuItem("Registrar recetas");
		MenuItem iBorrarRecetas = new MenuItem("Borrar recetas");

		mRecetas.getItems().addAll(iMostrarRecetas, iRegistrarRecetas, iBorrarRecetas);

		Menu mAyuda = new Menu("Ayuda");
		MenuItem iManual = new MenuItem("Manual");
		MenuItem iAcercaDe = new MenuItem("Acerca de");

		mAyuda.getItems().addAll(iManual, iAcercaDe);

		menu.getMenus().addAll(mUser, mListaDietas, mRegistroDietas, mRecetas, mAyuda);

		Label lblInicio = new Label("Bienvenido, por favor inicie sesion antes de continuar utilizando la aplicacion.");
		Label lblAviso = new Label(
				"Tenga en cuenta que al no iniciar sesion no podra usar algunas partes de la aplicacion.");
		Label lblCalculadoraImc = new Label(
				"En nuestra aplicacion disponemos de una calculadora para saber cual es su índice de masa corporal (IMC)");
		Label lblCalculadoraCalorias = new Label(
				"Por otro lado, disponemos de una calculadora para saber las calorias diarias que puede consumir");
		Label lblMostrarRecetas = new Label("En esta parte mostraremos las recetas que tenemos.");
		Label lblRegistrarRecetas = new Label("Y en este panel podras registrar recetas.");
		Label lblBorrarRecetas = new Label("Tambien podras borrar las recetas que insertes.");
		Label lblAyuda = new Label(
				"Para mas información, le dejamos abajo un manual y un acerca de con un enlace a nuestro github");

		lblInicio.setId("labelPrincipal");
		lblAviso.setId("labelPrincipal");
		lblCalculadoraImc.setId("labelPrincipal");
		lblCalculadoraCalorias.setId("labelPrincipal");
		lblMostrarRecetas.setId("labelPrincipal");
		lblRegistrarRecetas.setId("labelPrincipal");
		lblBorrarRecetas.setId("labelPrincipal");
		lblAyuda.setId("labelPrincipal");

		this.setHalignment(lblInicio, HPos.CENTER);
		this.setHalignment(lblAviso, HPos.CENTER);
		this.setHalignment(lblCalculadoraImc, HPos.CENTER);
		this.setHalignment(lblCalculadoraCalorias, HPos.CENTER);
		this.setHalignment(lblMostrarRecetas, HPos.CENTER);
		this.setHalignment(lblRegistrarRecetas, HPos.CENTER);
		this.setHalignment(lblBorrarRecetas, HPos.CENTER);
		this.setHalignment(lblAyuda, HPos.CENTER);

		Button btnInicio = new Button("Ir al inicio de sesion");
		Button btnListaDietas = new Button("Ver Dietas");
		Button btnRegistroDietas = new Button("Ver Registros");
		Button btnCalculadoraImc = new Button("Calcular imc");
		Button btnCalculadoraCalorias = new Button("Calcular calorias");
		Button btnMostrarRecetas = new Button("Mostrar recetas");
		Button btnRegistrarRecetas = new Button("Registrar recetas");
		Button btnBorrarRecetas = new Button("Borrar recetas");
		Button btnManual = new Button("Manual");
		Button btnAcercaDe = new Button("Acerca de");

		btnInicio.setId("buttonPrincipal");
		btnListaDietas.setId("buttonPrincipal");
		btnCalculadoraImc.setId("buttonPrincipal");
		btnCalculadoraCalorias.setId("buttonPrincipal");
		btnMostrarRecetas.setId("buttonPrincipal");
		btnRegistrarRecetas.setId("buttonPrincipal");
		btnBorrarRecetas.setId("buttonPrincipal");
		btnManual.setId("buttonPrincipal");
		btnAcercaDe.setId("buttonPrincipal");

		this.setHalignment(btnInicio, HPos.CENTER);
		this.setHalignment(btnListaDietas, HPos.CENTER);
		this.setHalignment(btnCalculadoraImc, HPos.CENTER);
		this.setHalignment(btnCalculadoraCalorias, HPos.CENTER);
		this.setHalignment(btnMostrarRecetas, HPos.CENTER);
		this.setHalignment(btnRegistrarRecetas, HPos.CENTER);
		this.setHalignment(btnBorrarRecetas, HPos.CENTER);
		this.setHalignment(btnManual, HPos.CENTER);
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
		this.add(lblMostrarRecetas, 0, 9);
		this.add(btnMostrarRecetas, 0, 10);
		this.add(lblRegistrarRecetas, 0, 11);
		this.add(btnRegistrarRecetas, 0, 12);
		this.add(lblBorrarRecetas, 0, 13);
		this.add(btnBorrarRecetas, 0, 14);
		this.add(lblAyuda, 0, 15);
		this.add(btnManual, 0, 16);
		this.add(btnAcercaDe, 0, 17);

		// MenuItem inicio de sesion
		iInicioSesion.setOnAction(e -> {
			PanelInicioSesion panelInicio = new PanelInicioSesion();
		});

		// MenuItems de calculadora
		iCalculadoraImc.setOnAction(e -> {
			if (App.configuracion.getTheme() == 0) {
				App.configuracion.setTheme(1);
				App.scene.getStylesheets().remove(getClass().getResource("/css/css.css").toExternalForm());
				App.scene.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
			} else if (App.configuracion.getTheme() == 1) {
				App.configuracion.setTheme(0);
				App.scene.getStylesheets().remove(getClass().getResource("/css/darkcss.css").toExternalForm());
				App.scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
			}
			PanelCalculadoraImc calculoImc = new PanelCalculadoraImc();
		});
		iCalculadoraCalorias.setOnAction(e -> {
			PanelCalculadoraCalorias calculoCalorias = new PanelCalculadoraCalorias();
		});

		// MenuItems de lista dietas
		iListaDietasVer.setOnAction(e -> {
			PanelListaDietas Listas = new PanelListaDietas();
		});
		iListaDietasAniadir.setOnAction(e -> {
			PanelListaDietas Listas = new PanelListaDietas();
		});

		// MenuItems de registro dietas
		iRegistroDietasAniadir.setOnAction(e -> {
			PanelRegistroDietas registro = new PanelRegistroDietas();
		});

		// MenuItems de recetas
		iMostrarRecetas.setOnAction(e -> {
			PanelDocumentosReceta mostrarReceta = new PanelDocumentosReceta();
		});
		iRegistrarRecetas.setOnAction(e -> {
			PanelRecetasRegistrar registrarReceta = new PanelRecetasRegistrar();
		});
		iBorrarRecetas.setOnAction(e -> {
			PanelRecetasBorrar borrarReceta = new PanelRecetasBorrar();
		});

		// MenuItems de ayuda
		iManual.setOnAction(e -> {
			try {
				// Buscamos el documento html y lo añadimos a un File
				File html = new File("C:\\Programación\\FrutasEnForma\\doc\\index.html");
				// Pasamos la file a url
				URI uri = html.toURI();
				// Abrimos el html en el buscador
				Desktop.getDesktop().browse(uri);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
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
		btnListaDietas.setOnAction(e -> {
			PanelListaDietas Listas = new PanelListaDietas();
		});

		// Botones de registro de dietas
		btnRegistroDietas.setOnAction(e -> {
			PanelRegistroDietas registro = new PanelRegistroDietas();
		});

		// Botones de calculadora
		btnCalculadoraImc.setOnAction(e -> {
			PanelCalculadoraImc calculoImc = new PanelCalculadoraImc();
		});
		btnCalculadoraCalorias.setOnAction(e -> {
			PanelCalculadoraCalorias panelCalorias = new PanelCalculadoraCalorias();
		});

		// Botones de recetas
		btnMostrarRecetas.setOnAction(e -> {
			PanelDocumentosReceta mostrarReceta = new PanelDocumentosReceta();
		});
		btnRegistrarRecetas.setOnAction(e -> {
			PanelRecetasRegistrar registrarReceta = new PanelRecetasRegistrar();
		});
		btnBorrarRecetas.setOnAction(e -> {
			PanelRecetasBorrar borrarReceta = new PanelRecetasBorrar();
		});

		// Botones de ayuda
		btnManual.setOnAction(e -> {
			try {
				File html = new File("C:\\Programación\\FrutasEnForma\\doc\\index.html");
				// Abrir la URL en Google Chrome
				URI uri = html.toURI();
				Desktop.getDesktop().browse(uri);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
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
