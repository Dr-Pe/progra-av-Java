package carrera;

public class Corredor {

	private int id;
	private int edad;
	private char sexo;

	public Corredor(int id, int edad, char sexo) {
		this.id = id;
		this.edad = edad;
		this.sexo = sexo;
	}

	public boolean esCategoria(int edadMin, int edadMax, char sexo) {
		return edad >= edadMin && edad <= edadMax && this.sexo == sexo;
	}

	public int getId() {
		return this.id;
	}

}
