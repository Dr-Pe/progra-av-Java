package grafo;

public class UnionFind {

    private int[] ids;

    public UnionFind(int n) {
	ids = new int[n];
	for(int i = 0; i < n; i++)
	    ids[i] = i;
    }

    public void unir(int a, int b) {
	int idA = find(a);
	int idB = find(b);
	ids[idB] = idA;
    }

    public int find(int a) {
	int idA = a;
	while(idA != ids[idA])
	    idA = ids[idA];
	return idA;
    }

    public boolean mismoSet(int a, int b) {
	return find(a) == find(b);
    }

}
