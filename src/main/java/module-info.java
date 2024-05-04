module org.openjfx.FrutasEnForma {
	requires javafx.controls;
	requires itextpdf;
	requires javafx.graphics;
	requires java.sql;
	requires java.desktop;
	requires java.compiler;
	requires com.jfoenix;
	requires javafx.base;
	requires Medusa;

	exports frutasEnForma.panel to javafx.graphics;
	exports frutasEnForma;
}
