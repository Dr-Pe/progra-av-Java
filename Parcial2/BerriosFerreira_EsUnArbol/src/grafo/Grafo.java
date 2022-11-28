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

    public List<Integer> vecinos(int v) {
	List<Integer> r = new ArrayList<Integer>();
	for(int j = 0; j < orden; j++) {
	    if(v != j && peso(v, j) != INF)
		r.add(j);
	}
	return r;
    }

    public boolean esConexo() {
	UnionFind uf = new UnionFind(orden);
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++) {
		if(peso(i, j) != INF)
		    uf.unir(i, j); // O(logV)
	    }
	}
	for(int i = 1; i < orden; i++) {
	    if(!uf.mismoSet(0, i))
		return false;
	}
	return true;
    }

}
