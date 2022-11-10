package graphs;

public class DirectedGraph extends Graph {

    private Edge[][] adjacency;

    public DirectedGraph(int order) {
	super(order);
	this.adjacency = new Edge[order][order];
    }

    public DirectedGraph(Integer[][] adjacency) {
	super(adjacency.length);
	this.adjacency = new Edge[order][order];
	for(int i = 0; i < order; i++) {
	    for(int j = 0; j < order; j++) {
		if(adjacency[i][j] != null)
		    this.addEdge(i, j, adjacency[i][j]);
	    }
	}
    }

    @Override
    public void addEdge(int vi, int vf, int weight) {
	this.adjacency[vi][vf] = new Edge(vi, vf, weight);
    }

    @Override
    public Integer weight(int vi, int vf) {
	if(vi == vf)
	    return 0;
	else if(this.adjacency[vi][vf] != NO_WAY)
	    return this.adjacency[vi][vf].getWeight();
	else
	    return INFINITE;
    }

}
