package grafos;

public class Main {

    public static void main(String[] args) {

	Integer[][] mat = new Integer[][] { { null, 7, 3, null }, { null, null, null, 2 },
		{ null, 2, null, 8 }, { null, null, null, null } };
	Grafo g = new Grafo(mat);

	System.out.println("Distancias entre nodos:\n"
				+ Grafo.matrizToString(g.distancias()));
	g.floydWarshall();
	System.out.println("Distancias luego de aplicar Floyd-Warshall:\n"
				+ Grafo.matrizToString(g.distancias()));
    }
}
