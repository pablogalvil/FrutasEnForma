package frutasEnForma.panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PanelManual extends GridPane{
	private String valor;

	public PanelManual() {
		Label lblElige = new Label("Elige una opción");
		Button volver = new Button("Volver a la página principal");

		ChoiceBox<String> chbElige = new ChoiceBox<String>();

		chbElige.getItems().addAll("Menu principal", "Lista de dietas", "Elige tu fruta", "Registro de dietas", "Calculadora de calorias",
				"Nuestros productos", "Recetas");

		this.add(lblElige, 0, 0);
		this.add(chbElige, 1, 0);

		Label informacion = new Label("");
		
		chbElige.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				valor = (String) chbElige.getValue();
				switch (valor) {
				case "Menu principal":
					informacion.setText("El menú principal es el que se abre por defecto al iniciar la aplicación, para usarlo debes iniciar sesión o registrarte."
							+ "\n\nEsta página te da varias opciones, primaramente puedes ver tu racha de dias en ella, además podrás elegir que página visitar y"
							+ "\nproporcionara un boton para ir a ella.");
					break;
				case "Lista de dietas":
					informacion.setText("Aqui podrás ver la lista de dietas disponible, así como sugerir nuevas dietas a la aplicación"
							+ "\n\n");
					break;
				case "Elige tu fruta":
					informacion.setText("");
					break;
				case "Registro de dietas":
					informacion.setText("");
					break;
				case "Calculadora de calorias":
					informacion.setText("En este menú podrás usar nuestra calculadora de calorias, en ella verás la cantidad de calorías que puedes consumir según"
							+ "\ntu peso y altura."
							+ "\n\nPara usarla deberás introducir la cantidad de calorias que planeas consumir, y esta te dará si puedes consumirlar o no.");
					break;
				case "Nuestros productos":
					informacion.setText("");
					break;
				case "Recetas":
					informacion.setText("");
					break;
				}
			}
		});
		this.add(informacion, 0, 1);
		this.add(volver, 0, 2);
	}
}

