package graphs;

import java.util.Arrays;

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
	Edge n = null;
	// By default I add undirected edges as if they were directed from smallest to largest
	// vertex
	if(vi <= vf)
	    n = new Edge(vi, vf, weight);
	else
	    n = new Edge(vf, vi, weight);
	this.adjacency[rowMajorMap(vi, vf)] = n;
    }

    @Override
    public Integer weight(int vi, int vf) {
	if(vi == vf)
	    return 0;
	else if(this.adjacency[rowMajorMap(vi, vf)] != NO_WAY)
	    return this.adjacency[rowMajorMap(vi, vf)].getWeight();
	else
	    return INFINITE;
    }

    @Override
    public boolean equals(Object obj) {
	if(this == obj)
	    return true;
	if(obj == null)
	    return false;
	if(getClass() != obj.getClass())
	    return false;
	UndirectedGraph other = (UndirectedGraph) obj;
	return Arrays.equals(adjacency, other.adjacency);
    }

    private int rowMajorMap(int i, int j) {
	if(i <= j)
	    return (i * order - (i - 1) * i / 2) + (j - i);
	else
	    return (j * order - (j - 1) * j / 2) + (i - j);
    }

}
