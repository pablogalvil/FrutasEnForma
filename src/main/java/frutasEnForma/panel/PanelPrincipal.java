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
	public String valor;

	public PanelPrincipal() {
		Button inicioSesion = new Button("Sign in");
		Button registro = new Button("Sign up");

		this.add(inicioSesion, 0, 0);
		this.add(registro, 1, 0);

		inicioSesion.setOnAction(event -> {
			inicioSesion.setVisible(false);
			registro.setVisible(false);
			inSesion();
		});

		registro.setOnAction(event -> {
			inicioSesion.setVisible(false);
			registro.setVisible(false);
			upSesion();
		});
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
			lblUsuario.setVisible(false);
			usuario.setVisible(false);
			lblContrasenia.setVisible(false);
			contrasenia.setVisible(false);
			confirmar.setVisible(false);
			panPrin();
		});
	}

	public void upSesion() {
		Label lblUsuario = new Label("Usuario");
		Label lblContrasenia = new Label("Contraseña");

		usuario = new TextField();
		contrasenia = new TextField();

		Button confirmar = new Button("Confirm");

		this.add(lblUsuario, 0, 0);
		this.add(usuario, 1, 0);
		this.add(lblContrasenia, 0, 1);
		this.add(contrasenia, 1, 1);
		this.add(confirmar, 0, 3);

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {
			lblUsuario.setVisible(false);
			usuario.setVisible(false);
			lblContrasenia.setVisible(false);
			contrasenia.setVisible(false);
			confirmar.setVisible(false);
			panPrin();
		});
	}
	
	public void panPrin() {
		Label lblElige = new Label("Elige una opción");
		Button ir = new Button("Ir a la página");

		ChoiceBox<String> chbElige = new ChoiceBox<String>();

		chbElige.getItems().addAll("Lista de dietas", "Elige tu fruta", "Registro de dietas", "Calculadora de calorias",
				"Nuestros productos", "Recetas", "Manual de ayuda");

		this.add(lblElige, 0, 0);
		this.add(chbElige, 1, 0);

		Label informacion = new Label("");
		
		chbElige.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				valor = (String) chbElige.getValue();
				switch (valor) {
				case "Lista de dietas":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
					break;
				case "Elige tu fruta":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
					break;
				case "Registro de dietas":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
					break;
				case "Calculadora de calorias":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
					break;
				case "Nuestros productos":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
					break;
				case "Recetas":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
					break;
				case "Manual de ayuda":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación");
					break;
				}
			}
		});
		this.add(informacion, 0, 1);
		this.add(ir, 0, 2);
	}

}
