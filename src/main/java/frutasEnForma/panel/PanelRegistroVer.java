package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.RegistroDietasDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRegistroVer extends GridPane {

	public int InsIdRegistro;

	public PanelRegistroVer() {
		Stage ventanaEmergente = new Stage();

		GridPane panelRegistroDietas = new GridPane();

		Label lblRegistro = new Label("Registro");
		Label lblNombreRegristro = new Label("Nombre Registro");
		Label lblDiasRealiz = new Label("Dias Realizados");
		Label lblFechIn = new Label("Dia de Inicio");
		Label lblFechFin = new Label("Fecha Fin");

		TextField txtIdRegistro = new TextField();
		InsIdRegistro = Integer.valueOf(txtIdRegistro.getText());

		Label lblMuestraRegistro = new Label(String
				.valueOf(RegistroDietasDAO.getRegistroDietas(App.con, RegistroDietasDAO.id).getIdRegistroDietas()));
		Label lblMuestraNombreRegistro = new Label(
				RegistroDietasDAO.getRegistroDietas(App.con, RegistroDietasDAO.id).getNombre());
		Label lblMuestraDiasRealiz = new Label(
				String.valueOf(RegistroDietasDAO.getRegistroDietas(App.con, RegistroDietasDAO.id).getDiasRealizados()));
		Label lblMuestraFchIn = new Label(
				String.valueOf(RegistroDietasDAO.getRegistroDietas(App.con, RegistroDietasDAO.id).getFechaInicio()));
		Label lblMuestraFchFin = new Label(
				String.valueOf(RegistroDietasDAO.getRegistroDietas(App.con, RegistroDietasDAO.id).getFechaFin()));

		Button salir = new Button("Salir");

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

		panelRegistroDietas.add(salir, 0, 5);

		panelRegistroDietas.setMargin(lblRegistro, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNombreRegristro, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblDiasRealiz, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblFechIn, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblFechFin, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(txtIdRegistro, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(lblMuestraRegistro, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblMuestraNombreRegistro, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblMuestraFchIn, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblMuestraFchFin, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(salir, new Insets(5, 10, 5, 10));

		Scene scene = new Scene(panelRegistroDietas, 600, 600);

		ventanaEmergente.setScene(scene);
		ventanaEmergente.setTitle("Regristro Dieta");
		ventanaEmergente.show();

		salir.setOnAction(e -> {
			ventanaEmergente.close();

		});
	}
}
