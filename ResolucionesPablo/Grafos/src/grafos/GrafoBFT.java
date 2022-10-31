package grafos;

import java.util.LinkedList;
import java.util.Queue;

public class GrafoBFT extends Grafo {

    public GrafoBFT(Grafo g, int raiz) {
	super(g.orden);

	Queue<Integer> q = new LinkedList<Integer>();
	boolean[] visitados = new boolean[g.orden];

	visitados[raiz] = true;
	q.add(raiz);

	while(!q.isEmpty()) {
	    int v = q.remove();
	    for(Integer w : g.sucesores(v)) {
		if(!visitados[w]) {
		    this.agregarArista(v, w, g.peso(v, w));
		    visitados[w] = true;
		    q.add(w);
		}
	    }
	}

    }

}
