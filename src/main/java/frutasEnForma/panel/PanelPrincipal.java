package frutasEnForma.panel;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

import com.jfoenix.controls.JFXButton;

import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class PanelPrincipal extends GridPane {

	public static double numEscala = App.configuracion.getScale();
	public static Scale escala = new Scale(numEscala, numEscala);
	private int zoomLevel = 100;

	/**
	 * Panel principal de la aplicacion
	 * 
	 * @param stage
	 */
	public PanelPrincipal(Stage stage) {

		// ***************************************************
		// *********************ICONOS************************
		// ***************************************************

		MenuBar iconos = new MenuBar();
		iconos.getStyleClass().add("iconos");
		this.setHalignment(iconos, HPos.CENTER);

		// Icono de logIn
		JFXButton botonLogIn = new JFXButton();
		Menu mLogIn = new Menu();
		mLogIn.setGraphic(botonLogIn);
		iconos.getMenus().add(mLogIn);

		String imgLogIn = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/inicioSesion.jpg";

		Image iconLogIn = new Image(imgLogIn);
		ImageView iconLogInView = new ImageView(iconLogIn);
		iconLogInView.setFitWidth(16);
		iconLogInView.setFitHeight(16);

		botonLogIn.setGraphic(iconLogInView);

		botonLogIn.setAlignment(Pos.CENTER);
		botonLogIn.setId("iconos");

		// Icono de logOut
		JFXButton botonLogOut = new JFXButton();
		Menu mLogOut = new Menu();
		mLogOut.setGraphic(botonLogOut);
		iconos.getMenus().add(mLogOut);

		String imgLogOut = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/logOut.jpg";

		Image iconLogOut = new Image(imgLogOut);
		ImageView iconLogOutView = new ImageView(iconLogOut);
		iconLogOutView.setFitWidth(16);
		iconLogOutView.setFitHeight(16);

		botonLogOut.setGraphic(iconLogOutView);

		botonLogOut.setAlignment(Pos.CENTER);
		botonLogOut.setId("iconos");

		// Icono de fondo
		JFXButton botonFondo = new JFXButton();
		Menu mFondo = new Menu();
		mFondo.setGraphic(botonFondo);
		iconos.getMenus().add(mFondo);

		String imgFondo = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/fondo.jpg";

		Image iconFondo = new Image(imgFondo);
		ImageView iconFondoView = new ImageView(iconFondo);
		iconFondoView.setFitWidth(16);
		iconFondoView.setFitHeight(16);

		botonFondo.setGraphic(iconFondoView);

		botonFondo.setAlignment(Pos.CENTER);

		// Icono de zoom in
		JFXButton botonZoomIn = new JFXButton();
		Menu mZoomIn = new Menu();
		mZoomIn.setGraphic(botonZoomIn);
		iconos.getMenus().add(mZoomIn);

		String imgZoomIn = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/+.jpg";

		Image iconZoomIn = new Image(imgZoomIn);
		ImageView iconZoomInView = new ImageView(iconZoomIn);
		iconZoomInView.setFitWidth(16);
		iconZoomInView.setFitHeight(16);

		botonZoomIn.setGraphic(iconZoomInView);

		botonZoomIn.setAlignment(Pos.CENTER);

		// Icono de zoom out
		JFXButton botonZoomOut = new JFXButton();
		Menu mZoomOut = new Menu();
		mZoomOut.setGraphic(botonZoomOut);
		iconos.getMenus().add(mZoomOut);

		String imgZoomOut = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/-.jpg";

		Image iconZoomOut = new Image(imgZoomOut);
		ImageView iconZoomOutView = new ImageView(iconZoomOut);
		iconZoomOutView.setFitWidth(16);
		iconZoomOutView.setFitHeight(16);

		botonZoomOut.setGraphic(iconZoomOutView);

		botonZoomOut.setAlignment(Pos.CENTER);

		// Icono de cambiar datos user
		JFXButton botonEditUser = new JFXButton();
		Menu mEditUser = new Menu();
		mEditUser.setGraphic(botonEditUser);
		iconos.getMenus().add(mEditUser);

		String imgEditUser = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/EDITAR.jpg";

		Image iconEditUser = new Image(imgEditUser);
		ImageView iconEditUserView = new ImageView(iconEditUser);
		iconEditUserView.setFitWidth(16);
		iconEditUserView.setFitHeight(16);

		botonEditUser.setGraphic(iconEditUserView);

		botonEditUser.setAlignment(Pos.CENTER);
		botonEditUser.setId("iconos");

		// Icono de manual
		JFXButton botonManual = new JFXButton();
		Menu mManual = new Menu();
		mManual.setGraphic(botonManual);
		iconos.getMenus().add(mManual);

		String imgManual = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/AJUSTES.jpg";

		Image iconManual = new Image(imgManual);
		ImageView iconManualView = new ImageView(iconManual);
		iconManualView.setFitWidth(16);
		iconManualView.setFitHeight(16);

		botonManual.setGraphic(iconManualView);

		botonManual.setAlignment(Pos.CENTER);
		botonManual.setId("iconos");

		// Icono de exit
		JFXButton botonExit = new JFXButton();
		Menu mExit = new Menu();
		mExit.setGraphic(botonExit);
		iconos.getMenus().add(mExit);

		String imgExit = "file:///C:/Programación/FrutasEnForma/src/main/resources/img/EXIT.jpg";

		Image iconExit = new Image(imgExit);
		ImageView iconExitView = new ImageView(iconExit);
		iconExitView.setFitWidth(16);
		iconExitView.setFitHeight(16);

		botonExit.setGraphic(iconExitView);

		botonExit.setAlignment(Pos.CENTER);
		botonExit.setId("iconos");

		// ***************************************************
		// **********************MENU*************************
		// ***************************************************

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
		MenuItem iRegistrarComidas = new MenuItem("Registrar comidas");
		MenuItem iMostrarRecetas = new MenuItem("Mostrar recetas");
		MenuItem iRegistrarRecetas = new MenuItem("Registrar recetas");
		MenuItem iBorrarRecetas = new MenuItem("Borrar recetas");

		mRecetas.getItems().addAll(iRegistrarComidas, iMostrarRecetas, iRegistrarRecetas, iBorrarRecetas);

		Menu mAyuda = new Menu("Ayuda");
		MenuItem iManual = new MenuItem("Manual");
		MenuItem iAcercaDe = new MenuItem("Acerca de");

		mAyuda.getItems().addAll(iManual, iAcercaDe);

		menu.getMenus().addAll(mUser, mListaDietas, mRegistroDietas, mRecetas, mAyuda);

		// ***************************************************
		// ****************VARIABLES MIEMBRO******************
		// ***************************************************

		Label lblInicio = new Label("Bienvenido, por favor inicie sesion antes de continuar utilizando la aplicacion.");
		Label lblAviso = new Label(
				"Tenga en cuenta que al no iniciar sesion no podra usar algunas partes\nde la aplicacion.");
		Label lblCalculadoraImc = new Label(
				"En nuestra aplicacion disponemos de una calculadora para saber cual es\nsu índice de masa corporal (IMC)");
		Label lblCalculadoraCalorias = new Label(
				"Por otro lado, disponemos de una calculadora para saber las calorias\ndiarias que puede consumir");
		Label lblMostrarRecetas = new Label("En esta parte mostraremos las recetas que tenemos.");

		this.setHalignment(lblInicio, HPos.CENTER);
		this.setHalignment(lblAviso, HPos.CENTER);
		this.setHalignment(lblCalculadoraImc, HPos.CENTER);
		this.setHalignment(lblCalculadoraCalorias, HPos.CENTER);
		this.setHalignment(lblMostrarRecetas, HPos.CENTER);

		Button btnListaDietas = new Button("Ver Dietas");
		Button btnRegistroDietas = new Button("Ver Registros");
		Button btnCalculadoraImc = new Button("Calcular imc");
		Button btnCalculadoraCalorias = new Button("Calcular calorias");
		Button btnMostrarRecetas = new Button("Mostrar recetas");

		this.setHalignment(btnListaDietas, HPos.CENTER);
		this.setHalignment(btnCalculadoraImc, HPos.CENTER);
		this.setHalignment(btnCalculadoraCalorias, HPos.CENTER);
		this.setHalignment(btnMostrarRecetas, HPos.CENTER);

		this.add(menu, 0, 0);
		this.add(iconos, 0, 1);
		this.add(lblInicio, 0, 2);
		this.add(lblAviso, 0, 3);
		this.add(btnListaDietas, 0, 4);
		this.add(lblCalculadoraImc, 0, 5);
		this.add(btnCalculadoraImc, 0, 6);
		this.add(lblCalculadoraCalorias, 0, 7);
		this.add(btnCalculadoraCalorias, 0, 8);
		this.add(lblMostrarRecetas, 0, 9);
		this.add(btnMostrarRecetas, 0, 10);

		this.setMargin(botonLogOut, new Insets(5, 10, 5, 10));
		this.setMargin(botonFondo, new Insets(5, 10, 5, 10));

		// ***************************************************
		// *******************MENU ITEMS**********************
		// ***************************************************

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
			PanelListaDietas mostrarListas = new PanelListaDietas();
		});
		iListaDietasAniadir.setOnAction(e -> {
			PanelAniadirLista aniadirListas = new PanelAniadirLista();
		});
		iListaDietasBorrar.setOnAction(e -> {
			PanelBorrarDietas borrarDietas = new PanelBorrarDietas();
		});

		// MenuItems de registro dietas
		iRegistroDietasAniadir.setOnAction(e -> {
			PanelRegistroDietas aniadirRegistro = new PanelRegistroDietas();
		});
		iRegistroDietasVer.setOnAction(e -> {
			PanelRegistroVer verRegistro = new PanelRegistroVer();
		});

		// MenuItems de recetas
		iRegistrarComidas.setOnAction(e -> {
			PanelInsertarComidas registrarComida = new PanelInsertarComidas();
		});
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

		// ***************************************************
		// *********************ICONOS************************
		// ***************************************************

		botonLogIn.setOnAction(e -> {
			PanelInicioSesion panelInicio = new PanelInicioSesion();
		});
		botonLogOut.setOnAction(e -> {
			UsuarioDAO.idUsuario = 0;
		});
		botonFondo.setOnAction(e -> {
			if (App.configuracion.getTheme() == 0) {
				App.configuracion.setTheme(1);
				App.scene.getStylesheets().remove(getClass().getResource("/css/css.css").toExternalForm());
				App.scene.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
			} else if (App.configuracion.getTheme() == 1) {
				App.configuracion.setTheme(0);
				App.scene.getStylesheets().remove(getClass().getResource("/css/darkcss.css").toExternalForm());
				App.scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());
			}
		});
		botonZoomIn.setOnAction(e -> {
			try {
				// Si la escala supera el 1.2 saltara una alerta y si no se ejecutara la funcion
				// que hace el zoom.
				if (numEscala < 1.2) {
					numEscala *= 1.1;

					applyScale(stage);
				} else {
					alertaZoomIn();
				}
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		});
		botonZoomOut.setOnAction(e -> {

			try {
				// Si la escala es menor del 0.5 saltara una alerta y si no se ejecutara la
				// funcion que hace el zoom.
				if (numEscala > 0.5) {
					numEscala /= 1.1;

					applyScale(stage);
				} else {
					alertaZoomOut();
				}

			} catch (Exception exp) {
				exp.printStackTrace();
			}
		});
		botonEditUser.setOnAction(e -> {
			PanelEditUser editarUsuario = new PanelEditUser();
		});
		botonManual.setOnAction(e -> {
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
		botonExit.setOnAction(e -> {
			stage.close();
		});

		// ***************************************************
		// *********************Botones***********************
		// ***************************************************

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
	}

	/**
	 * Panel de la opcion de ayuda acerca de
	 */
	public void acercaDe() {
		AlertType tipoAlerta = Alert.AlertType.INFORMATION;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Acerca de");
		infoAlert.setHeaderText("©FrutasEnForma");

		Hyperlink github = new Hyperlink("https://github.com/pablogalvil/FrutasEnForma");

		github.setOnAction(e -> {
			try {
				// Abrimos el github en el buscador
				Desktop.getDesktop().browse(new URI("https://github.com/pablogalvil/FrutasEnForma"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		infoAlert.getDialogPane().setContent(github);
		infoAlert.showAndWait();
	}

	/**
	 * Funcion para cambiar el zoom
	 * 
	 * @param stage
	 */
	public void applyScale(Stage stage) {
		// Creditos a Sergio Pinto, que me ha explicado como se hace esta funcion.

		// Sacamos la longitud de la escena
		double sceneWidth = stage.getScene().getWidth();
		double sceneHeight = stage.getScene().getHeight();

		// Sacamos las coordenadas del centro
		double sceneCenterX = sceneWidth / 2;
		double sceneCenterY = sceneHeight / 2;

		// Modifico la escala en funcion de la variable que guarda el valor de esta
		escala.setX(numEscala);
		escala.setY(numEscala);

		// Calculamos la posicion del centro después de cambiar la escala.
		double newCenterX = sceneCenterX * numEscala;
		double newCenterY = sceneCenterY * numEscala;

		// Calculamos cuanto ha cambiado el centro
		double deltaX = sceneCenterX - newCenterX;
		double deltaY = sceneCenterY - newCenterY;

		// Usamos el cambio del centro de la imagen para ajustar la escala en toda la
		// pagina.
		stage.getScene().getRoot().getTransforms().clear();
		stage.getScene().getRoot().getTransforms().add(escala);
		stage.getScene().getRoot().setTranslateX(deltaX);
		stage.getScene().getRoot().setTranslateY(deltaY);
	}

	/**
	 * Alerta que salta si haces mas zoom del que permitimos.
	 */
	public void alertaZoomIn() {
		AlertType tipoAlerta = Alert.AlertType.INFORMATION;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No puedes aumentar más.");
		infoAlert.setContentText("Lo sentimos, nuestra aplicacion no permite más zoom.");
		infoAlert.showAndWait();
	}

	/**
	 * Alerta que salta si haces mas zoom out del que permitimos.
	 */
	public void alertaZoomOut() {
		AlertType tipoAlerta = Alert.AlertType.INFORMATION;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No puedes disminuir más.");
		infoAlert.setContentText("Lo sentimos, nuestra aplicacion no permite menos zoom.");
		infoAlert.showAndWait();
	}
}