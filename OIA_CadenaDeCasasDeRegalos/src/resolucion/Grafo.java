package resolucion;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private final int INF = 0;
	private int[][] ady;
	public final int orden;

	public Grafo(int ord) {
		this.orden = ord;
		ady = new int[ord][ord];
	}

	public void agregarArista(int vi, int vf) {
		ady[vi][vf] = 1;
		ady[vf][vi] = 1;
	}

	public List<Integer> vecinos(int V) {
		ArrayList<Integer> vecinos = new ArrayList<Integer>();

		for (int i = 0; i < orden; i++) {
			if (ady[V][i] != INF && V != i) {
				vecinos.add(i);
			}
		}
		return vecinos;
	}

	@Override
	public String toString() {
		String r = null;

		return r;
	}
}
