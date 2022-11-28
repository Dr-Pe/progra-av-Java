package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	public static final int INF = Integer.MAX_VALUE;
	public final int orden;

	private int[][] ady;

	public Grafo(int n) {
		this.orden = n;
		ady = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ady[i][j] = INF;
			}
			ady[i][i] = 0;
		}
	}

	public void agregarArista(int ni, int nf) {
		ady[ni][nf] = 1;
		ady[nf][ni] = 1;
	}

	public List<Integer> vecinos(int ni) {
		List<Integer> r = new ArrayList<Integer>();

		for (int i = 0; i < orden; i++) {
			if (ni != i && ady[ni][i] != INF)
				r.add(i);
		}
		return r;
	}

}
