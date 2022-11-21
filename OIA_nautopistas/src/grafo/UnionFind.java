package grafo;

public class UnionFind {
	private int[] ids;

	public UnionFind(int n) {
		ids = new int[n];
		for (int i = 0; i < n; i++)
			ids[i] = i;
	}

	public int find(int ni) {
		int idNi = ni;

		while (ids[idNi] != idNi)
			idNi = ids[idNi];

		return idNi;
	}

	public void union(int ni, int nf) {
		int idNi = find(ni);
		int idNf = find(nf);

		ids[idNf] = idNi;

	}

	public boolean mismoSet(int ni, int nf) {
		int idNi = find(ni);
		int idNf = find(nf);

		return idNi == idNf;
	}

}
