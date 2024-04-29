package frutasEnForma.model;

public class ListaDietasDO {
	private int idListaDietas;
	private String nombre;
	private int numComidas;

	public ListaDietasDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaDietasDO(int idListaDietas, String nombre, int numComidas) {
		super();
		this.idListaDietas = idListaDietas;
		this.nombre = nombre;
		this.numComidas = numComidas;
	}

	public int getIdListaDietas() {
		return idListaDietas;
	}

	public void setIdListaDietas(int idListaDietas) {
		this.idListaDietas = idListaDietas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumComidas() {
		return numComidas;
	}

	public void setNumComidas(int numComidas) {
		this.numComidas = numComidas;
	}

}
