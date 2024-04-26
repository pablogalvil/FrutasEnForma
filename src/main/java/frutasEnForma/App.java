package frutasEnForma;

import frutasEnForma.panel.PanelPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {

		Scene scene = new Scene(new PanelPrincipal(), 640, 480);

		stage.setTitle("FrutasEnForma");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}