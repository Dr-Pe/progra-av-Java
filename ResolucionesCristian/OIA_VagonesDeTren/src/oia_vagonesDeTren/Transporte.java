package oia_vagonesDeTren;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Transporte {
	private String registro;
	private ArrayList<Manada> manadas;
	private ArrayList<Vagon> vagones;
	private int maxAgresividad;
	
	public Transporte(){
		this.manadas = new ArrayList<Manada>();
		this.vagones = new ArrayList<Vagon>();
		this.maxAgresividad = 0;
	}
	
	public void transportar(String registro) {
		this.registro = registro;
		this.leer();
		this.resolver();
		this.escribir();
	}

	public void leer() {
		RegistroAnimales registro = new RegistroAnimales(this.registro);
		this.maxAgresividad = registro.leerRegistro(this.manadas);
	}

	public void resolver() {

		// n.log(n)
		Collections.sort(manadas, new Comparator<Manada>() {
			public int compare(Manada a, Manada b) {
				return a.getNivelAgresivo() - b.getNivelAgresivo();
			}
		});

		Manada primerManada = manadas.get(0);
		Vagon vagonActual = new Vagon();
		vagones.add(vagonActual);

		vagonActual.llevarManada(primerManada);
		for (int i = 1; i < manadas.size(); i++) {
			if (vagonActual.puedeLlevar(manadas.get(i), this.maxAgresividad))
				vagonActual.llevarManada(manadas.get(i));
			else {
				vagonActual = new Vagon();
				vagonActual.llevarManada(manadas.get(i));
				vagones.add(vagonActual);
			}
		}

	}

	public void escribir() {
		RegistroAnimales registro = new RegistroAnimales(this.registro);
		registro.escribirRegistro(this);
	}
	

	public int getVagones() {
		return this.vagones.size();
	}

	public int getAgresividadTotal() {
		int agresividadTotal = 0;
		for (Vagon i : this.vagones) {
			agresividadTotal += i.agresividadVagon();
		}
		return agresividadTotal;
	}

}
