package algorithms;

import java.util.HashSet;
import java.util.Set;

import graphs.Edge;
import graphs.UndirectedGraph;

public class Prim extends MinimumSpanningTreeAlgorithm {

    public Prim(UndirectedGraph G) {
	super(G); // Creates an empy MST Graph the same size as G

	Set<Integer> visited = new HashSet<Integer>(); // This class offers constant time
						       // performance for the basic operations
						       // (add, remove, contains and size)

	visited.add(0); // Se elige como vertice inicial el 0 arbitrariamente

	while(visited.size() < G.order) {
	    Edge min = null;
	    for(Integer vx : visited) {
		Integer wx = nearestUnvisitedVertex(G.distances(vx), visited); // O(V)
		if(wx != null) {
		    Edge alt = new Edge(vx, wx, G.weight(vx, wx));
		    if(min == null || alt.getWeight() < min.getWeight())
			min = alt;
		} // O(V^2)
	    } // O(V^3)
	    visited.add(min.getVf());
	    super.addEdge(min); // Adds the new Edge to the MST an also adds its weight to the total
	}
    }

    private Integer nearestUnvisitedVertex(Integer[] adj, Set<Integer> vis) {
	/*
	 * Devuelve el indice del nodo con menor distancia que aún no haya sido
	 * visitado, null si todos fueron visitados. O(V)
	 */

	Integer idx = null;
	for(int i = 0; i < adj.length; i++) {
	    if(adj[i] != null && !vis.contains(i)) {
		idx = i;
		break;
	    }
	}
	if(idx == null)
	    return null;
	for(int i = idx; i < adj.length; i++) {
	    if(adj[i] != null && adj[i] < adj[idx] && !vis.contains(i))
		idx = i;
	}
	return idx;
    }

}
