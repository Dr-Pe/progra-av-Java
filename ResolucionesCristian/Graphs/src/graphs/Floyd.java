package graphs;

/*
 * 
 * sirve para todo tipo de grafo
 * 
 * Complejidad: O(n^3)
 * 
 * 
 * Preparacion
 * 
 * 
 * Ejecucion
 * 
 * marco una fila y columna K
 * pregunto si la distancia act I,J es mayor a la interseccion entre mi i->K+ K->j
 * si es asi, reemplazo por la distancia con K
 * 
 * vuelvo a tomar el nodo no visitado y mas cercano
 */




public class Floyd {
	private int[][] dist;

	public Floyd(Graph G) {
		this.dist = new int[G.order][G.order];

		for (int i = 0; i < G.order; i++)
			dist[i] = G.distances(i);

		for (int k = 0; k < G.order; k++) {
			for (int i = 0; i < G.order; i++) {
				for (int j = 0; j < G.order; j++) {
					if (G.areConnected(i, k) && G.areConnected(k, j)) {
						if (!G.areConnected(i, j) || dist[i][k] + dist[k][j] < dist[i][j])
							dist[i][j] = dist[i][k] + dist[k][j];

					}
				}
			}
		}
	}

	public Graph distances() {
		Graph g = new DirectedGraph(this.dist);
		return g;
	}
}
