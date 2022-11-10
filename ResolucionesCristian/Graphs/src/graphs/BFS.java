package graphs;

import java.util.LinkedList;
import java.util.Queue;


/*
 * sirve para todo tipo de grafo
 * Complejidad: O(N+A)
 * 
 * 	Preparacion:
 * queue
 * 	
 * 	Ejecucion:
 * 
 * tomo primer nodo, lo meto en la cola y marco como visitado
 * itero 
 * saco de la cola el nodo ingresado, y marco como visitados los nodos adyacentes
 * ademas de marcarlos como visitados, los agrego a un array 
 * a dichos nodos marcados, los meto a la cola
 * 
 * repito el mismo proceso de sacar de la cola y marcar como visitados los adyacentes
 * 
 * fin.
 */

public class BFS {

	Queue<Integer> q;
	int[] vecBFS;

	public BFS(Graph g, int root) {

		/*
		 * Devuelve un array con los nodos en orden según BFS
		 */

		boolean[] visit = new boolean[g.order];
		q = new LinkedList<Integer>();
		vecBFS = new int[g.order];
		int i = 0;
		visit[root] = true;
		q.add(root);
		vecBFS[i] = root;
		i++;
		//r.add(root);

		while (!q.isEmpty()) {
			int v = q.remove();
			//de param recibo buscado y comparo, corto cuando lo encuentre
			//if(v == buscado) {
			//	return true;
			//}
			for (Integer w : g.neighbours(v)) {
				if (!visit[w]) {
					visit[w] = true;
					q.add(w);
					//r.add(w);
					vecBFS[i]=w;
					i++;
				}
			}
		}

	}

	public int[] getBFS() {
		return this.vecBFS;
	}
}
