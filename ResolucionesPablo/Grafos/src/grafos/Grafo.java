package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private final static int INFINITO = -1;

    private int[][] adyacencias;
    private int cantNodos;

    public Grafo(int[][] adyacencias) {
	this.adyacencias = adyacencias;
	this.cantNodos = adyacencias.length;
    }

    // IMPLEMENTAR FLOYD Y FORD

    public int[][] dijkstra(int ini) {
	/*
	 * El algoritmo de Dijkstra halla los caminos más cortos desde un nodo
	 * origen a todos los demás en cualquier grafo ponderado (dirigido o no)
	 */

	int[] distancia = new int[cantNodos]; 	     // Distancias desde ini
					      	     // hasta cada nodo
	int[] predecesor = new int[cantNodos];       // Vector de predecesores
	boolean[] visitado = new boolean[cantNodos]; // Si el nodo ya fue
						     // visitado

	for(int w = 0; w < cantNodos; w++) {
	    if(adyacencias[ini][w] != INFINITO) {
		distancia[w] = peso(ini, w);
		predecesor[w] = ini;
	    }
	    else {
		distancia[w] = INFINITO;
	    }
	}

	distancia[ini] = 0;
	visitado[ini] = true;

	Integer v = menorNoVisitado(distancia, visitado);
	while(v != null) {
	    visitado[v] = true;
	    for(Integer w : sucesores(v)) {
		if(distancia[w] > distancia[v] + peso(v, w) || distancia[w] == INFINITO) {
		    distancia[w] = distancia[v] + peso(v, w);
		    predecesor[w] = v;
		}
	    }
	    v = menorNoVisitado(distancia, visitado);
	}

	return new int[][] { distancia, predecesor };
    }

    private Integer menorNoVisitado(int[] dis, boolean[] vis) {
	// Devuelve el indice del nodo con menor distancia que aún no haya sido
	// visitado, null si todos fueron visitados

	Integer idxMenor = null;

	for(int v = 0; v < cantNodos; v++) {
	    if(!vis[v]) {
		idxMenor = v;
		break;
	    }
	}

	if(idxMenor == null)
	    return null;

	for(int v = idxMenor + 1; v < cantNodos; v++) {
	    if(dis[v] < dis[idxMenor] && !vis[v])
		idxMenor = v;
	}

	return idxMenor;
    }

    public int peso(int a, int b) {
	// Devuelve el peso entre el nodo a y el b

	return this.adyacencias[a][b];
    }

    public List<Integer> sucesores(int padre) {
	// Devuelve una lista de los nodos accesibles desde el padre

	List<Integer> r = new ArrayList<Integer>();
	for(int i = 0; i < cantNodos; i++) {
	    if(adyacencias[padre][i] != INFINITO)
		r.add(i);
	}
	return r;
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < cantNodos; i++) {
	    for(int j = 0; j < cantNodos; j++) {
		r += adyacencias[i][j] != INFINITO
					? String.format(" %3d ", adyacencias[i][j])
					: " inf ";
	    }
	    r += "\n\n";
	}
	return r;
    }

}
