package oia_armandoMoviles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Fabrica {

	private ArrayList<Colgante> colgantes;
	private RegistroColgantes regColgantes;
	private Artesano miguel;

	public void trabajar(String name) {

		leer(name);
		resolver();
		escribir();

	}

	public Fabrica() {
		this.colgantes = new ArrayList<Colgante>();
		this.miguel = null;
		this.regColgantes = null;

	}

	public void leer(String name) {
		this.regColgantes = new RegistroColgantes(name);
		this.colgantes = regColgantes.leerRegistro();
	}

	public void resolver() {

		this.miguel = new Artesano();
		// O(n.log(n))
		Collections.sort(colgantes, new Comparator<Colgante>() {
			@Override
			public int compare(Colgante a, Colgante b) {
				return (int) (a.getPeso() - b.getPeso());
			}
		});

		for (int i = 1; i < colgantes.size(); i++) {
			colgantes.get(i - 1);
			if (this.miguel.puedeCrearMovil(colgantes.get(i), colgantes.get(i - 1))) {
				this.miguel.crearMovil(colgantes.get(i), colgantes.get(i - 1));

				i++;
			}
		}
	}

	public void escribir() {
		this.regColgantes.escribirRegistro(this);

	}

	public double getPesoTotal() {
		return this.miguel.getPesoTotal();
	}

	public int getNumeroVarillas() {
		return this.miguel.getNroVarillas();
	}

	public int getNumeroMoviles() {
		return this.miguel.getNumeroMoviles();
	}

}
