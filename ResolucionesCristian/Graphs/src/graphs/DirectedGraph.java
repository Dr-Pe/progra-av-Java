package graphs;

import java.util.ArrayList;

public class DirectedGraph extends Graph {

	private Edge[][] adjacency;
	private Node[] nodes;
	private ArrayList<Edge> edges;

	public DirectedGraph(int order) {
		super(order);
		this.adjacency = new Edge[order][order];
		this.nodes = new Node[order];
	}

	public DirectedGraph(int[][] adjacency) {
		super(adjacency);
		this.adjacency = new Edge[order][order];
		for (int i = 0; i < order; i++) {
			for (int j = 0; j < order; j++) {
				this.addEdge(i, j, adjacency[i][j]);
			}
		}
		this.nodes = new Node[order];
		for (int i = 0; i < order; i++) {
			this.nodes[i] = new Node(neighbours(i).size(), i);
		}
	}

	@Override
	public void addEdge(int vi, int vf, Integer weight) {
		this.adjacency[vi][vf] = new Edge(vi, vf, weight);
		this.nodes[vi] = new Node(this.neighbours(vi).size(), vi);
		this.edges.add(new Edge(vi, vf, weight));
	}

	@Override
	public int weight(int vi, int vf) {
		if (this.adjacency[vi][vf] != NO_WAY)
			return this.adjacency[vi][vf].getWeight();
		else
			return INFINITE;
	}

	@Override
	protected Edge getEdge(int idx, int j) {
		return adjacency[idx][j];
	}

	@Override
	public void addEdge(Edge e) {
		this.adjacency[e.getVi()][e.getVf()] = e;
		this.nodes[e.getVi()] = new Node(this.neighbours(e.getVi()).size(), e.getVi());
		this.edges.add(e);

	}
}
