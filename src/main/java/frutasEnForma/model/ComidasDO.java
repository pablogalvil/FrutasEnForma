package frutasEnForma.model;

public class ComidasDO {

	private int idComida;
	private String nombre;
	private int calorias;
	private int Recetas_idRecetas;

	public ComidasDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComidasDO(int idComida, String nombre, int calorias, int recetas_idRecetas) {
		super();
		this.idComida = idComida;
		this.nombre = nombre;
		this.calorias = calorias;
		Recetas_idRecetas = recetas_idRecetas;
	}

	public int getIdComida() {
		return idComida;
	}

	public void setIdComida(int idComida) {
		this.idComida = idComida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public int getRecetas_idRecetas() {
		return Recetas_idRecetas;
	}

	public void setRecetas_idRecetas(int recetas_idRecetas) {
		Recetas_idRecetas = recetas_idRecetas;
	}

}
