package frutasEnForma.panel;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.TickLabelOrientation;
import eu.hansolo.medusa.skins.TinySkin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Medusa extends Application {

	@Override
	public void start(Stage primaryStage) {
		Gauge gauge = new Gauge();
		Button btn = new Button();
		btn.setText("Say 'Hello'");
		btn.setTranslateX(10);
		btn.setTranslateY(200);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
				gauge.setAnimated(true);
				gauge.setValue(90.00);
			}
		});

		gauge.setSkin(new TinySkin(gauge));
		gauge.setTitle("Cool It Help");
		gauge.setUnit("km / h");
		gauge.setUnitColor(Color.WHITE);
		gauge.setDecimals(0);
		gauge.setValue(00.00);
		gauge.setAnimationDuration(500);

		gauge.setValueColor(Color.WHITE);
		gauge.setTitleColor(Color.WHITE);
		gauge.setSubTitleColor(Color.WHITE);
		gauge.setBarColor(Color.rgb(0, 214, 215));
		gauge.setNeedleColor(Color.RED);
		gauge.setThresholdColor(Color.RED);
		gauge.setThreshold(85);
		gauge.setThresholdVisible(true);
		gauge.setTickLabelColor(Color.rgb(151, 151, 151));
		gauge.setTickMarkColor(Color.WHITE);
		gauge.setTickLabelOrientation(TickLabelOrientation.ORTHOGONAL);

		StackPane root = new StackPane();
		root.getChildren().addAll(gauge);
		root.getChildren().addAll(btn);
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Gauge Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
