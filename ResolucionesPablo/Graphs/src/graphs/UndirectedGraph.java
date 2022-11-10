package graphs;

public class UndirectedGraph extends Graph {

    private Edge[] adjacency;

    public UndirectedGraph(int order) {
	super(order);
	this.adjacency = new Edge[order * (order + 1) / 2];
    }

    public UndirectedGraph(Integer[][] adjacency) {
	super(adjacency.length);
	this.adjacency = new Edge[order * (order + 1) / 2];
	for(int i = 0; i < order; i++) {
	    for(int j = i; j < order; j++) {
		if(adjacency[i][j] != null)
		    this.addEdge(i, j, adjacency[i][j]);
	    }
	}
    }

    @Override
    public void addEdge(int vi, int vf, int weight) {
	this.adjacency[rowMajorMap(vi, vf)] = new Edge(vi, vf, weight);
    }

    @Override
    public Integer weight(int vi, int vf) {
	if(vi == vf)
	    return 0;
	else if(vi <= vf && this.adjacency[rowMajorMap(vi, vf)] != NO_WAY)
	    return this.adjacency[rowMajorMap(vi, vf)].getWeight();
	else if(vi >= vf && this.adjacency[rowMajorMap(vf, vi)] != NO_WAY)
	    return this.adjacency[rowMajorMap(vf, vi)].getWeight();
	else
	    return INFINITE;
    }

    private int rowMajorMap(int i, int j) {
	return (i * order - (i - 1) * i / 2) + (j - i);
    }

}
