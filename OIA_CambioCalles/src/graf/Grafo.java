package graf;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    public final static int INF = Integer.MAX_VALUE;

    public final int orden;
    private int[][] ady;
    private List<Arista> aristas;

    public Grafo(int n) {
	orden = n;
	ady = new int[n][n];
	for(int i = 0; i < n; i++) {
	    for(int j = 0; j < n; j++)
		ady[i][j] = INF;
	}
	aristas = new ArrayList<Arista>();
    }

    public void agregarArista(int ni, int nf, int p) {
	ady[ni][nf] = p;
	ady[nf][ni] = p;
	aristas.add(new Arista(ni, nf, p));
    }

    public int peso(int ni, int nf) {
	return ady[ni][nf];
    }

    public int[] distancias(int ni) {
	return ady[ni];
    }

    public List<Integer> vecinos(int ni) {
	List<Integer> r = new ArrayList<Integer>();
	for(int i = 0; i < orden; i++) {
	    if(ady[ni][i] != INF)
		r.add(i);
	}
	return r;
    }

    public List<Arista> getAristas() {
	return aristas;
    }

}
