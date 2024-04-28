package frutasEnForma.model;

public class PesajeDO {
	private int imc;
	private int minCalorias;
	private int maxCalorias;
	
	public PesajeDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PesajeDO(int imc, int minCalorias, int maxCalorias) {
		super();
		this.imc = imc;
		this.minCalorias = minCalorias;
		this.maxCalorias = maxCalorias;
	}
	public int getImc() {
		return imc;
	}
	public void setImc(int imc) {
		this.imc = imc;
	}
	public int getMinCalorias() {
		return minCalorias;
	}
	public void setMinCalorias(int minCalorias) {
		this.minCalorias = minCalorias;
	}
	public int getMaxCalorias() {
		return maxCalorias;
	}
	public void setMaxCalorias(int maxCalorias) {
		this.maxCalorias = maxCalorias;
	}
	
}
