package algorithms;

import java.util.HashSet;
import java.util.Set;

import graphs.Edge;
import graphs.UndirectedGraph;

public class Prim {

    private UndirectedGraph MST;

    public Prim(UndirectedGraph G) {
	this.MST = new UndirectedGraph(G.order);

	int root = 0;
	boolean[] visit = new boolean[G.order];
	Set<Integer> visitedSet = new HashSet<Integer>();


	visit[root] = true;
	visitedSet.add(root);
	Integer other = nearestUnvisitedVertex(G.distances(root), visit);

	while(other != null) {
	    Edge min = new Edge(root, other, G.weight(root, other));
	    for(Integer vx : visitedSet) {
		Integer wx = nearestUnvisitedVertex(G.distances(vx), visit);
		if(wx != null) {
		    Edge alt = new Edge(vx, wx, G.weight(vx, wx));
		    if(alt.getWeight() < min.getWeight())
			min = alt;
		}
	    }
	    visit[min.getVf()] = true;
	    visitedSet.add(min.getVf());
	    MST.addEdge(min);
	    other = nearestUnvisitedVertex(G.distances(root), visit);
	}
    }

    public UndirectedGraph getMST() {
	return this.MST;
    }

    private Integer nearestUnvisitedVertex(Integer[] adj, boolean[] vis) {
	/*
	 * Devuelve el indice del nodo con menor distancia que aún no haya sido
	 * visitado, null si todos fueron visitados. O(N)
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
