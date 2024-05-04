package frutasEnForma.panel;

import frutasEnForma.App;
import frutasEnForma.model.RegistroDietasDAO;
import frutasEnForma.model.RegistroDietasDO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelRegistroVer extends GridPane {

	public int InsIdRegistro;

	/**
	 * Panel que muestra los registros del usuario
	 */
	public PanelRegistroVer() {
		Stage stageRegistroDietas = new Stage();

		GridPane panelRegistroDietas = new GridPane();
		panelRegistroDietas.setAlignment(Pos.CENTER);

		Label lblNum = new Label("Nombre de la dieta");
		Label lblRegistro = new Label("Registro");
		Label lblNombreRegistro = new Label("Nombre Registro");
		Label lblDiasRealiz = new Label("Dias Realizados");
		Label lblFechIn = new Label("Dia de Inicio");
		Label lblFechFin = new Label("Fecha Fin");

		TextField txtNombreIns = new TextField();

		Button confirmar = new Button("Mostrar registro");

		panelRegistroDietas.add(lblNum, 0, 0);
		panelRegistroDietas.add(txtNombreIns, 1, 0);
		panelRegistroDietas.add(lblRegistro, 0, 1);
		panelRegistroDietas.add(lblNombreRegistro, 0, 2);
		panelRegistroDietas.add(lblDiasRealiz, 0, 3);
		panelRegistroDietas.add(lblFechIn, 0, 4);
		panelRegistroDietas.add(lblFechFin, 0, 5);

		panelRegistroDietas.add(confirmar, 0, 6);

		panelRegistroDietas.setMargin(lblNum, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblRegistro, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblNombreRegistro, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblDiasRealiz, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblFechIn, new Insets(5, 10, 5, 10));
		panelRegistroDietas.setMargin(lblFechFin, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(txtNombreIns, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setMargin(confirmar, new Insets(5, 10, 5, 10));

		panelRegistroDietas.setHalignment(lblNum, HPos.CENTER);
		panelRegistroDietas.setHalignment(lblRegistro, HPos.CENTER);
		panelRegistroDietas.setHalignment(lblNombreRegistro, HPos.CENTER);
		panelRegistroDietas.setHalignment(lblDiasRealiz, HPos.CENTER);
		panelRegistroDietas.setHalignment(lblFechIn, HPos.CENTER);
		panelRegistroDietas.setHalignment(lblFechFin, HPos.CENTER);

		panelRegistroDietas.setHalignment(txtNombreIns, HPos.CENTER);

		panelRegistroDietas.setHalignment(confirmar, HPos.CENTER);

		Scene sceneRegistroDietas = new Scene(panelRegistroDietas, 800, 600);

		// Ponemos el css usando la configuracion del usuario
		if (App.configuracion.getTheme() == 1)
			sceneRegistroDietas.getStylesheets().add(getClass().getResource("/css/darkcss.css").toExternalForm());
		else
			sceneRegistroDietas.getStylesheets().add(getClass().getResource("/css/css.css").toExternalForm());

		sceneRegistroDietas.getRoot().getStyleClass().add("body");

		stageRegistroDietas.setScene(sceneRegistroDietas);
		stageRegistroDietas.setTitle("Mostrar registro");
		stageRegistroDietas.show();

		// Al presionar el boton añadimos labels con todos los campos que da de
		// resultado la funcion
		confirmar.setOnAction(e -> {
			RegistroDietasDO temp = RegistroDietasDAO.getRegistroDietas(App.con, txtNombreIns.getText());

			Label lblMuestraRegistro = new Label(String.valueOf(temp.getIdRegistroDietas()));
			Label lblMuestraNombreRegistro = new Label(temp.getNombre());
			Label lblMuestraDiasRealiz = new Label(String.valueOf(temp.getDiasRealizados()));
			Label lblMuestraFchIn = new Label(String.valueOf(temp.getFechaInicio()));
			Label lblMuestraFchFin = new Label(String.valueOf(temp.getFechaFin()));

			panelRegistroDietas.add(lblMuestraRegistro, 1, 1);
			panelRegistroDietas.add(lblMuestraNombreRegistro, 1, 2);
			panelRegistroDietas.add(lblMuestraDiasRealiz, 1, 3);
			panelRegistroDietas.add(lblMuestraFchIn, 1, 4);
			panelRegistroDietas.add(lblMuestraFchFin, 1, 5);

			panelRegistroDietas.setMargin(lblMuestraRegistro, new Insets(5, 10, 5, 10));
			panelRegistroDietas.setMargin(lblMuestraNombreRegistro, new Insets(5, 10, 5, 10));
			panelRegistroDietas.setMargin(lblMuestraDiasRealiz, new Insets(5, 10, 5, 10));
			panelRegistroDietas.setMargin(lblMuestraFchIn, new Insets(5, 10, 5, 10));
			panelRegistroDietas.setMargin(lblMuestraFchFin, new Insets(5, 10, 5, 10));

			panelRegistroDietas.setHalignment(lblMuestraRegistro, HPos.CENTER);
			panelRegistroDietas.setHalignment(lblMuestraNombreRegistro, HPos.CENTER);
			panelRegistroDietas.setHalignment(lblMuestraDiasRealiz, HPos.CENTER);
			panelRegistroDietas.setHalignment(lblMuestraFchIn, HPos.CENTER);
			panelRegistroDietas.setHalignment(lblMuestraFchFin, HPos.CENTER);
		});
	}
}
