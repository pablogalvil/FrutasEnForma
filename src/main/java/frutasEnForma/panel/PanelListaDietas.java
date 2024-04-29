package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;



public class PanelListaDietas extends GridPane{
	

	
	public PanelListaDietas(){
		
		Label lblDietas = new Label("Dietas");
		Label lblNombreDietas = new Label("Nombre Dietas");
		Label lblNumComidas = new Label("Numero Comidas");
		
		Label lblMuestraDieta = new Label();
		Label lblMuestraNombreDietas = new Label();
		Label lblMuestraNumComidas = new Label();

		Button Salir = new Button("Confirm");
		
		this.add(lblDietas, 0, 0);
		this.add(lblMuestraDieta, 1, 0);
		this.add(lblNombreDietas, 0, 1);
		this.add(lblMuestraNombreDietas, 1, 1);
		this.add(lblNumComidas, 0,2);
		this.add(Salir, 0,3);
		
		this.setMargin(lblDietas, new Insets(5, 10, 5, 10));
		this.setMargin(lblNombreDietas, new Insets(5, 10, 5, 10));
		this.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		this.setMargin(lblMuestraDieta, new Insets(5, 10, 5, 10));
		this.setMargin(lblMuestraNombreDietas, new Insets(5, 10, 5, 10));
		this.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		this.setMargin(Salir, new Insets(5, 10, 5, 10));

}
}