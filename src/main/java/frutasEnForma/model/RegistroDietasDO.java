package frutasEnForma.model;

public class RegistroDietasDO {
	private int idRegistroDietas;
	private int diasRealizados;
	private int fechaInicio;
	private int fechaFin;
	private int ListaDietas_idListaDietas;

	public RegistroDietasDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroDietasDO(int idRegistroDietas, int diasRealizados, int fechaInicio, int fechaFin,
			int listaDietas_idListaDietas) {
		super();
		this.idRegistroDietas = idRegistroDietas;
		this.diasRealizados = diasRealizados;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		ListaDietas_idListaDietas = listaDietas_idListaDietas;
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

	public int getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(int fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(int fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getListaDietas_idListaDietas() {
		return ListaDietas_idListaDietas;
	}

	public void setListaDietas_idListaDietas(int listaDietas_idListaDietas) {
		ListaDietas_idListaDietas = listaDietas_idListaDietas;
	}

}
