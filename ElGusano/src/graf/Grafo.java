package graf;

public class Grafo {

    public static final int INF = Integer.MAX_VALUE;

    public final int orden;
    private int[][] ady;

    public Grafo(int n) {
	orden = n;
	ady = new int[n][n];
	for(int i = 0; i < n; i++) {
	    for(int j = 0; j < n; j++)
		ady[i][j] = INF;
	    ady[i][i] = 0;
	}
    }

    public void agregarArista(Arista ar) {
	ady[ar.getNi()][ar.getNf()] = ar.getP();
	ady[ar.getNf()][ar.getNi()] = ar.getP();
    }

    public int[][] getClonedAdy() {
	return this.ady.clone();
    }

}
