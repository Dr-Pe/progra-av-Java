package res;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import graf.Arista;
import graf.Dijkstra;
import graf.Grafo;

public class Resolucion {

    // IN
    private Grafo g;
    private int ni;
    private int nf;

    // OUT
    private int dist;
    private List<Integer> callesACambiar;

    public static void main(String[] args) {

	String nombre = "casos_de_prueba/caso06_1000x2300";
	Archivo ar = new Archivo(nombre);
	Resolucion r = ar.leerArchivo();

	r.resolver();

	System.out.println(r.dist);
	System.out.println(Arrays.toString(r.callesACambiar.toArray(new Integer[0])));
    }

    Resolucion(Grafo g, int ni, int nf) {
	this.g = g;
	this.ni = ni;
	this.nf = nf;
	callesACambiar = new ArrayList<Integer>();
    }

    private void resolver() {
	Dijkstra dij = new Dijkstra(g, ni);

	dist = dij.getCostos()[nf];

	for(Arista ar : camino(dij.getPrecedencias())) {
	    if(!g.getAristas().contains(ar)) {
		callesACambiar.add(g.getAristas()
					.indexOf(new Arista(ar.getNf(), ar.getNi(), 0)));
	    }
	}
    }

    private List<Arista> camino(int[] prec) {
	List<Arista> r = new ArrayList<Arista>();
	int na = nf;
	while(na != ni) {
	    r.add(new Arista(prec[na], na, 0));
	    na = prec[na];
	}
	return r;
    }

}
