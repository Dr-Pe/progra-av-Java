package graphs;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {

	protected final static Integer INFINITE = null;
	protected final static Edge NO_WAY = null;

	public final int order;

	public Graph(int order) {
		this.order = order;
	}

	public Graph(Integer[][] adjacency) {
		this.order = adjacency.length;
	}

	
	public abstract void addEdge(int vi, int vf, Integer weight);

	public abstract Integer weight(int vi, int vf);

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
	
	public List<Node> neighboursNode(Node vertex){
		List<Node> r = new ArrayList<Node>();
		for (int j = 0; j < order; j++) {
			if (this.weight(vertex.getIdx(), j) != INFINITE)
				r.add(this.getNode(j));
		}
		return r;
	}

	public Integer[] distances(int root) {
		Integer[] r = new Integer[order];
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

	@Override
	public String toString() {
		String r = "     ";
		for(int  i = 1; i <= order; i ++) {
			r+=i+"   ";	
		}
		r+="\n";
				
		for (int i = 0; i < order; i++) {
			r += i+"[ ";
			for (Integer j : this.distances(i)) {
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
