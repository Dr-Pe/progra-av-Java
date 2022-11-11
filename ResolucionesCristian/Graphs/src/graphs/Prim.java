package graphs;

import java.util.List;
import java.util.PriorityQueue;

/*
 * 
 * Grafo no dirigido
 * 
 * Complejidad: O(N*log(A) 	; porque uso pq para tomar arista. 
 * 
 * Preparacion:
 * PriorityQueue de aristas con orden menor a mayor
 * ComparteTo en clase Edge (para agregar aristas a la queue)
 * vector visitados.
 * 
 * Ejecucion
 * 
 * arranco de un nodo cualquiera (tomo siempre el 0)
 * agrego sus aristas a la PQ
 * agarro la arista A de menor peso (PQ.remove)
 * y la agrego al MST, y la marco como visitado
 * ademas de visitado, agrego las aristas adyacentes al nodo final vinculado a la arista A
 * 
 * repito para todas las aristas.
 * 
 * 
 */

public class Prim {

	private Graph MST;
	private int pesoT;

	public Prim(Graph g) {
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		this.MST = new UndirectedGraph(g.order);

		/*
		 * for(Edge e : g.getEdges()) { pq.add(e); }
		 */

		boolean[] visit = new boolean[g.order];
		visit[0] = true;

		addEdgeAdy(pq, g.neighboursEdge(0), visit);

		int i = 0;
		while (!pq.isEmpty() && i < g.order) {// O(n)

			Edge e = pq.remove();	//O (log A)

			if (!visit[e.getVf()]) {
				visit[e.getVf()] = true;
				pesoT += e.getWeight();
				MST.addEdge(e);
				addEdgeAdy(pq, g.neighboursEdge(e.getVf()), visit);
				i++;
			}
		}

	}

	public void addEdgeAdy(PriorityQueue<Edge> pq, List<Edge> edges, boolean[] visit) {
		for (Edge e : edges) {
			if (visit[e.getVf()] == false)
				pq.add(e);
		}

	}

	public int getPesoT() {
		return this.pesoT;
	}

	public Graph getMST() {
		return this.MST;
	}
}
