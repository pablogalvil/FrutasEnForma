package frutasEnForma.model;

public class UsuarioDO {
	private int idUsuario;
	private String nombre;
	private String contrasenia;
	private int peso;
	private int altura;
	private int rachaDias;
	private int pesaje_imc;
	
	public UsuarioDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDO(int idUsuario, String nombre, String contrasenia, int peso, int altura, int rachaDias,
			int pesaje_imc) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.peso = peso;
		this.altura = altura;
		this.rachaDias = rachaDias;
		this.pesaje_imc = pesaje_imc;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getRachaDias() {
		return rachaDias;
	}
	public void setRachaDias(int rachaDias) {
		this.rachaDias = rachaDias;
	}
	public int getPesaje_imc() {
		return pesaje_imc;
	}
	public void setPesaje_imc(int pesaje_imc) {
		this.pesaje_imc = pesaje_imc;
	}
	
}
