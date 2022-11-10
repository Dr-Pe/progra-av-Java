package graphs;

public class UndirectedGraph extends Graph {

	private Edge[][] adjacency;
	private Node[] nodes;
	
	public UndirectedGraph(int order) {
		super(order);
		this.adjacency = new Edge[order][order];
		this.nodes = new Node[order];
	}

	public UndirectedGraph(Integer[][] adjacency) {
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
	public void printNodes() {
		for(int i = 0; i < nodes.length-1; i++) {
			System.out.println(nodes[i]);
		}
	}

	public Node[] getNodes() {
		return this.nodes;
	}
	public Node getNode(int idx) {
		return this.nodes[idx];
	}
	@Override
	public void addEdge(int vi, int vf, Integer weight) {
		this.adjacency[vi][vf] = new Edge(vi, vf, weight);
		this.adjacency[vf][vi] = new Edge(vf, vi, weight);
		this.nodes[vi] = new Node(this.neighbours(vi).size(), vi);
		this.nodes[vf] = new Node(this.neighbours(vf).size(), vf);

	}
	

   @Override
    public Integer weight(int vi, int vf) {
		if(this.adjacency[vi][vf] != NO_WAY)
		    return this.adjacency[vi][vf].getWeight();
		else
		    return INFINITE;
    }


}
