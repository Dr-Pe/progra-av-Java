import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Resolucion {

	private List<Vertice> vertices;
	private Grafo G;

	public static void main(String[] args) {

		Resolucion r = new Resolucion("archivos/caso4.in", "archivos/tarzan.out");
		
		System.out.println("");

	}

	public Resolucion(String pathIn, String pathOut) {
		this.vertices = new ArrayList<Vertice>();
		leerArchivo(pathIn);
		crearGrafo();
		resolver();
	}

	private void resolver() {
//	this.camino = G.busquedaBasadaEnBFS(0, vertices.size() - 1);
		ArrayList<Integer> datos = new ArrayList<Integer>();
		
		for(int i = 0; i < G.Dijkstra(0).length; i++) {
			System.out.print(String.format("%3d", i));
		}
		System.out.println();
		System.out.println(Arrays.toString(G.Dijkstra(0)));
	}

	private void crearGrafo() {
		this.G = new Grafo(vertices);
		System.out.println(G);
	}

	private void leerArchivo(String p) {
		File fp = null;
		Scanner sc = null;

		try {
			fp = new File(p);
			sc = new Scanner(fp);

			int i = 0;
			while (sc.hasNextInt()) {
				Vertice vx = new Vertice(i, sc.nextInt(), sc.nextInt());
				this.vertices.add(vx);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}

}