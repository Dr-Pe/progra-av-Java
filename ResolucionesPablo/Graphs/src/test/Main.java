package test;

import java.util.Arrays;

import graphs.Graph;
import graphs.UndirectedGraph;

public class Main {

    public static void main(String[] args) {

	Graph G = new UndirectedGraph(4);

	G.addEdge(0, 1, 7);
	G.addEdge(0, 2, 3);
	G.addEdge(1, 2, 2);
	G.addEdge(1, 3, 2);
	G.addEdge(2, 3, 8);

	System.out.println(G);

	System.out.println(Arrays.toString(G.BFS(0)));

    }

}
