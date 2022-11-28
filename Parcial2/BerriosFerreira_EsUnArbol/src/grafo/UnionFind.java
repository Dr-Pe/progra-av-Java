package grafo;

public class UnionFind {

    private int[] ids;

    public UnionFind(int n) {
	ids = new int[n];
	for(int i = 0; i < n; i++)
	    ids[i] = i;
    }

    public int find(int n) {
	int idN = n;
	while(ids[idN] != idN)
	    idN = ids[idN];
	return idN;
    }

    public void unir(int a, int b) {
	int idA = find(a);
	int idB = find(b);
	ids[idB] = idA;
    }

    public boolean mismoSet(int a, int b) {
	return find(a) == find(b);
    }

}
