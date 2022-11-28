package algorithms;

import graphs.Edge;
import graphs.UndirectedGraph;

public abstract class MinimumSpanningTreeAlgorithm {

    protected UndirectedGraph MST;
    protected int totalWeight;

    protected MinimumSpanningTreeAlgorithm(UndirectedGraph G) {
	this.MST = new UndirectedGraph(G.order);
	this.totalWeight = 0;
    }

    public void addEdge(Edge e) {
	this.MST.addEdge(e);
	this.totalWeight += e.getWeight();
    }

    public UndirectedGraph getMST() {
	return this.MST;
    }

    public int getTotalWeight() {
	return this.totalWeight;
    }

}
