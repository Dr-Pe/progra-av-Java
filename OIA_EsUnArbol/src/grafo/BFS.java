package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private List<Integer> conexos;

    public BFS(Grafo G, int vi) {
	conexos = new ArrayList<Integer>();

	boolean[] visit = new boolean[G.orden];
	Queue<Integer> q = new LinkedList<Integer>();

	q.add(vi);
	conexos.add(vi);

	while(!q.isEmpty()) {
	    int va = q.remove();
	    visit[va] = true;
	    for(int vv : G.vecinos(va)) {
		if(!visit[vv]) {
		    q.add(vv);
		    conexos.add(vv);
		}
	    }
	}
    }

    public List<Integer> getConexos() {
	return conexos;
    }

}
