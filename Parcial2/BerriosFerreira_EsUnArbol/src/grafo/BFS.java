package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private List<Integer> camino;

    public BFS(Grafo G, int vi) {
	camino = new ArrayList<Integer>();

	boolean[] visit = new boolean[G.orden];
	Queue<Integer> q = new LinkedList<Integer>();

	q.add(vi);
	camino.add(vi);

	while(!q.isEmpty()) {
	    int va = q.remove();
	    visit[va] = true;
	    for(int vv : G.vecinos(va)) {
		if(!visit[vv]) {
		    q.add(vv);
		    camino.add(vv);
		}
	    }
	}
    }

    public List<Integer> getEnCamino() {
	return camino;
    }

}
