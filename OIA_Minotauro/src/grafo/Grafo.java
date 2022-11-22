package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    public final int orden;
    private int[][] ady;

    private List<Arista> aristas;

    public Grafo(int n) {
	orden = n;
	ady = new int[n][n];
	aristas = new ArrayList<Arista>();
    }

    public void agregarArista(int vi, int vf, int p) {
	ady[vi][vf] = p;
	ady[vf][vi] = p;
	aristas.add(new Arista(vi, vf, p));
    }

    public List<Arista> getAristas() {
	return this.aristas;
    }

}
