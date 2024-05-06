package frutasEnForma.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfiguracionUsuario {
	// Quiero dar creditos a Alejandro Morilla que me ha explicado como hacerlo (sin
	// su ayuda probablemente no habria sabido hacerlo).

	// Definimos la ruta de nuestro archivo de configuracion.
	public static final String CONFIGURACION = "D:\\Programación\\FrutasEnForma\\FrutasEnForma\\src\\main\\java\\frutasEnForma\\utils\\Configuracion.txt";

	/**
	 * Funcion que reescribe el documento configuracion.txt según la configuracion
	 * antes de cerrar la aplicacion.
	 * 
	 * @param theme valor del tema de fondo antes de cerrar la app.
	 * @param scale valor de la escala antes de cerrar la app.
	 */
	public static void escribirConfig(int theme, double scale) {
		try {
			BufferedWriter bwConfig = new BufferedWriter(new FileWriter(CONFIGURACION));

			bwConfig.write(theme + "\n");

			bwConfig.write(scale + "\n");

			bwConfig.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funcion que lee los valores del documento configuracion.txt y los devuelve
	 * para aplicarlos en la app al iniciarla.
	 * 
	 * @return objeto Config con los valores del documento.
	 */
	public static Config insertarConfig() {
		try {
			BufferedReader brConfig = new BufferedReader(new FileReader(CONFIGURACION));

			int theme = Integer.parseInt(brConfig.readLine());

			double scale = Double.parseDouble(brConfig.readLine());

			brConfig.close();

			return new Config(theme, scale);
		} catch (NumberFormatException e) {
			// Pongo en caso de error el light mode y el zoom normal como default
			e.printStackTrace();
			return new Config(0, 1.0);
		} catch (IOException e) {
			// Pongo en caso de error el light mode y el zoom normal como default
			e.printStackTrace();
			return new Config(0, 1.0);
		}
	}

	/**
	 * Objeto Config que guarda los valores de la configuración.
	 */
	public static class Config {
		private int theme;
		private double scale;

		public Config(int theme, double scale) {
			super();
			this.theme = theme;
			this.scale = scale;
		}

		public int getTheme() {
			return theme;
		}

		public void setTheme(int theme) {
			this.theme = theme;
		}

		public double getScale() {
			return scale;
		}

		public void setScale(double scale) {
			this.scale = scale;
		}

	}
}
