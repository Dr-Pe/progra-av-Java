package oia_vagonesDeTren;

import java.util.ArrayList;

public class Vagon {
	private ArrayList<Manada> manadas;

	public Vagon() {
		manadas = new ArrayList<Manada>();
	}

	public void llevarManada(Manada manada) {
		manadas.add(manada);
	}

	public boolean puedeLlevar(Manada manada, int maximaAgresividad) {

		int difAgresividad = manada.getNivelAgresivo() - this.manadas.get(0).getNivelAgresivo();

		if (difAgresividad > maximaAgresividad)
			return false;

		return true;
	}

	public int agresividadVagon() {

		int size = manadas.size();
		if (size == 1)
			return 0;
		else
			return manadas.get(size - 1).getNivelAgresivo() - manadas.get(0).getNivelAgresivo();
	}
}
