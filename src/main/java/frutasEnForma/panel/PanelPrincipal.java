package frutasEnForma.panel;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PanelPrincipal extends GridPane {

	private TextField usuario;
	private TextField contrasenia;
	private TextField peso;
	private TextField altura;
	private TextField edad;
	private TextField sexo;
	private String valor;

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
		Label lblPeso = new Label("Peso");
		Label lblAltura = new Label("Altura");
		Label lblEdad = new Label("Edad");
		Label lblSexo = new Label("Sexo (H/M)");

		usuario = new TextField();
		contrasenia = new TextField();
		peso = new TextField();
		altura = new TextField();
		edad = new TextField();
		sexo = new TextField();

		// int edadUsuario = Integer.valueOf(edad.getText());

		Button confirmar = new Button("Confirm");

		this.add(lblUsuario, 0, 0);
		this.add(usuario, 1, 0);
		this.add(lblContrasenia, 0, 1);
		this.add(contrasenia, 1, 1);
		this.add(lblPeso, 0, 2);
		this.add(peso, 1, 2);
		this.add(lblAltura, 0, 3);
		this.add(altura, 1, 3);
		this.add(lblEdad, 0, 4);
		this.add(edad, 1, 4);
		this.add(lblSexo, 0, 5);
		this.add(sexo, 1, 5);
		this.add(confirmar, 0, 6);

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {
			lblUsuario.setVisible(false);
			usuario.setVisible(false);
			lblContrasenia.setVisible(false);
			contrasenia.setVisible(false);
			lblPeso.setVisible(false);
			peso.setVisible(false);
			lblAltura.setVisible(false);
			altura.setVisible(false);
			lblEdad.setVisible(false);
			edad.setVisible(false);
			lblSexo.setVisible(false);
			sexo.setVisible(false);
			confirmar.setVisible(false);

			panPrin();
		});
	}

	public void panPrin() {
		Label lblInicio = new Label("Bienvenido");

		this.add(lblInicio, 0, 0);
	}

}
