import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private Integer[][] matAdy;
	private int orden;

	public Graph(int i) {
		matAdy = new Integer[i][i];
		orden = i;
	}

	public void addEdge(int ni, int nf, int p) {
		this.matAdy[ni][nf] = p;
		this.matAdy[nf][ni] = p;
	}

	@Override
	public String toString() {
		String r = "";

		for (int i = 0; i < matAdy.length; i++) {
			for (int j = 0; j < matAdy.length; j++) {
				r += getPeso(i, j) != null ? String.format("%3d ", getPeso(i, j)) : "--- ";
			}
			r += "\n";
		}

		return r;
	}

	public Integer getPeso(int ni, int nf) {
		return matAdy[ni][nf];
	}

	public Integer[] BFS(int ni) {
		Queue<Integer> q = new LinkedList<Integer>();

		boolean[] visit = new boolean[this.orden];
		Integer[] vecCostos = new Integer[this.orden];
		q.add(ni);

		while (!q.isEmpty()) {
			int v = q.remove();
			visit[v] = true;
			for (Integer w : getAdy(v)) {
				if (visit[w] == false) {
					q.add(w);
					visit[w] = true;
					if (vecCostos[w] == null || vecCostos[w] > getPeso(v, w)) {
						vecCostos[w] = getPeso(ni, v) == null ? getPeso(v, w) : Math.min(getPeso(ni, v), getPeso(v, w));

					}
				}
			}

		}

		return vecCostos;

	}

	public ArrayList<Integer> getAdy(int idx) {
		ArrayList<Integer> ady = new ArrayList<Integer>();
		for (int i = 0; i < orden; i++) {
			if (matAdy[idx][i] != null)
				ady.add(i);
		}
		return ady;
	}
}
