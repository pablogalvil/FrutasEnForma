package frutasEnForma.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfiguracionUsuario {
	public static final String CONFIGURACION = "C:\\Programación\\FrutasEnForma\\src\\main\\java\\frutasEnForma\\utils\\Configuracion.txt";

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

	public static Config insertarConfig() {
		try {
			BufferedReader brConfig = new BufferedReader(new FileReader(CONFIGURACION));

			int theme = Integer.parseInt(brConfig.readLine());

			double scale = Double.parseDouble(brConfig.readLine());

			brConfig.close();

			return new Config(theme, scale);
		} catch (NumberFormatException e) {
			// Pongo el light mode como default
			e.printStackTrace();
			return new Config(0, 1.0);
		} catch (IOException e) {
			// Pongo el light mode como default
			e.printStackTrace();
			return new Config(0, 1.0);
		}
	}

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
