package graphs;

public class UndirectedGraph extends Graph {

    private Edge[] adjacency;

    public UndirectedGraph(int order) {
	super(order);
	this.adjacency = new Edge[order];
    }

    public UndirectedGraph(Integer[][] adjacency) {
	super(adjacency);
    }

    @Override
    public void addEdge(int vi, int vf, Integer weight) {
	this.adjacency[matrixToArray(vi, vf)] = new Edge(vi, vf, weight);
    }

    @Override
    public Integer weight(int vi, int vf) {
	if(this.adjacency[matrixToArray(vi, vf)] != NO_WAY)
	    return this.adjacency[matrixToArray(vi, vf)].getWeight();
	else
	    return INFINITE;
    }

    // TODO: MAL
    private int matrixToArray(int i, int j) {
	return (order * (i - 1) - (i - 2) * (i - 1) / 2) + (j - i);
    }

}
