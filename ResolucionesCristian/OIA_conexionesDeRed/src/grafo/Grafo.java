package grafo;

import java.util.ArrayList;

public class Grafo {
	public final int INF = Integer.MAX_VALUE;
	private int[][] ady;
	public final int orden;

	public Grafo(int n) {
		this.orden = n;
		ady = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ady[i][j] = INF;
			}
		}
	}

	public void agregarArista(int vi, int vf, int p) {
		this.ady[vi][vf] = p;
		this.ady[vf][vi] = p;
	}

	public void agregarArista(Arista ar) {
		this.ady[ar.getVi()][ar.getVf()] = 1;
		this.ady[ar.getVf()][ar.getVi()] = 1;
	}

	public boolean existeArista(Arista ar) {

		return this.ady[ar.getVi()][ar.getVf()] == INF ? false : true;
	}

	public ArrayList<Integer> vecinos(int na) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < orden; i++) {
			if (ady[na][i] != INF)
				r.add(i);
		}
		return r;
	}
}
