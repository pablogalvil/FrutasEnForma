package frutasEnForma.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PanelPrincipal extends GridPane {

	public TextField usuario;
	public TextField contrasenia;
	public TextField confContrasenia;
	public String valor;

	public PanelPrincipal() {
		Button inicioSesion = new Button("Sign in");
		Button registro = new Button("Sign up");

		this.add(inicioSesion, 0, 0);
		this.add(registro, 1, 0);

		inicioSesion.setOnAction(event -> {
			inSesion();
		});

		registro.setOnAction(event -> {
			upSesion();
		});
	}

	public void panPrin() {
		Label lblElige = new Label("Elige una opción");

		ChoiceBox chbElige = new ChoiceBox();

		chbElige.getItems().addAll("Lista de dietas", "Elige tu fruta", "Registro de dietas", "Calculadora de calorias",
				"Nuestros productos", "Recetas", "Manual de ayuda");

		this.add(lblElige, 0, 0);
		this.add(chbElige, 1, 0);

		chbElige.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				valor = (String) chbElige.getValue();
			}
		});

		Label informacion;

		switch (valor) {
		case "Lista de dietas":
			informacion = new Label(
					"Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
			this.add(informacion, 0, 1);
			break;
		case "Elige tu fruta":
			informacion = new Label(
					"Aqui podrás ver la  de dietas disponible, así como sugerir nuevas dietas a la aplicación");
			this.add(informacion, 0, 1);
			break;
		case "Registro de dietas":
			informacion = new Label(
					"Aqui podrás ver la lista deisponible, así como sugerir nuevas dietas a la aplicación");
			this.add(informacion, 0, 1);
			break;
		case "Calculadora de calorias":
			informacion = new Label("Aqui podrás ver la lista  disponible, así como suas dietas a la aplicación");
			this.add(informacion, 0, 1);
			break;
		case "Nuestros productos":
			informacion = new Label("Aqui podrás ver la lista de dieomo sugerir nuevas dietas a la aplicación");
			this.add(informacion, 0, 1);
			break;
		case "Recetas":
			informacion = new Label("Aqui podrás ver la lisasí como sugerir nuevas dietas a la aplicación");
			this.add(informacion, 0, 1);
			break;
		case "Manual de ayuda":
			informacion = new Label("Aqui podrás vle, así como sugerir nuevas dietas a la aplicación");
			this.add(informacion, 0, 1);
			break;
		}
	}

	public void inSesion() {
		Label lblUsuario = new Label("Usuario");
		Label lblContrasenia = new Label("Contraseña");

		usuario = new TextField();
		contrasenia = new TextField();

		Button confirmar = new Button("Confirm");

		this.add(lblUsuario, 0, 0);
		this.add(usuario, 1, 0);
		this.add(lblContrasenia, 0, 1);
		this.add(contrasenia, 1, 1);
		this.add(confirmar, 0, 2);

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {
			panPrin();
		});
	}

	public void upSesion() {
		Label lblUsuario = new Label("Usuario");
		Label lblContrasenia = new Label("Contraseña");
		Label lblConfContrasenia = new Label("Confirma la contraseña");

		usuario = new TextField();
		contrasenia = new TextField();
		confContrasenia = new TextField();

		Button confirmar = new Button("Confirm");

		this.add(lblUsuario, 0, 0);
		this.add(usuario, 1, 0);
		this.add(lblContrasenia, 0, 1);
		this.add(contrasenia, 1, 1);
		this.add(lblConfContrasenia, 0, 2);
		this.add(confContrasenia, 1, 2);
		this.add(confirmar, 0, 3);

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {
			panPrin();
		});
	}

}
