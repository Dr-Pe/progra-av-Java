package oia_armandoMoviles;

import java.util.ArrayList;

public class Artesano {

	ArrayList<Movil> moviles;
	private double pesoTotal;

	public Artesano() {
		moviles = new ArrayList<Movil>();
		this.pesoTotal = 0;
	}

	public boolean puedeCrearMovil(Colgante a, Colgante b) {

		if (a.getPeso() != b.getPeso())
			return false;

		return true;
	}

	public void crearMovil(Colgante a, Colgante b) {
		this.pesoTotal += (a.getPeso() + b.getPeso());
		moviles.add(new Movil());
	}

	public double getPesoTotal() {
		return this.pesoTotal;
	}

	public int getNroVarillas() {
		return this.moviles.size();
	}

	public int getNumeroMoviles() {
		return this.moviles.size();
	}
}
