package frutasEnForma;

import java.sql.Connection;

import frutasEnForma.panel.PanelPrincipal;
import frutasEnForma.utils.ConfiguracionUsuario;
import frutasEnForma.utils.ConfiguracionUsuario.Config;
import frutasEnForma.utils.UtilsFEF;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFX App
 */
public class App extends Application {

	public static Connection con = UtilsFEF.conectarBD();
	public static Config configuracion = ConfiguracionUsuario.insertarConfig();
	public static Scene scene;

	@Override
	public void start(Stage stage) {

		PanelPrincipal panelPrin = new PanelPrincipal(stage);
		panelPrin.setAlignment(Pos.TOP_CENTER);

		scene = new Scene(panelPrin, 1000, 750);

		// Ponemos el css usando la configuracion del usuario
		if (configuracion.getTheme() == 1)
			scene.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			scene.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		scene.getRoot().getStyleClass().add("body");

		stage.setResizable(false);
		stage.setTitle("FrutasEnForma");
		stage.setScene(scene);
		stage.show();

		ImageView fitFuelView = new ImageView(new Image(getClass().getResourceAsStream("/img/fotoFitFuel.jpg")));

		// Creamos un Popup
		Popup popup = new Popup();
		popup.getContent().add(fitFuelView);

		popup.setAnchorLocation(Popup.AnchorLocation.WINDOW_BOTTOM_LEFT);

		// Hacemos que ocupe toda la pagina
		ScaleTransition scaleIn = new ScaleTransition(Duration.seconds(1), fitFuelView);
		scaleIn.setFromX(1);
		scaleIn.setFromY(1);
		scaleIn.setToX(0.2);
		scaleIn.setToY(0.2);

		// Creamos la animacion de inicio
		ParallelTransition principioAnimacion = new ParallelTransition(scaleIn);

		// Hacemos la animacion
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), event -> {
			popup.show(stage);

			// Hacemos que se cierre
			ScaleTransition scaleOut = new ScaleTransition(Duration.seconds(1), fitFuelView);
			scaleOut.setToX(1);
			scaleOut.setToY(1);

			// Creamos la animacion para que se oculte
			ParallelTransition finalAnimacion = new ParallelTransition(scaleOut);

			// Detenemos la animacion
			PauseTransition pause = new PauseTransition(Duration.seconds(2));
			pause.setOnFinished(e -> {
				// Lo ocultamos
				popup.hide();
			});

			finalAnimacion.setOnFinished(e -> pause.play());

			finalAnimacion.play();
		}));
		timeline.play();

		principioAnimacion.play();

		// Aplicamos la escala usando la configuracion que dejo el usuario justo cuando
		// iniciamos la aplicacion
		panelPrin.applyScale(stage);

		// Guardamos la configuracion.
		stage.setOnCloseRequest(e -> {
			configuracion.setScale(PanelPrincipal.numEscala);
			ConfiguracionUsuario.escribirConfig(configuracion.getTheme(), configuracion.getScale());
		});
	}

	public static void main(String[] args) {
		launch();
	}

}