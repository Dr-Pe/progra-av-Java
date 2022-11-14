import java.util.ArrayList;
import java.util.List;

public class Resolucion {

	// IN
	private Grafo g;
	private int nIni;
	private int nFin;
	private List<Integer[]> calles;

	// OUT
	private int distancia;
	private List<Integer> callesACambiar;

	public static void main(String[] args) {
		
		Resolucion r = new Resolucion("archivos/casos_de_prueba/caso06 – 1000x2300.in");
		r.resolver();
		r.grabarArchivo("archivos/casos_de_prueba/caso06 – 1000x23003.out");
		
	}

	private Resolucion(String in) {
		Archivo ar = new Archivo(in);
		ar.leerArchivo();

		this.g = ar.getG();
		this.nIni = ar.getNI();
		this.nFin = ar.getNF();
		this.calles = ar.getCalles();

		this.callesACambiar = new ArrayList<Integer>();
	}

	private void resolver() {
		Dijkstra dij = new Dijkstra(this.g, nIni);

		this.distancia = dij.getDistancias()[nFin];

		Integer[] camino = camino(dij.getPrecedencias());

		for (int i = 0; i < camino.length - 1; i++) {
			for (Integer[] calle : calles) {
				if (calle[0] == camino[i] && calle[1] == camino[i + 1])
					callesACambiar.add(calles.indexOf(calle) + 1);
			}
		}

	}

	private void grabarArchivo(String name) {
		Archivo ar = new Archivo(name);
		ar.escribirArchivo(distancia, callesACambiar);

	}

	private Integer[] camino(int[] prec) {
		List<Integer> r = new ArrayList<Integer>();
		int vx = nFin;
		while (vx != nIni) {
			r.add(vx);
			vx = prec[vx];
		}
		r.add(vx);
		return r.toArray(new Integer[0]);
	}

}
