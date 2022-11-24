package graf;

public class Floyd {

    private int[][] dist;

    public Floyd(Grafo G) {
	dist = G.getClonedAdy();

	for(int k = 0; k < G.orden; k++) {
	    for(int i = 0; i < G.orden; i++) {
		if(dist[i][k] == Grafo.INF)
		    continue;
		for(int j = 0; j < G.orden; j++) {
		    if(dist[k][j] == Grafo.INF)
			continue;
		    if(dist[i][j] > dist[i][k] + dist[k][j])
			dist[i][j] = dist[i][k] + dist[k][j];
		}
	    }
	}
    }

    public int[][] getClonedDist() {
	return dist.clone();
    }

}
