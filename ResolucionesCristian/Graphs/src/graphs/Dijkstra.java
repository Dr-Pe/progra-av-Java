package graphs;

public class Dijkstra {
	/*
	 * 
	 * Grafo no dirigido o dirigido
	 * Complejidad  O(n^2)
	 * 
	 * distancia cadena: dist recorrida hasta el nodo en cuestion
	 * 
	 * 	Preparacion
	 * ninguna
	 * 
	 *  Ejecucion
	 * 
	 * tomo el nodo param, lo marco como visitado y tomo el nodo mas cercano, no visitado y de menor costo
	 * 
	 * pregunto si la distancia al nodo adyacente es mejor que la distancia de cadena desde mi nodo act
	 * 1) si es asi, cambio la distancia
	 * 	 agrego el nuevo nodo al vector de precedencia
	 * 	 modifico el vector de costos
	 * 2)sino, sigo con la distancia de la cadena
	 * 	 modifico el vector precedencia con root????
	 * 
	 * vuelvo a tomar el nodo no visitado y mas cercano
	 */

	Integer[] dist; // Distancias desde root hasta Vi
	Integer[] pred; // Vértices previos a Vi para llegar a la raíz


	public Dijkstra(Graph G, Integer root) {
		this.dist = G.distances(root);
		this.pred = new Integer[G.order];

		// Inicializo vector de predecesores
		for (int j = 0; j < G.order; j++) {
			if (dist[j] != null)
				pred[j] = root;
		}

		boolean[] visit = new boolean[G.order]; // Vertices ya visitados, inicialmente ninguno

		dist[root] = 0;
		pred[root] = root;
		visit[root] = true;

		Integer vx = nearestUnvisitedVertex(dist, visit);
		while (vx != null) {
			visit[vx] = true;
			for (Integer wx : G.neighbours(vx)) {
				//!areConnected 
				if ((!G.areConnected(root, wx) && wx != root) || G.weight(vx, wx) + dist[vx] < dist[wx]) {
					dist[wx] = G.weight(vx, wx) + dist[vx];
					pred[wx] = vx;
				} else if (G.areConnected(root, wx)) {
					pred[wx] = root;
				}
			}
			vx = nearestUnvisitedVertex(dist, visit); // O(N)
		}

	}

	public Integer[] getDistances() {
		return this.dist;
	}

	public Integer[] getPredecessors() {
		return this.pred;
	}

	private Integer nearestUnvisitedVertex(Integer[] adj, boolean[] vis) {
		/*
		 * Devuelve el indice del nodo con menor distancia que aún no haya sido
		 * visitado, null si todos fueron visitados. O(N)
		 */

		Integer idx = null;
		for (int i = 0; i < adj.length; i++) {
			if (adj[i] != null && !vis[i]) {
				idx = i;
				break;
			}
		}
		if (idx == null)
			return null;
		for (int i = idx; i < adj.length; i++) {
			if (adj[i] != null && adj[i] < adj[idx] && !vis[i])
				idx = i;
		}
		return idx;
	}

}
