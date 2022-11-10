package algorithms;

import graphs.Graph;

public class FloydWarshall {

    private Integer[][] dist;

    public FloydWarshall(Graph G) {
	this.dist = new Integer[G.order][G.order];

	for(int i = 0; i < G.order; i++)
	    dist[i] = G.distances(i);

	for(int k = 0; k < G.order; k++) {
	    for(int i = 0; i < G.order; i++) {
		for(int j = 0; j < G.order; j++) {
		    if(G.areConnected(i, k) && G.areConnected(k, j)) {
			if(!G.areConnected(i, j) || dist[i][k] + dist[k][j] < dist[i][j])
			    dist[i][j] = dist[i][k] + dist[k][j];

		    }
		}
	    }
	}
    }

    public Integer[][] distances() {
	return this.dist;
    }

}
