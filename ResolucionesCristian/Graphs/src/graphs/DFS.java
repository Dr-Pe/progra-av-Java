package graphs;

import java.util.Deque;
import java.util.LinkedList;
/*
	*
	* sirve para todo tipo de grafo
	* Complejidad: O(N+A)
	* 
	* 	Preparacion:
	* stack
	* 	
	* 	Ejecucion:
	* 
	* tomo primer nodo, lo meto en el stack y marco como visitado
	* itero 
	* saco del stack el nodo ingresado, y marco como visitados los nodos adyacentes
	* ademas de marcarlos como visitados, los agrego a un array 
	* a dichos nodos marcados, los meto al stack
	* 
	* repito el mismo proceso de sacar del stack y marcar como visitados los adyacentes
	* 
	* fin.
	*/

public class DFS {

	Deque<Integer> s;
	int[] vecDFS;

	public DFS(Graph g, int root) {
		boolean[] visit = new boolean[g.order];
		s = new LinkedList<Integer>();
		vecDFS = new int[g.order];
		int i = 0;
		visit[root] = true;
		s.push(root);
		vecDFS[i] = root;
		i++;

		while (!s.isEmpty()) {
			int v = s.remove();
			//de param recibo buscado y comparo, corto cuando lo encuentre
			//if(v == buscado) {
			//	return true;
			//}
			for (Integer w : g.neighbours(v)) {
				if (!visit[w]) {
					visit[w] = true;
					s.push(w);
					vecDFS[i] = w;
					i++;
				}
			}
		}

	}

	public int[] getDFS() {
		return this.vecDFS;
	}
}
