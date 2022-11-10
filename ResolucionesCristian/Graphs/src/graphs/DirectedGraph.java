package graphs;

public class DirectedGraph extends Graph {

    private Edge[][] adjacency;
	private Node[] nodes;
	
    public DirectedGraph(int order) {
    	super(order);
    	this.adjacency = new Edge[order][order];
    	this.nodes = new Node[order];
    }

    public DirectedGraph(Integer[][] adjacency) {
		super(adjacency);
		this.adjacency = new Edge[order][order];
		for(int i = 0; i < order; i++) {
		    for(int j = 0; j < order; j++) {
				if(adjacency[i][j] != null)
				    this.addEdge(i, j, adjacency[i][j]);
		    }
		}
		this.nodes = new Node[order];
		for(int i = 0; i < order; i++) {
			this.nodes[i] = new Node(neighbours(i).size(), i);
		}
    }

    @Override
    public void addEdge(int vi, int vf, Integer weight) {
    	this.adjacency[vi][vf] = new Edge(vi, vf, weight);
    }
    public void addNode(int idx, int g) {
    
    }

    @Override
    public Integer weight(int vi, int vf) {
		if(this.adjacency[vi][vf] != NO_WAY)
		    return this.adjacency[vi][vf].getWeight();
		else
		    return INFINITE;
    }

}
