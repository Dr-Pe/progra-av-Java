package algorithms;

import graphs.Graph;

public class Dijkstra {
    /*
     * Clase auxiliar a Graph para calcular (y almacenar) las distancias y caminos a cada vértice
     * desde el vértice inicial o 'root'.
     */

    Integer[] dist; // Distancias desde root hasta Vi
    Integer[] pred; // Vértices previos a Vi para llegar a la raíz


    // TODO: Implementar con ColaDePrioridad
    public Dijkstra(Graph G, int root) {
	this.dist = G.distances(root);
	this.pred = new Integer[G.order];

	// Inicializo vector de predecesores
	for(int j = 0; j < G.order; j++) {
	    if(dist[j] != null)
		pred[j] = root;
	}

	boolean[] visit = new boolean[G.order]; // Vertices ya visitados, inicialmente ninguno

//	dist[root] = 0;
	pred[root] = root;
	visit[root] = true;

	Integer vx = nearestUnvisitedVertex(dist, visit);
	while(vx != null) {
	    visit[vx] = true;
	    for(Integer wx : G.neighbours(vx)) {
		if((!G.areConnected(root, wx) && wx != root && vx != wx)
					|| G.weight(vx, wx) + dist[vx] < dist[wx]) {
		    dist[wx] = G.weight(vx, wx) + dist[vx];
		    pred[wx] = vx;
		}
		else if(G.areConnected(root, wx)) {
		    pred[wx] = root;
		}
	    }
	    vx = nearestUnvisitedVertex(dist, visit); // O(V)
	}

    }

    public Integer[] distances() {
	return this.dist;
    }

    public Integer[] predecessors() {
	return this.pred;
    }

    private Integer nearestUnvisitedVertex(Integer[] adj, boolean[] vis) {
	/*
	 * Devuelve el indice del nodo con menor distancia que aún no haya sido
	 * visitado, null si todos fueron visitados. O(V)
	 */

	Integer idx = null;
	for(int i = 0; i < adj.length; i++) {
	    if(adj[i] != null && !vis[i]) {
		idx = i;
		break;
	    }
	}
	if(idx == null)
	    return null;
	for(int i = idx; i < adj.length; i++) {
	    if(adj[i] != null && adj[i] < adj[idx] && !vis[i])
		idx = i;
	}
	return idx;
    }

}
