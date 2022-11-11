package test;

import java.util.Arrays;

import graphs.BFS;
import graphs.ColoreoRandom;
import graphs.DFS;
import graphs.Dijkstra;
import graphs.DirectedGraph;
import graphs.Floyd;
import graphs.Graph;
import graphs.Kruskal;
import graphs.Prim;
import graphs.UndirectedGraph;
import graphs.WelshPowell;

public class Main {

    public static void main(String[] args) {

		Graph G = new UndirectedGraph(7);
	
	
	//	G.addEdge(0, 2, 3);
	//	G.addEdge(0, 1, 7);
	//	G.addEdge(2, 1, 2);
	//	G.addEdge(1, 3, 2);
	//	G.addEdge(2, 3, 8);
		G.addEdge(0, 1, 4);
		G.addEdge(0, 2, 2);
		G.addEdge(0, 6, 5);
		G.addEdge(1, 3, 2);
		G.addEdge(1, 2, 1);
		G.addEdge(2, 3, 3);
		G.addEdge(2, 6, 8);
		G.addEdge(2, 5, 4);
		G.addEdge(6, 5, 1);
		G.addEdge(5, 4, 6);
		G.addEdge(2, 4, 7);
		G.addEdge(3, 4, 10);
		//WelshPowell W = new WelshPowell(G);
		/*Dijkstra D = new Dijkstra(G,3);
		System.out.println(Arrays.toString(D.getPredecessors()));
		System.out.println(Arrays.toString(D.getDistances()));*/
	    //ColoreoRandom R = new ColoreoRandom(G);
	    // System.out.println(Arrays.toString);
	    Kruskal K = new Kruskal(G);
	    //System.out.println(G);
	    System.out.println(K.getMST());
	    Prim P = new Prim(G);
	    System.out.println(P.getMST());
		/*Floyd F = new Floyd(G);
		System.out.println(G);
		System.out.println(F.distances());
		*/
	    
    }

}
