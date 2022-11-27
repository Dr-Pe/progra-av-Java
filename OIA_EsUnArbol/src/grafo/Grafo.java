package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    public final static int INF = Integer.MAX_VALUE;

    public final int orden;
    private int[][] ady;

    public Grafo(int n) {
	orden = n;
	ady = new int[n][n];
	for(int i = 0; i < n; i++) {
	    for(int j = 0; j < n; j++)
		agregarArista(i, j, INF);
	    agregarArista(i, i, 0);
	}
    }

    public void agregarArista(int vi, int vf, int p) {
	ady[vi][vf] = p;
    }

    public int peso(int vi, int vf) {
	return ady[vi][vf];
    }

    public int aristasEntrantes(int v) {
	int ar = 0;
	for(int i = 0; i < orden; i++) {
	    if(v != i && peso(i, v) != INF)
		ar++;
	}
	return ar;
    }

    public int aristasSalientes(int v) {
	int ar = 0;
	for(int i = 0; i < orden; i++) {
	    if(v != i && peso(v, i) != INF)
		ar++;
	}
	return ar;
    }

    public List<Integer> vecinos(int v) {
	List<Integer> r = new ArrayList<Integer>();
	for(int j = 0; j < orden; j++) {
	    if(v != j && peso(v, j) != INF)
		r.add(j);
	}
	return r;
    }

}
