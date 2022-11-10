package test;

import java.util.Arrays;

import graphs.BFS;
import graphs.ColoreoRandom;
import graphs.DFS;
import graphs.Dijkstra;
import graphs.DirectedGraph;
import graphs.Graph;
import graphs.UndirectedGraph;
import graphs.WelshPowell;

public class Main {

    public static void main(String[] args) {

	Graph G = new UndirectedGraph(11);


	G.addEdge(1, 2, 1);
	G.addEdge(1, 3, 2);
	G.addEdge(2, 6, 3);
//	G.addEdge(3, 6, 10);
	G.addEdge(3, 4, 4);
	G.addEdge(4, 5, 5);
	G.addEdge(5, 7, 6);
	G.addEdge(6, 3, 7);
	G.addEdge(6, 7, 8);
	G.addEdge(6, 10, 14);
	G.addEdge(7, 10, 9);
	G.addEdge(7, 8, 10);
	G.addEdge(7, 9, 11);
	G.addEdge(8, 9, 12);
	G.addEdge(10, 9, 13);
	
	//WelshPowell W = new WelshPowell(G);
	//Dijkstra D = new Dijkstra(G,1);
	//System.out.println(Arrays.toString(D.getPredecessors()));
	//System.out.println(Arrays.toString(D.getDistances()));
    ColoreoRandom R = new ColoreoRandom(G);
   // System.out.println(Arrays.toString);
    }

}
