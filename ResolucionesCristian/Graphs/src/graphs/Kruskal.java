package graphs;

import java.util.PriorityQueue;

/*
 * 
 * Grafo no dirigido
 * 
 * Complejidad: O(A*(log(A)+log(N))) 	; se supone que es O(A*log(N)). 
 * 
 * Preparacion:
 * -PriorityQueue de aristas con orden menor a mayor
 * -ComparteTo en clase Edge (para agregar aristas a la queue)
 * 
 * -UnionFind
 * 
 * Ejecucion
 * 
 * arranco de la arista de menor peso
 * verifico que sus nodos extremos no cierren ciclo (pertenezcan al mismo set)
 * si no cierran, union de extremos + agregar al MST
 * caso contrario continuar
 * iterar hasta que no hayan mas aristas (PQ vacia)
 * 
 * 
 */
public class Kruskal {
	private Graph MST;
	private int pesoT;

	public Kruskal(Graph g) {
		this.MST = new UndirectedGraph(g.order);

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

		for (Edge e : g.getEdges()) {
			pq.add(e);
		}

		this.pesoT = 0;
		UnionFind unionF = new UnionFind(g.order);
		Edge e;
		// int i = 0;
		// int f = pq.size()-1;
		while (!pq.isEmpty()) {					//O(A)
			e = pq.remove();						//O(logA)
			int vi = e.getVi();
			int vf = e.getVf();
			if (!unionF.mismoSet(vi, vf)) {			//O(1)
				pesoT += e.getWeight();
				MST.addEdge(vi, vf, e.getWeight());
				unionF.unir(vi, vf);				//O(logN)
			}
			// Si++;

		}

	}

	public int getPesoT() {
		return this.pesoT;
	}

	public Graph getMST() {
		return this.MST;
	}
}
