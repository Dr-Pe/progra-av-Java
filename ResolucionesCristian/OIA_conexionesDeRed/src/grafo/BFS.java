package grafo;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	private Grafo g;

	public BFS(Grafo g) {
		this.g = g;

	}

	public boolean existeConexion(int ni, int nf) {
		Queue<Integer> q = new LinkedList<Integer>();

		boolean[] visit = new boolean[g.orden];

		q.add(ni);

		while (!q.isEmpty()) {
			int na = q.remove();
			if (na == nf)
				return true;
			visit[na] = true;
			for (int i : g.vecinos(na)) {
				if (!visit[i]) {
					q.add(i);
				}
			}
		}
		return false;
	}
}
