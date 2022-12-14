package graphs;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {

	protected final static Integer INFINITE = Integer.MAX_VALUE;
	protected final static Edge NO_WAY = null;

	public final int order;

	public Graph(int order) {
		this.order = order;
	}

	public Graph(int[][] adjacency) {
		this.order = adjacency.length;
	}

	public abstract void addEdge(int vi, int vf, Integer weight);

	public abstract void addEdge(Edge e);

	public abstract int weight(int vi, int vf);

	public boolean areConnected(int vi, int vf) {
		return this.weight(vi, vf) != INFINITE;
	}

	public List<Integer> neighbours(int vertex) {
		List<Integer> r = new ArrayList<Integer>();
		for (int j = 0; j < order; j++) {
			if (this.weight(vertex, j) != INFINITE)
				r.add(j);
		}
		return r;
	}

	public List<Node> neighboursNode(Node vertex) {
		List<Node> r = new ArrayList<Node>();
		for (int j = 0; j < order; j++) {
			if (this.weight(vertex.getIdx(), j) != INFINITE)
				r.add(this.getNode(j));
		}
		return r;
	}

	public List<Edge> neighboursEdge(int vertex) {
		List<Edge> r = new ArrayList<Edge>();
		for (int j = 0; j < order; j++) {
			if (this.weight(vertex, j) != INFINITE)
				r.add(this.getEdge(vertex, j));
		}
		return r;
	}

	protected abstract Edge getEdge(int idx, int j);

	public int[] distances(int root) {
		int[] r = new int[order];
		for (int j = 0; j < order; j++)
			r[j] = this.weight(root, j);
		return r;
	}

	public void printNodes() {

	}

	public Node[] getNodes() {
		return null;

	}

	public Node getNode(int idx) {
		return null;

	}

	public ArrayList<Edge> getEdges() {
		return null;
	}

	@Override
	public String toString() {
		String r = "     ";
		for (int i = 0; i < order; i++) {
			r += i + "   ";
		}
		r += "\n";

		for (int i = 0; i < order; i++) {
			r += i + "[ ";
			for (int j : this.distances(i)) {
				if (j == INFINITE)
					r += "inf ";
				else
					r += String.format("%3d ", j);
			}
			r += "]\n";
		}
		return r;
	}

}
