package sets;

public class SetDisjunto {
    // Ver https://courses.cs.duke.edu/cps100e/fall09/notes/UnionFind.pdf
    // y https://www.geeksforgeeks.org/union-find/

    private int[] ids; // p and q are connected if they have the same id.

    public SetDisjunto(int n) {
	// Create union-find data structure with N objects and no connections.
	this.ids = new int[n];
    }

    public boolean find(int p, int q) {
	// Are p and q in the same set?
	return false;
    }

    public void unite(int p, int q) {
	// Replace sets containing p and q with their union.

    }

}
