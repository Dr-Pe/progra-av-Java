package oia_mesadasDeGranito;

public class Mesada {
	private int ancho;
	private int largo;

	public Mesada() {
		ancho = 0;
		largo = 0;
	}

	public Mesada(int ancho, int largo) {
		this.ancho = ancho;
		this.largo = largo;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int sonApilables(Mesada otro) {
		// si es apilable sobre this.
		//
		// 	  -- 	otro
		// -------- this
		if (this.ancho >= otro.ancho && this.largo >= otro.largo)
			return 1;

		if (this.ancho >= otro.largo && this.largo >= otro.ancho) {
			otro.rotar();

			return 1;
		}

		// si this es apilable sobre otro
		//
		// ------- 	otro
		// 	--- 	this
		if (otro.ancho >= this.ancho && otro.largo >= this.largo)
			return -1;

		if (otro.ancho >= this.largo && otro.largo >= this.ancho) {
			this.rotar();

			return -1;
		}

		// 0 si no es apilable ni sobre, ni bajo
		return 0;
	}

	public void rotar() {
		int aux = this.ancho;
		this.ancho = this.largo;
		this.largo = aux;
	}

}
