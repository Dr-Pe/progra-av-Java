package oia_vagonesDeTren;

public class Manada {
	private String nombre;
	private int nivelAgresivo;
	private int cantidad;
	
	public Manada(String nombre, int nivel, int cant) {
		this.nombre = nombre;
		this.nivelAgresivo = nivel;
		this.cantidad = cant;
	}
	
	
	public int getNivelAgresivo() {
		return nivelAgresivo;
	}


}
