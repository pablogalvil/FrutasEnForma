package frutasEnForma.model;

public class RecetasDO {

	private int idRecetas;
	private String nombre;
	private int tiempoPreparacion;
	private String ingredientes;
	private String pasos;

	public RecetasDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecetasDO(int idRecetas, String nombre, int tiempoPreparacion, String ingredientes, String pasos) {
		super();
		this.idRecetas = idRecetas;
		this.nombre = nombre;
		this.tiempoPreparacion = tiempoPreparacion;
		this.ingredientes = ingredientes;
		this.pasos = pasos;
	}

	public int getIdRecetas() {
		return idRecetas;
	}

	public void setIdRecetas(int idRecetas) {
		this.idRecetas = idRecetas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPasos() {
		return pasos;
	}

	public void setPasos(String pasos) {
		this.pasos = pasos;
	}

}
