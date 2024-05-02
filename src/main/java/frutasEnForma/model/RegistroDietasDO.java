package frutasEnForma.model;

public class RegistroDietasDO {
	private int idRegistroDietas;
	private int diasRealizados;
	private String fechaInicio;
	private String fechaFin;
	public static String nombre;

	public RegistroDietasDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroDietasDO(int idRegistroDietas, int diasRealizados, String fechaInicio, String fechaFin,
			String nombre) {
		super();
		this.idRegistroDietas = idRegistroDietas;
		this.diasRealizados = diasRealizados;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.nombre = nombre;

	}

	public int getIdRegistroDietas() {
		return idRegistroDietas;
	}

	public void setIdRegistroDietas(int idRegistroDietas) {
		this.idRegistroDietas = idRegistroDietas;
	}

	public int getDiasRealizados() {
		return diasRealizados;
	}

	public void setDiasRealizados(int diasRealizados) {
		this.diasRealizados = diasRealizados;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
