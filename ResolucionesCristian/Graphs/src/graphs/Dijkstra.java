package graphs;

/*
 * 
 * Grafo no dirigido o dirigido, ponderado si o si
 * 
 * Complejidad: O(n^2)
 * 
 * distancia cadena: dist recorrida hasta el nodo en cuestion
 * 
 * Preparacion ninguna
 * 
 * Ejecucion
 * 
 * tomo el nodo param, lo marco como visitado y tomo el nodo mas cercano, no
 * visitado y de menor costo
 * 
 * pregunto si la distancia al nodo adyacente es mejor que la distancia de
 * cadena desde mi nodo act 1) si es asi, cambio la distancia agrego el nuevo
 * nodo al vector de precedencia modifico el vector de costos 2)sino, sigo con
 * la distancia de la cadena modifico el vector precedencia con root????
 * 
 * vuelvo a tomar el nodo no visitado y mas cercano
 */

public class Dijkstra {

	int[] dist; // Distancias desde root hasta Vi
	int[] pred; // Vértices previos a Vi para llegar a la raíz

	public Dijkstra(Graph G, Integer root) {
		this.dist = G.distances(root);
		this.pred = new int[G.order];

		boolean[] visit = new boolean[G.order]; // Vertices ya visitados, inicialmente ninguno

		// Inicializo vector de predecesores y distancias
		for (int i = 0; i < G.order; i++) {
			if (G.weight(root, i) == Integer.MAX_VALUE)
				dist[i] = Integer.MAX_VALUE;
			else {
				dist[i] = G.weight(root, i);
				pred[i] = root;
			}

		}

		dist[root] = 0;
		visit[root] = true;

		int v = minDist(dist, visit);
		while (v != -1) {
			// O(N)
			visit[v] = true;
			for (int w : G.neighbours(v)) {
				// !areConnected
				if (visit[w] == false && dist[w] > G.weight(v, w) + dist[v]) {
					dist[w] = G.weight(v, w) + dist[v];
					pred[w] = v;
				}
			}

			v = minDist(dist, visit);

		}

	}

	private int minDist(int[] dist, boolean[] visit) {
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < dist.length; i++) {
			if (visit[i] == false && dist[i] < min) {
				min = dist[i];
				idx = i;
			}
		}
		return idx;
	}

	public int[] getDistances() {
		return this.dist;
	}

	public int[] getPredecessors() {
		return this.pred;
	}

}
