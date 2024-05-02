package frutasEnForma.model;

public class UsuarioDO {
	private int idUsuario;
	private String nombre;
	private String contrasenia;
	private double peso;
	private int altura;
	private char sexo;
	private int edad;
	private int rachaDias;

	public UsuarioDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDO(int idUsuario, String nombre, String contrasenia, double peso, int altura, int rachaDias,
			char sexo, int edad) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.peso = peso;
		this.altura = altura;
		this.rachaDias = rachaDias;
		this.sexo = sexo;
		this.edad = edad;
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
