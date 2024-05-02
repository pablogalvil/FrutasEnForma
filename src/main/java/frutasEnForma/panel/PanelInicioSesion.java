package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelInicioSesion extends GridPane {

	private TextField usuario;
	private TextField contrasenia;
	private PasswordField contraseniaEscondida;
	private TextField peso;
	private TextField altura;
	private TextField edad;
	private TextField sexo;

	public PanelInicioSesion() {
		Stage sesionStage = new Stage();

		GridPane panelSesion = new GridPane();

		Button inicioSesion = new Button("Sign in");
		Button registro = new Button("Sign up");

		panelSesion.add(inicioSesion, 0, 0);
		panelSesion.add(registro, 1, 0);

		Scene scene = new Scene(panelSesion, 600, 600);

		sesionStage.setScene(scene);
		sesionStage.setTitle("Inicio de sesion");
		sesionStage.show();

		inicioSesion.setOnAction(event -> {
			sesionStage.close();
			inSesion();
		});

		registro.setOnAction(event -> {
			sesionStage.close();
			upSesion();
		});
	}

	public void inSesion() {

		Stage inicioStage = new Stage();

		GridPane panelInicio = new GridPane();

		Label lblUsuario = new Label("Usuario");
		Label lblContrasenia = new Label("Contraseña");

		usuario = new TextField();
		contrasenia = new TextField();
		contraseniaEscondida = new PasswordField();

		CheckBox checkMostrar = new CheckBox("Mostrar contraseña");
		Button btnConfirmar = new Button("Confirm");

		checkMostrar.setOnAction(e -> {
			boolean mostrar = checkMostrar.isSelected();
			contraseniaEscondida.setVisible(!mostrar);
			contrasenia.setVisible(mostrar);
			if (!mostrar) {
				contraseniaEscondida.setText(contrasenia.getText());
			} else {
				contrasenia.setText(contraseniaEscondida.getText());
			}
		});

		panelInicio.add(lblUsuario, 0, 0);
		panelInicio.add(usuario, 1, 0);
		panelInicio.add(lblContrasenia, 0, 1);
		panelInicio.add(contrasenia, 1, 1);
		panelInicio.add(contraseniaEscondida, 1, 1);
		panelInicio.add(checkMostrar, 2, 1);
		panelInicio.add(btnConfirmar, 0, 2);

		Scene scene = new Scene(panelInicio, 600, 600);

		inicioStage.setScene(scene);
		inicioStage.setTitle("Inicio de sesion");
		inicioStage.show();

		// Añadimos un evento al boton del formulario
		btnConfirmar.setOnAction(e -> {
			String txtUsuario = usuario.getText();
			String txtContrasenia = contrasenia.getText();
			if (UsuarioDAO.login(txtUsuario, txtContrasenia, App.con))
				inicioStage.close();
			else {
				PanelInicioSesion panelInicioAgain = new PanelInicioSesion();
				inicioStage.close();
			}
		});
	}

	public void upSesion() {

		Stage registroStage = new Stage();

		GridPane panelRegistro = new GridPane();

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

		panelRegistro.add(lblUsuario, 0, 0);
		panelRegistro.add(usuario, 1, 0);
		panelRegistro.add(lblContrasenia, 0, 1);
		panelRegistro.add(contrasenia, 1, 1);
		panelRegistro.add(lblPeso, 0, 2);
		panelRegistro.add(peso, 1, 2);
		panelRegistro.add(lblAltura, 0, 3);
		panelRegistro.add(altura, 1, 3);
		panelRegistro.add(lblEdad, 0, 4);
		panelRegistro.add(edad, 1, 4);
		panelRegistro.add(lblSexo, 0, 5);
		panelRegistro.add(sexo, 1, 5);
		panelRegistro.add(confirmar, 0, 6);

		Scene scene = new Scene(panelRegistro, 600, 600);

		registroStage.setScene(scene);
		registroStage.setTitle("Registro");
		registroStage.show();

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {
			registroStage.close();
			inSesion();
		});
	}
}
