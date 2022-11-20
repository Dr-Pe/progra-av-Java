package graf;

public class Dijkstra {

    public final static int NO_PREC = -1;

    private int[] precedencias;
    private int[] costos;

    public Dijkstra(Grafo g, int ni) {
	precedencias = new int[g.orden];
	costos = g.distancias(ni);

	boolean[] visitados = new boolean[g.orden];

	for(int i = 0; i < g.orden; i++) {
	    if(costos[i] != Grafo.INF)
		precedencias[i] = ni;
	    else
		precedencias[i] = NO_PREC;
	}

	precedencias[ni] = ni;
	costos[ni] = 0;
	visitados[ni] = true;

	int nx = buscarMasCercano(costos, visitados);
	while(nx != NO_PREC) {
	    visitados[nx] = true;
	    for(int vec : g.vecinos(nx)) {
		if(nx != vec && !visitados[vec]
					&& g.peso(nx, vec) + costos[nx] < costos[vec]) {
		    costos[vec] = g.peso(nx, vec) + costos[nx];
		    precedencias[vec] = nx;
		}
	    }
	    nx = buscarMasCercano(costos, visitados);
	}

    }

    public int[] getPrecedencias() {
	return precedencias;
    }

    public int[] getCostos() {
	return costos;
    }

    private int buscarMasCercano(int[] costos, boolean[] visitados) {
	int min = Grafo.INF;
	int idx = NO_PREC;

	for(int i = 0; i < costos.length; i++) {
	    if(costos[i] < min && !visitados[i]) {
		min = costos[i];
		idx = i;
	    }
	}

	return idx;
    }

}
