package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelEditUser extends GridPane {
	/**
	 * Panel que usa el icono de editar usuario, con el se edita en la base de datos
	 * el peso, la altura y la edad.
	 */
	public PanelEditUser() {
		Stage ventanaEditUser = new Stage();

		GridPane panelEditUser = new GridPane();
		panelEditUser.setAlignment(Pos.CENTER);

		Label lblPeso = new Label("Peso");
		Label lblAltura = new Label("Altura");
		Label lblEdad = new Label("Edad");

		panelEditUser.setHalignment(lblPeso, HPos.CENTER);
		panelEditUser.setHalignment(lblAltura, HPos.CENTER);
		panelEditUser.setHalignment(lblEdad, HPos.CENTER);

		TextField txtPeso = new TextField();
		TextField txtAltura = new TextField();
		TextField txtEdad = new TextField();

		panelEditUser.setHalignment(txtPeso, HPos.CENTER);
		panelEditUser.setHalignment(txtAltura, HPos.CENTER);
		panelEditUser.setHalignment(txtEdad, HPos.CENTER);

		Button confirmar = new Button("Confirmar");

		panelEditUser.setHalignment(confirmar, HPos.CENTER);

		panelEditUser.add(lblPeso, 0, 0);
		panelEditUser.add(txtPeso, 0, 1);
		panelEditUser.add(lblAltura, 0, 2);
		panelEditUser.add(txtAltura, 0, 3);
		panelEditUser.add(lblEdad, 0, 4);
		panelEditUser.add(txtEdad, 0, 5);
		panelEditUser.add(confirmar, 0, 6);

		panelEditUser.setMargin(confirmar, new Insets(5, 10, 5, 10));

		Scene sceneEditUser = new Scene(panelEditUser, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneEditUser.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneEditUser.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneEditUser.getRoot().getStyleClass().add("body");

		ventanaEditUser.setResizable(false);
		ventanaEditUser.setScene(sceneEditUser);
		ventanaEditUser.setTitle("Editar usuario");
		ventanaEditUser.show();

		confirmar.setOnAction(e -> {
			// Se hace el cambio y cierra la ventana
			UsuarioDAO.updateUsuario(App.con, Double.valueOf(txtPeso.getText()), Integer.valueOf(txtAltura.getText()),
					Integer.valueOf(txtEdad.getText()));
			ventanaEditUser.close();
		});
	}
}
