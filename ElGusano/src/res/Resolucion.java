package res;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graf.Floyd;
import graf.Grafo;

public class Resolucion {

    // IN
    private Grafo G;
    private Par[] pares;

    // OUT
    private List<Integer> posiblesFocos;

    public static void main(String[] args) {

	Archivo ar = new Archivo("caso5_fatiga");

//	ar.crearCasoDeFatiga();

	Resolucion r = ar.leerArchivo();

	r.resolver();
	ar.escribirArchivo(r);

    }

    public Resolucion(Grafo g, Par[] pares) {
	G = g;
	this.pares = pares;
	posiblesFocos = new ArrayList<Integer>();
    }

    public List<Integer> getPosiblesFocos() {
	return posiblesFocos;
    }

    private void resolver() {
	Map<Integer, Integer> compVsCant = new HashMap<Integer, Integer>();
	Floyd fw = new Floyd(G);

	int[][] dist = fw.getClonedDist();

	for(Par p : pares) {
	    for(int i = 0; i < dist.length; i++) {
		int h = dist[p.getComputadora() - 1][i];
		if(h == p.getHora()) {
		    if(compVsCant.putIfAbsent(i, 1) != null)
			compVsCant.put(i, compVsCant.get(i) + 1);
		}
	    }
	}

	for(Integer k : compVsCant.keySet()) {
	    if(compVsCant.get(k) == pares.length)
		posiblesFocos.add(k + 1);
	}
    }

}
