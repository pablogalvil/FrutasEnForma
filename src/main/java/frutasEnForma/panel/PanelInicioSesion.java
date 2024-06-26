package frutasEnForma.panel;

import java.sql.Connection;

import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import frutasEnForma.model.UsuarioDO;
import frutasEnForma.utils.UtilsFEF;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

	/**
	 * Panel que te da a elegir entre registrarte o iniciar sesion
	 */
	public PanelInicioSesion() {
		Stage sesionStage = new Stage();

		GridPane panelSesion = new GridPane();

		Button inicioSesion = new Button("Sign in");
		Button registro = new Button("Sign up");

		panelSesion.add(inicioSesion, 0, 0);
		panelSesion.add(registro, 0, 1);

		Scene sceneSesion = new Scene(panelSesion, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneSesion.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneSesion.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneSesion.getRoot().getStyleClass().add("body");

		panelSesion.setAlignment(Pos.CENTER);

		panelSesion.setHalignment(inicioSesion, HPos.CENTER);
		panelSesion.setHalignment(registro, HPos.CENTER);

		sesionStage.setResizable(false);
		sesionStage.setScene(sceneSesion);
		sesionStage.setTitle("Inicio de sesion");
		sesionStage.show();

		inicioSesion.setOnAction(e -> {
			sesionStage.close();
			inSesion();
		});

		registro.setOnAction(e -> {
			sesionStage.close();
			upSesion();
		});
	}

	/**
	 * Panel de inicio de sesion
	 */
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

		// SetOnAction que utiliza un boolean y en caso de que seleccionen el checkbox
		// mostrar, cambie el tipo de textField de PasswordField(oculto) a
		// TextField(visible) y viceversa.
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
		panelInicio.add(usuario, 0, 1);
		panelInicio.add(lblContrasenia, 0, 2);
		panelInicio.add(contrasenia, 0, 3);
		panelInicio.add(contraseniaEscondida, 0, 3);
		panelInicio.add(checkMostrar, 0, 4);
		panelInicio.add(btnConfirmar, 0, 5);

		Scene sceneInicio = new Scene(panelInicio, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneInicio.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneInicio.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneInicio.getRoot().getStyleClass().add("body");

		panelInicio.setMargin(checkMostrar, new Insets(5, 10, 5, 10));

		panelInicio.setAlignment(Pos.CENTER);

		panelInicio.setHalignment(lblUsuario, HPos.CENTER);
		panelInicio.setHalignment(usuario, HPos.CENTER);
		panelInicio.setHalignment(lblContrasenia, HPos.CENTER);
		panelInicio.setHalignment(contrasenia, HPos.CENTER);
		panelInicio.setHalignment(contraseniaEscondida, HPos.CENTER);
		panelInicio.setHalignment(btnConfirmar, HPos.CENTER);

		inicioStage.setResizable(false);
		inicioStage.setScene(sceneInicio);
		inicioStage.setTitle("Inicio de sesion");
		inicioStage.show();

		btnConfirmar.setOnAction(e -> {
			String txtUsuario = usuario.getText();
			String txtContrasenia = contraseniaEscondida.getText();
			// Si la funcion de login da true, se cierra, si da false salta la alerta y te
			// devuelve al inicio del inicio de sesion.
			if (UsuarioDAO.login(txtUsuario, txtContrasenia, App.con))
				inicioStage.close();
			else {
				alertaInicio();
				PanelInicioSesion panelInicioAgain = new PanelInicioSesion();
				inicioStage.close();
			}
		});
	}

	/**
	 * Panel que registra al usuario en la base de datos
	 */
	public void upSesion() {
		Connection con = UtilsFEF.conectarBD();

		Stage registroStage = new Stage();

		GridPane panelRegistro = new GridPane();

		panelRegistro.setAlignment(Pos.CENTER);

		Label lblUsuario = new Label("Usuario");
		Label lblContrasenia = new Label("Contraseña");
		Label lblPeso = new Label("Peso");
		Label lblAltura = new Label("Altura");
		Label lblEdad = new Label("Edad");
		Label lblSexo = new Label("Sexo (H/M)");

		this.setHalignment(lblUsuario, HPos.CENTER);
		this.setHalignment(lblContrasenia, HPos.CENTER);
		this.setHalignment(lblPeso, HPos.CENTER);
		this.setHalignment(lblAltura, HPos.CENTER);
		this.setHalignment(lblEdad, HPos.CENTER);
		this.setHalignment(lblSexo, HPos.CENTER);

		usuario = new TextField();
		contrasenia = new TextField();
		peso = new TextField();
		altura = new TextField();
		edad = new TextField();
		sexo = new TextField();

		this.setHalignment(usuario, HPos.CENTER);
		this.setHalignment(contrasenia, HPos.CENTER);
		this.setHalignment(peso, HPos.CENTER);
		this.setHalignment(altura, HPos.CENTER);
		this.setHalignment(edad, HPos.CENTER);
		this.setHalignment(sexo, HPos.CENTER);

		Button confirmar = new Button("Confirm");

		this.setHalignment(confirmar, HPos.CENTER);

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

		Scene sceneRegistro = new Scene(panelRegistro, 800, 600);

		if (App.configuracion.getTheme() == 1)
			sceneRegistro.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneRegistro.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneRegistro.getRoot().getStyleClass().add("body");

		registroStage.setResizable(false);
		registroStage.setScene(sceneRegistro);
		registroStage.setTitle("Registro");
		registroStage.show();

		// Añadimos un evento al boton del formulario
		confirmar.setOnAction(e -> {
			if (contrasenia.getText().length() < 7) {
				alertaContrasenia();
			} else {
				try {
					UsuarioDO temp = new UsuarioDO();
					temp.setNombre(usuario.getText());
					temp.setContrasenia(contrasenia.getText());
					temp.setPeso(Double.valueOf(peso.getText()));
					temp.setAltura(Integer.valueOf(altura.getText()));
					temp.setEdad(Integer.valueOf(edad.getText()));
					temp.setSexo(sexo.getText().charAt(0));

					// Si da true cerramos la ventana y le mandamos al inicio de sesion, si da false
					// salta una alerta.
					if (UsuarioDAO.aniadirUsuario(con, temp)) {
						registroStage.close();
						inSesion();
					} else {
						alertaRegistro();
					}
				} catch (Exception error) {
					error.printStackTrace();
					alertaRegistro();
				}
			}
		});
	}

	/**
	 * Alerta que salta si hay problemas al registrarse
	 */
	public void alertaRegistro() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No ha introducido correctamente los datos");
		infoAlert.setContentText(
				"Por favor vuelva a intentarlo, tenga en cuenta que en edad,\npeso y altura debe utilizar numeros");
		infoAlert.showAndWait();
	}

	/**
	 * Alerta que salta si hay problemas al iniciar sesion
	 */
	public void alertaInicio() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("No ha introducido correctamente los datos");
		infoAlert.setContentText("Por favor vuelva a intentarlo o pruebe a crear una cuenta nueva");
		infoAlert.showAndWait();
	}

	/**
	 * Alerta que salta si tu contraseña tiene menos de 7 caracteres
	 */
	public void alertaContrasenia() {
		AlertType tipoAlerta = Alert.AlertType.WARNING;
		Alert infoAlert = new Alert(tipoAlerta);
		infoAlert.setTitle("Alerta!");
		infoAlert.setHeaderText("Su contraseña es demasiado corta!");
		infoAlert.setContentText("Por favor vuelva a intentarlo introduciendo más de 7 caracteres en su contraseña.");
		infoAlert.showAndWait();
	}
}
