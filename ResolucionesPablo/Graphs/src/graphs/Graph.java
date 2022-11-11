package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public abstract class Graph {

    protected final static Integer INFINITE = null;
    protected final static Edge NO_WAY = null;

    public final int order;

    public Graph(int order) {
	this.order = order;
    }

    public abstract void addEdge(int vi, int vf, int weight);

    public abstract Integer weight(int vi, int vf);

    @Override
    public abstract boolean equals(Object o);

    public void addEdge(Edge e) {
	this.addEdge(e.getVi(), e.getVf(), e.getWeight());
    }

    public boolean areConnected(int vi, int vf) {
	return this.weight(vi, vf) != INFINITE;
    }

    public List<Integer> neighbours(int vertex) {
	List<Integer> r = new ArrayList<Integer>();
	for(int j = 0; j < order; j++) {
	    if(this.weight(vertex, j) != INFINITE)
		r.add(j);
	}
	return r;
    }

    public Integer[] distances(int root) {
	Integer[] r = new Integer[order];
	for(int j = 0; j < order; j++)
	    r[j] = this.weight(root, j);
	return r;
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < order; i++) {
	    r += "[ ";
	    for(Integer j : this.distances(i)) {
		if(j == INFINITE)
		    r += "inf ";
		else
		    r += String.format("%3d ", j);
	    }
	    r += "]\n";
	}
	return r;
    }

    public Integer[] BFS(int root) {
	List<Integer> r = new ArrayList<Integer>();
	Queue<Integer> S = new ArrayDeque<Integer>();
	boolean[] visited = new boolean[order];

	S.add(root);
	while(!S.isEmpty()) {
	    int vx = S.remove();
	    if(!visited[vx]) {
		r.add(vx);
		visited[vx] = true;
		for(Integer wx : neighbours(vx))
		    S.add(wx);
	    }
	}

	return r.toArray(new Integer[0]);
    }

    public Integer[] DFS(int root) {
	List<Integer> r = new ArrayList<Integer>();
	Deque<Integer> S = new ArrayDeque<Integer>();
	boolean[] visited = new boolean[order];

	S.push(root);
	while(!S.isEmpty()) {
	    int vx = S.pop();
	    if(!visited[vx]) {
		r.add(vx);
		visited[vx] = true;
		for(Integer wx : neighbours(vx))
		    S.push(wx);
	    }
	}

	return r.toArray(new Integer[0]);
    }

}
