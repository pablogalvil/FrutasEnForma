package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class PanelListaDietas extends GridPane{
	
	public static String InsNom;
 	public static int InsCom;
	public static int InsId;
	
	
	public PanelListaDietas(){
		Stage ventanaEmergente = new Stage();

		GridPane panelRegistroDietas = new GridPane();
		
		
		Label lblDietas = new Label("Dietas");
		Label lblNombreDietas = new Label("Nombre Dietas");
		Label lblNumComidas = new Label("Numero Comidas");
		
		Label lblMuestraDieta = new Label();
		Label lblMuestraNombreDietas = new Label();
		Label lblMuestraNumComidas = new Label();

		Button Salir = new Button("Confirm");
		
		panelRegistroDietas.add(lblDietas, 0, 0);
		panelRegistroDietas.add(lblMuestraDieta, 1, 0);
		panelRegistroDietas.add(lblNombreDietas, 0, 1);
		panelRegistroDietas.add(lblMuestraNombreDietas, 1, 1);
		panelRegistroDietas.add(lblNumComidas, 0,2);
		panelRegistroDietas.add(Salir, 0,3);
		
		panelRegistroDietas.setMargin(lblDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(lblMuestraDieta, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblMuestraNombreDietas, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNumComidas, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(Salir, new Insets(5, 10, 5, 10));
		
		Scene scene = new Scene(panelRegistroDietas, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Regristro Dieta");
		ventanaEmergente.show();

}

	public void AniadirLista(){
		
		Stage ventanaEmergente = new Stage();

		GridPane panelListaAniadir = new GridPane();
		
		Label lblInsNom = new Label("Inserta el nombre de la dieta");
		Label lblInsCom = new Label("Inserta el número de comidas de la dieta");
		
		TextField txtInsNom = new TextField();
		TextField txtInsCom = new TextField();
		
		InsNom = txtInsNom.getText();
		InsCom = Integer.valueOf(txtInsCom.getText());
		
		Button Confirmar = new Button("Confirm");
		Button Salir = new Button("Salir");
		
		panelListaAniadir.add(lblInsNom, 0, 0);
		panelListaAniadir.add(txtInsNom, 1, 0);
		panelListaAniadir.add(lblInsCom, 0, 1);
		panelListaAniadir.add(txtInsCom, 1, 1);
		panelListaAniadir.add(Confirmar, 0,2);
		panelListaAniadir.add(Salir, 1,2);
		
		panelListaAniadir.setMargin(lblInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(lblInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(txtInsNom, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(txtInsCom, new Insets(5, 10, 5, 10));

		panelListaAniadir.setMargin(Confirmar, new Insets(5, 10, 5, 10));
		panelListaAniadir.setMargin(Salir, new Insets(5, 10, 5, 10));
		
		Scene scene = new Scene(panelListaAniadir, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Añadir Dieta");
		ventanaEmergente.show();
		
		
}

public void BorarDietas(){
		
		Stage ventanaEmergente = new Stage();

		GridPane panelListaBorrar = new GridPane();
		
		Label lblInsId = new Label("Inserta el Id de la dieta");
		
		TextField txtInsId = new TextField();
		
		InsId = Integer.valueOf(txtInsId.getText());
		
		Button Confirmar = new Button("Confirm");
		Button Salir = new Button("Salir");
		
		panelListaBorrar.add(lblInsId, 0, 0);
		panelListaBorrar.add(txtInsId, 1, 0);
		panelListaBorrar.add(Confirmar, 0,2);
		panelListaBorrar.add(Salir, 1,2);
		
		panelListaBorrar.setMargin(lblInsId, new Insets(5, 10, 5, 10));

		panelListaBorrar.setMargin(txtInsId, new Insets(5, 10, 5, 10));

		panelListaBorrar.setMargin(Confirmar, new Insets(5, 10, 5, 10));
		panelListaBorrar.setMargin(Salir, new Insets(5, 10, 5, 10));
		
		Scene scene = new Scene(panelListaBorrar, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Borrar Dieta");
		ventanaEmergente.show();
		
		
}



}