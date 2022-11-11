package test;

import algorithms.Prim;
import graphs.Graph;
import graphs.UndirectedGraph;

public class Main {

    public static void main(String[] args) {

	Graph G0 = new UndirectedGraph(4);

	G0.addEdge(0, 1, 7);
	G0.addEdge(0, 2, 3);
	G0.addEdge(1, 2, 2);
	G0.addEdge(1, 3, 2);
	G0.addEdge(2, 3, 8);

	Prim pr = new Prim((UndirectedGraph) G0);

	Graph MST0 = pr.getMST();

	System.out.println(MST0);

//	FloydWarshall fw = new FloydWarshall(G0);
//
//	System.out.println(Arrays.toString(fw.distances()[0]));
//	System.out.println(Arrays.toString(fw.distances()[1]));
//	System.out.println(Arrays.toString(fw.distances()[2]));
//	System.out.println(Arrays.toString(fw.distances()[3]));
//
//	Graph G1 = new UndirectedGraph(7);
//
//	G1.addEdge(0, 1, 1);
//	G1.addEdge(0, 2, 1);
//	G1.addEdge(1, 2, 1);
//	G1.addEdge(2, 3, 1);
//	G1.addEdge(3, 4, 1);
//	G1.addEdge(3, 5, 1);
//	G1.addEdge(3, 6, 1);

//	System.out.println(G1);
//	WelshPowell wp = new WelshPowell(G1);
//	System.out.println(Arrays.toString(wp.getColors().values().toArray()));

    }

}
