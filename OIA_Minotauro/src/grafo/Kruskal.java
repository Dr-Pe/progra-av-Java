package grafo;

import java.util.PriorityQueue;

public class Kruskal {

    private Grafo MST;

    public Kruskal(Grafo G) {
	MST = new Grafo(G.orden);

	PriorityQueue<Arista> pq = new PriorityQueue<Arista>();
	UnionFind uf = new UnionFind(G.orden);

	for(Arista ar : G.getAristas())
	    pq.add(ar);

	while(!pq.isEmpty()) {
	    Arista aux = pq.remove();
	    if(!uf.mismoSet(aux.getVi(), aux.getVf())) {
		uf.unir(aux.getVi(), aux.getVf());
		MST.agregarArista(aux.getVi(), aux.getVf(), aux.getPeso());
	    }
	}
    }

    public Grafo getMST() {
	return MST;
    }

}
