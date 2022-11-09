package graphs;

public class UndirectedGraph extends Graph {

    private Edge[] adjacency;

    public UndirectedGraph(int order) {
	super(order);
	this.adjacency = new Edge[order * (order + 1) / 2];
    }

    public UndirectedGraph(Integer[][] adjacency) {
	super(adjacency);
    }

    @Override
    public void addEdge(int vi, int vf, Integer weight) {
	this.adjacency[rowMajorMap(vi, vf)] = new Edge(vi, vf, weight);
    }

    @Override
    public Integer weight(int vi, int vf) {
	if(this.adjacency[rowMajorMap(vi, vf)] != NO_WAY)
	    return this.adjacency[rowMajorMap(vi, vf)].getWeight();
	else
	    return INFINITE;
    }

    // TODO: MAL
    private int rowMajorMap(int i, int j) {
	return (i * order - (i - 1) * i / 2) + (j - i);
    }

}
