package oia_mesadasDeGranito;

public class Pila {
	private Mesada tope;
	private Mesada base;

	public Pila() {
		tope = null;
		base = null;
	}

	public Pila(Mesada mesada) {
		this.tope = mesada;
		this.base = mesada;
	}

	public void cambiarTope(Mesada nuevoTope) {
		tope = nuevoTope;
	}

	public void cambiarBase(Mesada nuevaBase) {
		base = nuevaBase;
	}

	public Mesada getTope() {
		return tope;
	}

	public Mesada getBase() {
		return base;
	}
}