package graphs;

import java.util.ArrayList;
import java.util.List;

// TODO: abstract
public class Graph {

    protected final static Integer INFINITE = null;
    protected final static Edge NO_WAY = null;

    public final int order;
    private Edge[][] adjacency;

    public Graph(int order) {
	this.order = order;
	this.adjacency = new Edge[order][order];
    }

    public Graph(Integer[][] adjacency) {
	this.order = adjacency.length;
	this.adjacency = new Edge[order][order];
	for(int i = 0; i < order; i++) {
	    for(int j = 0; j < order; j++) {
		if(adjacency[i][j] != null)
		    this.addEdge(i, j, adjacency[i][j]);
	    }
	}
    }

    public void addEdge(int vi, int vf, Integer weight) {
	this.adjacency[vi][vf] = new Edge(vi, vf, weight);
    }

    public Integer weight(int vi, int vf) {
	if(this.adjacency[vi][vf] != NO_WAY)
	    return this.adjacency[vi][vf].getWeight();
	else
	    return INFINITE;
    }

    public boolean areConnected(int vi, int vf) {
	return this.weight(vi, vf) != INFINITE;
    }

    public List<Integer> neighbours(int vertex) {
	List<Integer> r = new ArrayList<Integer>();
	for(int j = 0; j < order; j++) {
	    if(this.weight(vertex, j) != INFINITE)
		r.add(j);
	}
	return r;
    }

    public Integer[] distances(int root) {
	Integer[] r = new Integer[order];
	for(int j = 0; j < order; j++)
	    r[j] = this.weight(root, j);
	return r;
    }

}
