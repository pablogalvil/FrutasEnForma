package frutasEnForma.panel;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRegistroVer extends GridPane {

	public PanelRegistroVer() {
		Stage ventanaEmergente = new Stage();

		GridPane panelRegistroDietas = new GridPane();

		Label lblRegistro = new Label("Registro");
		Label lblNombreRegristro = new Label("Nombre Registro");
		Label lblDiasRealiz = new Label("Dias Realizados");
		Label lblFechIn = new Label("Dia de Inicio");
		Label lblFechFin = new Label("Fecha Fin");

		Label lblMuestraRegistro = new Label();
		Label lblMuestraNombreRegistro = new Label();
		Label lblMuestraDiasRealiz = new Label();
		Label lblMuestraFchIn = new Label();
		Label lblMuestraFchFin = new Label();

		Button Salir = new Button("Salir");

		panelRegistroDietas.add(lblRegistro, 0, 0);
		panelRegistroDietas.add(lblMuestraRegistro, 1, 0);

		panelRegistroDietas.add(lblNombreRegristro, 0, 1);
		panelRegistroDietas.add(lblMuestraNombreRegistro, 1, 1);

		panelRegistroDietas.add(lblDiasRealiz, 0, 2);
		panelRegistroDietas.add(lblMuestraDiasRealiz, 1, 2);

		panelRegistroDietas.add(lblFechIn, 0, 3);
		panelRegistroDietas.add(lblMuestraFchIn, 1, 3);

		panelRegistroDietas.add(lblFechFin, 0, 4);
		panelRegistroDietas.add(lblMuestraFchFin, 1, 4);

		panelRegistroDietas.add(Salir, 0, 5);

		panelRegistroDietas.setMargin(Salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelRegistroDietas, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Regristro Dieta");
		ventanaEmergente.show();
	}
}
