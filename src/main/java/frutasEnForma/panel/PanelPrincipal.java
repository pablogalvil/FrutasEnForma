package frutasEnForma.panel;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelPrincipal extends GridPane {

	public TextField usuario;
	public TextField contrasenia;
	public TextField confContrasenia;

	public PanelPrincipal() {
		Label lblElige = new Label("Elige una opción");

		ChoiceBox chbElige = new ChoiceBox();

		chbElige.getItems().addAll("Lista de dietas", "Elige tu fruta", "Registro de dietas", "Calculadora de calorias",
				"Nuestros productos", "Recetas", "Manual de ayuda");

		Label informacion = new Label("");
	}

	public void sesion() {

		VBox panelVertical = new VBox();

		Button inicioSesion = new Button("Sign in");
		Button registro = new Button("Sign up");

		inicioSesion.setOnAction(event -> {
			inSesion();
		});

		registro.setOnAction(event -> {
			upSesion();
		});

	}

	public void inSesion() {
		Stage ventanaEmergente = new Stage();

		VBox panelVentana = new VBox();

		Scene scene = new Scene(panelVentana, 600, 600);

		Label lblUsuario = new Label("Usuario");
		Label lblContrasenia = new Label("Contraseña");

		usuario = new TextField();
		contrasenia = new TextField();

		Button confirmar = new Button("Confirm");

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {

		});

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Sign in");
		ventanaEmergente.show();
	}

	public void upSesion() {
		Stage ventanaEmergente = new Stage();

		VBox panelVentana = new VBox();

		Scene scene = new Scene(panelVentana, 600, 600);

		Label lblUsuario = new Label("Usuario");
		Label lblContrasenia = new Label("Contraseña");
		Label lblConfContrasenia = new Label("Confirma la contraseña");

		usuario = new TextField();
		contrasenia = new TextField();
		confContrasenia = new TextField();

		Button confirmar = new Button("Confirm");

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {

		});

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Sign up");
		ventanaEmergente.show();
	}

}
