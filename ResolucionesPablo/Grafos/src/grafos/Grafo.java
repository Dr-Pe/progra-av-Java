package grafos;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Grafo {

    protected final static Integer INFINITO = null;

    protected int orden; 		// Cantidad de vértices o nodos
    protected Arista[][] adyacencias;	// Las mismas aristas de la lista pero en sus respectivas
				     	// posiciones en la matriz de adyacencia

    public Grafo(int orden) {
	this.orden = orden;
	this.adyacencias = new Arista[orden][orden];
    }

    public Grafo(Integer[][] adyacencias) {
	this.orden = adyacencias.length;
	this.adyacencias = new Arista[orden][orden];
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++) {
		if(adyacencias[i][j] != null)
		    this.agregarArista(i, j, adyacencias[i][j]);
	    }
	}
    }

    public void agregarArista(int vi, int vf, int peso) {
	Arista nueva = new Arista(vi, vf, peso);
	this.adyacencias[vi][vf] = nueva;
    }

    public void agregarArista(Arista nueva) {
	this.adyacencias[nueva.getVi()][nueva.getVf()] = nueva;
    }

    public Integer[] BFS(int raiz) {
	/*
	 * Devuelve un array con los nodos en orden según BFS
	 */

	Queue<Integer> q = new LinkedList<Integer>();
	boolean[] visitados = new boolean[this.orden];
	List<Integer> r = new ArrayList<Integer>();

	visitados[raiz] = true;
	q.add(raiz);
	r.add(raiz);

	while(!q.isEmpty()) {
	    int v = q.remove();
	    for(Integer w : this.sucesores(v)) {
		if(!visitados[w]) {
		    visitados[w] = true;
		    q.add(w);
		    r.add(w);
		}
	    }
	}

	return r.toArray(new Integer[0]);
    }

    public Integer[] DFS(int raiz) {
	/*
	 * Devuelve un array con los nodos en orden según DFS
	 */

	Deque<Integer> s = new LinkedList<Integer>();
	boolean[] visitados = new boolean[this.orden];
	List<Integer> r = new ArrayList<Integer>();

	visitados[raiz] = true;
	s.push(raiz);
	r.add(raiz);

	while(!s.isEmpty()) {
	    int v = s.pop();
	    for(Integer w : this.sucesores(v)) {
		if(!visitados[w]) {
		    visitados[w] = true;
		    s.push(w);
		    r.add(w);
		}
	    }
	}

	return r.toArray(new Integer[0]);
    }

    // TODO: IMPLEMENTAR FORD

    public Integer[][] floydWarshall() {
	/*
	 * Calcula la menor distancia entre dos nodos para cada nodo de un grafo ponderado
	 * Complejidad: O(N^3)
	 */

	Integer[][] distancias = new Integer[orden][orden]; // Distancias de un nodo a otro

	// Inicializo distancias (O(N^2))
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++) {
		distancias[i][j] = this.peso(i, j);
	    }
	}

	// Floyd-Warshall (O(N^3))
	for(int k = 0; k < orden; k++) {
	    for(int i = 0; i < orden; i++) {
		if(distancias[i][k] != null) {
		    for(int j = 0; j < orden; j++)
			if(distancias[k][j] != null) {
			    if(distancias[i][j] == null
						    || distancias[i][j] > (distancias[i][k]
									    + distancias[k][j]))
				distancias[i][j] = distancias[i][k] + distancias[k][j];
			}
		}
	    }
	}

	return distancias;
    }

    public Integer[][] dijkstra(int ini) {
	/*
	 * El algoritmo de Dijkstra halla los caminos más cortos desde un nodo
	 * origen a todos los demás en cualquier grafo ponderado (dirigido o no).
	 * 
	 * Los pesos deben ser siempre positivos.
	 * 
	 * in: Nodo a partir del cual calcular
	 * out: vector de distancia minima y vector de precedencia (camino).
	 * complejidad: O(N^2) donde N = # de nodos
	 */

	Integer[] distancia = new Integer[orden];  // Distancias desde ini hasta
						   // cada nodo
	Integer[] predecesor = new Integer[orden]; // Vector de predecesores
	boolean[] visitado = new boolean[orden];   // Si el nodo [v] ya fue visitado

	for(int w = 0; w < orden; w++) {
	    distancia[w] = peso(ini, w);
	    predecesor[w] = distancia[w] != null ? ini : null;
	}

	visitado[ini] = true;

	Integer v = menorNoVisitado(distancia, visitado);
	while(v != null) {
	    visitado[v] = true;
	    for(Integer w : sucesores(v)) {
		if(distancia[w] == INFINITO || distancia[w] > distancia[v] + peso(v, w)) {
		    distancia[w] = distancia[v] + peso(v, w);
		    predecesor[w] = v;
		}
	    } // O(N)
	    v = menorNoVisitado(distancia, visitado);
	} // O(N^2)

	return new Integer[][] { distancia, predecesor };
    }

    private Integer menorNoVisitado(Integer[] dis, boolean[] vis) {
	/*
	 * Devuelve el indice del nodo con menor distancia que aún no haya sido
	 * visitado, null si todos fueron visitados. O(N)
	 */

	Integer idxMenor = null;

	for(int v = 0; v < orden; v++) {
	    if(!vis[v] && dis[v] != null) {
		idxMenor = v;
		break;
	    }
	}

	if(idxMenor == null)
	    return null;

	for(int v = idxMenor + 1; v < orden; v++) {
	    if(dis[v] != null && dis[v] < dis[idxMenor] && !vis[v])
		idxMenor = v;
	}

	return idxMenor;
    }

    public Integer peso(int a, int b) {
	if(a == b)
	    return 0;
	else if(this.adyacencias[a][b] != null)
	    return this.adyacencias[a][b].getPeso();
	else
	    return null;
    }

    public List<Integer> sucesores(int padre) {
	// Devuelve una lista de los nodos accesibles desde el padre

	List<Integer> r = new ArrayList<Integer>();
	for(int i = 0; i < orden; i++) {
	    if(this.adyacencias[padre][i] != null && padre != i)
		r.add(i);
	}
	return r;
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++) {
		r += this.peso(i, j) != null ? String.format(" %3d ", this.peso(i, j))
					: " inf ";
	    }
	    r += "\n\n";
	}
	return r;
    }

}
