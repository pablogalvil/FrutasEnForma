package frutasEnForma.panel;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PanelCalculadora extends GridPane{

	public PanelCalculadora() {
		Label lblCalorias = new Label("Introduce Las calorias que vas a consumir");
		Label lblResultado = new Label("");
		
		TextField calorias = new TextField();
		
		this.add(lblCalorias, 0, 0);
		this.add(calorias, 1, 0);
		this.add(lblResultado, 0, 1);
	}
}
