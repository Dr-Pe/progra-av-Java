package test;

import java.util.Arrays;

import graphs.Dijkstra;
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

	Dijkstra D = new Dijkstra(G, 0);

	System.out.println(Arrays.toString(D.getDistances()));
	System.out.println(Arrays.toString(D.getPredecessors()));

    }

}
