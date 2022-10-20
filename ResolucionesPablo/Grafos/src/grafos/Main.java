package grafos;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

	int[][] mat = new int[][] { { -1, 7, 3, -1 }, { -1, -1, -1, 2 }, { -1, 2, -1, 8 },
		{ -1, -1, -1, -1 } };
	Grafo g = new Grafo(mat);

	System.out.println(g);

	System.out.println("D = " + Arrays.toString(g.dijkstra(0)[0]));
	System.out.println("P = " + Arrays.toString(g.dijkstra(0)[1]));
    }
}
