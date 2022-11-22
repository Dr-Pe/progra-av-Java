package grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
	private Grafo MST;
	private int costoT;
	private List<Arista> sobra;

	public Kruskal(Grafo g) {
		sobra = new ArrayList<Arista>();
		MST = new Grafo(g.orden);
		UnionFind uf = new UnionFind(g.orden);
		costoT = 0;
		PriorityQueue<Arista> pq = new PriorityQueue<Arista>();
		for (Arista a : g.getAristas()) {
			pq.add(a);
		}
		ArrayList<Arista> sobra = new ArrayList<Arista>();

		while (!pq.isEmpty()) {
			Arista ar = pq.remove();

			if (!uf.mismoSet(ar.getNi(), ar.getNf())) {
				uf.union(ar.getNi(), ar.getNf());
				MST.agregarArista(ar.getNi(), ar.getNf(), ar.getPeso());
				costoT += ar.getPeso();
			}
			sobra.add(ar);
		}

	}

	public Grafo getMST() {
		return this.MST;
	}

	public List<Arista> getSobra() {
		return this.sobra;
	}

	public int getCostoT() {
		return this.costoT;
	}

}
