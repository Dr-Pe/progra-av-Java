import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private final static int MAX_PESO = 50;
	private final static int INF = MAX_PESO + 1;

	public final double orden;
	private int[][] ady;

	public Grafo(int orden) {
		this.orden = orden;
		this.ady = new int[orden][orden];
		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++)
				ady[i][j] = INF;
			ady[i][i] = 0;
		}
	}

	public void agregarArista(int ni, int nf, int p) {
		this.ady[ni][nf] = p;
		this.ady[nf][ni] = p;
	}

	public int peso(int ni, int nf) {
		return this.ady[ni][nf];
	}

	public List<Integer> vecinos(int raiz) {
		List<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < orden; i++) {
			if (ady[raiz][i] != INF)
				r.add(i);
		}
		return r;
	}

	public int[] distancias(int raiz) {
		return this.ady[raiz];
	}

	@Override
	public String toString() {
		String r = "";
		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++)
				r += peso(i, j) != INF ? String.format("%3d ", peso(i, j)) : "inf ";
			r += "\n";
		}
		return r;
	}
}
