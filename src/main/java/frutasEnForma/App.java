package frutasEnForma;

import java.sql.Connection;

import frutasEnForma.panel.PanelPrincipal;
import frutasEnForma.utils.ConfiguracionUsuario;
import frutasEnForma.utils.ConfiguracionUsuario.Config;
import frutasEnForma.utils.UtilsFEF;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	public static Connection con = UtilsFEF.conectarBD();
	public static Config configuracion = ConfiguracionUsuario.insertarConfig();
	public static Scene scene;

	@Override
	public void start(Stage stage) {

		PanelPrincipal panelPrin = new PanelPrincipal();
		panelPrin.setAlignment(Pos.TOP_CENTER);

		scene = new Scene(panelPrin, 1000, 750);

		if (configuracion.getTheme() == 1)
			scene.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		scene.getRoot().getStyleClass().add("body");

		stage.setTitle("FrutasEnForma");
		stage.setScene(scene);
		stage.show();

		stage.setOnCloseRequest(e -> {
			ConfiguracionUsuario.escribirConfig(configuracion.getTheme());
		});
	}

	public static void main(String[] args) {
		launch();
	}

}