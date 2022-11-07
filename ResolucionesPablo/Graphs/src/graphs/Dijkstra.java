package graphs;

public class Dijkstra {
    /*
     * Clase auxiliar a Graph para calcular (y almacenar) las distancias y caminos a cada vértice
     * desde el vértice inicial o 'root'.
     */

    Integer[] dist; // Distancias desde root hasta Vi
    Integer[] prev; // Vértices previos a Vi para llegar a la raíz


    // TODO: Implementar con ColaDePrioridad
    public Dijkstra(Graph G, Integer root) {
	this.dist = G.adjacents(root);
	this.prev = new Integer[G.order()];

	boolean[] visit = new boolean[G.order()]; // Vertices ya visitados

	dist[root] = 0;
	prev[root] = root;
	visit[root] = true;

	Integer vx = nearestUnvisitedVertex(dist, visit);
	while(vx != null) {
	    visit[vx] = true;

	}

    }

    private Integer nearestUnvisitedVertex(Integer[] adj, boolean[] vis) {
	/*
	 * Devuelve el indice del nodo con menor distancia que aún no haya sido
	 * visitado, null si todos fueron visitados. O(N)
	 */

	Integer idx = null;
	for(int i = 0; i < adj.length; i++) {
	    if(adj[i] != null) {
		idx = i;
		break;
	    }
	}
	if(idx == null)
	    return null;
	for(int i = idx; i < adj.length; i++) {
	    if(adj[i] != null && adj[i] < adj[idx])
		idx = i;
	}
	return idx;
    }

}
