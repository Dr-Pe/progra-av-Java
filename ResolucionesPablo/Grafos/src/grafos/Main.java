package grafos;

public class Main {

    public static void main(String[] args) {

	Integer[][] mat = new Integer[][] { { null, 7, 3, null }, { null, null, null, 2 },
		{ null, 2, null, 8 }, { null, null, null, null } };
	Grafo g = new Grafo(mat);

	System.out.println("\nCaminos pre-FloydWarshall\n\n" + g.caminoToString());
	g.floydWarshall();
	System.out.println("Caminos pos-FloydWarshall\n\n" + g.caminoToString());

	g.agregarArista(0, 2, 1);

	g.floydWarshall();
	System.out.println("Caminos pos-FloydWarshall\n\n" + g.caminoToString());
    }
}
