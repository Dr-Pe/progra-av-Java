package sets;

public class SetDisjunto {
    /*
     * Implementación Quick-Find de un set disjunto para algoritmo de Union-Find
     * 
     * Ver: https://courses.cs.duke.edu/cps100e/fall09/notes/UnionFind.pdf
     */

    // y https://www.geeksforgeeks.org/union-find/

    private int[] ids; // p and q are connected if they have the same id.

    public SetDisjunto(int n) {
	// Create union-find data structure with N objects and no connections.

	this.ids = new int[n];
	for(int i = 0; i < this.ids.length; i++)
	    this.ids[i] = i;
    }

    public void unir(int p, int q) {
	/*
	 * Replace sets containing p and q with their union.
	 * To merge sets containing p and q , change all entries with id[p] to id[q].
	 * 
	 * O(n)
	 */
	int idP = ids[p];
	for(int i = 0; i < this.ids.length; i++) {
	    if(ids[i] == idP)
		ids[i] = ids[q];
	}
    }

    public boolean mismoSet(int p, int q) {
	/*
	 * Are p and q in the same set? -> Check if p and q have the same id.
	 * 
	 * O(1)
	 */
	return ids[p] == ids[q];
    }

}
