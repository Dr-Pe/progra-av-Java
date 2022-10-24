package grafo;

import java.util.ArrayList;
import java.util.List;

public class GrafoBosque {

    private final static Integer INFINITO = null;

    private int orden;
    private Integer[][] adyacencias;
    private Integer[][] camino;

    public GrafoBosque(int c) {
	orden = c;
	adyacencias = new Integer[c][c];
	camino = new Integer[c][c];
	for(int i = 0; i < c; i++) {
	    // Inicializa la diagonal con 0s
	    adyacencias[i][i] = 0;
	    camino[i][i] = 0;
	}
    }

    public void agregarSendero(int ci, int cf, int l) {
	adyacencias[ci][cf] = l;
	camino[ci][cf] = l;
    }

    public Integer peso(int ci, int cf) {
	return adyacencias[ci][cf];
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
	 */

	Integer[] distancia = new Integer[orden];  // Distancias desde ini hasta
						   // cada nodo
	Integer[] predecesor = new Integer[orden]; // Vector de predecesores
	boolean[] visitado = new boolean[orden];   // Si el nodo ya fue visitado

	for(int w = 0; w < orden; w++) {
	    distancia[w] = peso(ini, w);
	    predecesor[w] = distancia[w] != null ? ini : null;
	}

	distancia[ini] = 0;
	visitado[ini] = true;

	Integer v = menorNoVisitado(distancia, visitado);
	while(v != null) {
	    visitado[v] = true;
	    for(Integer w : sucesores(v)) {
		if(distancia[w] == INFINITO || distancia[w] > distancia[v] + peso(v, w)) {
		    distancia[w] = distancia[v] + peso(v, w);
		    predecesor[w] = v;
		}
	    }
	    v = menorNoVisitado(distancia, visitado);
	}

	return new Integer[][] { distancia, predecesor };
    }

    private Integer menorNoVisitado(Integer[] dis, boolean[] vis) {
	// Devuelve el indice del nodo con menor distancia que aún no haya sido
	// visitado, null si todos fueron visitados

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

    public List<Integer> sucesores(int padre) {
	// Devuelve una lista de los nodos accesibles desde el padre

	List<Integer> r = new ArrayList<Integer>();
	for(int i = 0; i < orden; i++) {
	    if(adyacencias[padre][i] != INFINITO && padre != i)
		r.add(i);
	}
	return r;
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < adyacencias.length; i++) {
	    for(int j = 0; j < adyacencias.length; j++) {
		r += adyacencias[i][j] != INFINITO
					? String.format(" %3d ", adyacencias[i][j])
					: " inf ";
	    }
	    r += "\n\n";
	}
	return r;
    }
}
