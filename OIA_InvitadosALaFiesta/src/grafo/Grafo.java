package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    // No dirigido y sin peso

    public static final int INF = 0;

    public final int orden;
    private int[][] ady;

    public Grafo(int ord) {
	orden = ord;
	ady = new int[ord][ord];
    }

    public void agregarArista(int ni, int nf) {
	ady[ni][nf] = 1;
	ady[nf][ni] = 1;
    }

    public List<Integer> vecinos(int n) {
	List<Integer> r = new ArrayList<Integer>();
	for(int i = 0; i < orden; i++) {
	    if(ady[n][i] != INF)
		r.add(i);
	}
	return r;
    }

}
