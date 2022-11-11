package graphs;

public class UnionFind {
	/*
	 * Implementación Quick-Find de un set disjunto para algoritmo de Union-Find
	 * 
	 * Version quick-find
	 * en clase usabamos la quick-find-union (log(n) para find y union)
	 * 
	 * Complejidad: union O(n) find O(1)
	 * 
	 * 
	 * 
	 */

	private int[] ids;
	public UnionFind(int n) {
		this.ids = new int[n];
		for (int i = 0; i < this.ids.length; i++)
			this.ids[i] = i;
	}

	public void unir(int p, int q) {
		int idP = ids[p];
		for (int i = 0; i < this.ids.length; i++) {
			if (ids[i] == idP)
				ids[i] = ids[q];
		}
	}

	public boolean mismoSet(int p, int q) {
		return ids[p] == ids[q];
	}

}