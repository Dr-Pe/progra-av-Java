package graphs;

public class Graph {

    protected final static Edge INF = null;

    private int order;
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

    public void addEdge(int i, int j, Integer weight) {
	this.adjacency[i][j] = new Edge(i, j, weight);
    }

    public int order() {
	return this.order;
    }

    public int weight(int vi, int vf) {
	return this.adjacency[vi][vf].getWeight();
    }

    public Integer[] adjacents(Integer root) {
	Integer[] r = new Integer[this.order];
	for(int j = 0; j < order; j++) {
	    if(this.adjacency[root][j] != INF)
		r[j] = this.weight(root, j);
	    else
		r[j] = null;
	}
	return r;
    }

}
