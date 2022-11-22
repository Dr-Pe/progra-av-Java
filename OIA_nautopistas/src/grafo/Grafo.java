package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	public static final int INF = Integer.MAX_VALUE;
	public final int orden;

	private int[][] ady;
	private List<Arista> aristas;

	public Grafo(int n) {
		this.aristas = new ArrayList<Arista>();
		this.orden = n;
		this.ady = new int[n][n];
	}

	public void agregarArista(int ni, int nf, int p) {
		ady[ni][nf] = p;
		ady[nf][ni] = p;
		aristas.add(new Arista(ni, nf, p));
	}

	public List<Arista> getAristas() {
		return this.aristas;
	}
}
