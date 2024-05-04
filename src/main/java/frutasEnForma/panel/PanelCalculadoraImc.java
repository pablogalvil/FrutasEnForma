package frutasEnForma.panel;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.TickLabelOrientation;
import eu.hansolo.medusa.skins.ModernSkin;
import frutasEnForma.App;
import frutasEnForma.model.UsuarioDAO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PanelCalculadoraImc extends GridPane {

	public static double imcRe = Double.valueOf(UsuarioDAO.calculoImc(UsuarioDAO.idUsuario, App.con));

	/**
	 * Panel que calcula el imc del usuario en funcion de los datos guardados en la
	 * base de datos.
	 */
	public PanelCalculadoraImc() {
		Stage ventanaImc = new Stage();

		GridPane panelImc = new GridPane();
		panelImc.setAlignment(Pos.CENTER);

		Label lblExplicacion = new Label(
				"Hemos calculado su IMC usando el peso y la altura previamente\nintroducida al registrarse");
		Label lblNota = new Label(
				"(Tenga en cuenta que si no relleno dichos datos al registrarse el resultado será 0)");

		Label lblResultado = new Label(String.valueOf(UsuarioDAO.calculoImc(UsuarioDAO.idUsuario, App.con)));

		panelImc.setHalignment(lblExplicacion, HPos.CENTER);
		panelImc.setHalignment(lblNota, HPos.CENTER);
		panelImc.setHalignment(lblResultado, HPos.CENTER);

		panelImc.add(lblExplicacion, 0, 0);
		panelImc.add(lblNota, 0, 1);
		panelImc.add(lblResultado, 0, 2);

		// Este objeto crea un reloj el cual segun el imc que tengas mueve la manecilla
		// y
		// coloca un tecto el cual te dice si tienes un imc bajo normal con sobrepeso u
		// obseso
		// Tambien cambia de color si pasas de un limite

		Gauge gauge = new Gauge();

		gauge.setSkin(new ModernSkin(gauge));
		// Cambiamos el texto en funcion del valor del IMC
		if (imcRe <= 18) {
			gauge.setTitle("IMC Bajo");
		}
		if (imcRe >= 19 && imcRe <= 24) {
			gauge.setTitle("IMC Normal");
		}
		if (imcRe >= 25 && imcRe <= 29) {
			gauge.setTitle("IMC Sobrepeso");
		}
		if (imcRe >= 30) {
			gauge.setTitle("IMC Obesidad");
		}
		gauge.setUnit("IMC");
		gauge.setUnitColor(Color.WHITE);
		gauge.setDecimals(0);
		gauge.setValue(imcRe);
		gauge.setAnimationDuration(500);

		gauge.setValueColor(Color.WHITE);
		gauge.setTitleColor(Color.WHITE);
		gauge.setSubTitleColor(Color.WHITE);
		gauge.setBarColor(Color.rgb(0, 214, 215));
		gauge.setNeedleColor(Color.RED);
		gauge.setThresholdColor(Color.RED);
		gauge.setThreshold(25);
		gauge.setThresholdVisible(true);
		gauge.setTickLabelColor(Color.rgb(151, 151, 151));
		gauge.setTickMarkColor(Color.WHITE);
		gauge.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL);

		panelImc.add(gauge, 0, 3);

		Scene sceneImc = new Scene(panelImc, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneImc.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneImc.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneImc.getRoot().getStyleClass().add("body");

		lblResultado.setId("labelResultadoCalculadora");

		ventanaImc.setScene(sceneImc);
		ventanaImc.setTitle("Calculadora IMC");
		ventanaImc.show();
	}
}
