package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private final static Integer INFINITO = null;

    private Integer[][] adyacencias;
    private Integer[][] camino;

    public Grafo(Integer[][] adyacencias) {
	this.adyacencias = adyacencias;
	this.camino = new Integer[adyacencias.length][adyacencias.length];
	for(int i = 0; i < adyacencias.length; i++) {
	    this.adyacencias[i][i] = 0;
	    for(int j = 0; j < adyacencias.length; j++)
		camino[i][j] = this.adyacencias[i][j];
	}
    }

    // IMPLEMENTAR FLOYD Y FORD

    public void floydWarshall() {
	for(int k = 0; k < camino.length; k++) {
	    for(int i = 0; i < camino.length; i++) {
		if(camino[i][k] != null) {
		    for(int j = 0; j < camino.length; j++)
			if(camino[k][j] != null) {
			    if(camino[i][j] == null || camino[i][j] > (camino[i][k]
						    + camino[k][j]))
				camino[i][j] = camino[i][k] + camino[k][j];
			}

		}
	    }
	}
    }

    public String caminoToString() {
	String r = "";
	for(int i = 0; i < camino.length; i++) {
	    for(int j = 0; j < camino.length; j++) {
		r += camino[i][j] != INFINITO ? String.format(" %3d ", camino[i][j])
					: " inf ";
	    }
	    r += "\n\n";
	}
	return r;
    }

    public Integer[][] dijkstra(int ini) {
	/*
	 * El algoritmo de Dijkstra halla los caminos más cortos desde un nodo
	 * origen a todos los demás en cualquier grafo ponderado (dirigido o no)
	 */

	Integer[] distancia = new Integer[adyacencias.length]; 	// Distancias desde ini hasta
							       	// cada nodo
	Integer[] predecesor = new Integer[adyacencias.length]; // Vector de predecesores
	boolean[] visitado = new boolean[adyacencias.length];   // Si el nodo ya fue visitado

	for(int w = 0; w < adyacencias.length; w++) {
	    distancia[w] = peso(ini, w);
	    predecesor[w] = ini;
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

	for(int v = 0; v < adyacencias.length; v++) {
	    if(!vis[v] && dis[v] != null) {
		idxMenor = v;
		break;
	    }
	}

	if(idxMenor == null)
	    return null;

	for(int v = idxMenor + 1; v < adyacencias.length; v++) {
	    if(dis[v] != null && dis[v] < dis[idxMenor] && !vis[v])
		idxMenor = v;
	}

	return idxMenor;
    }

    public Integer peso(int a, int b) {
	return this.adyacencias[a][b];
    }

    public List<Integer> sucesores(int padre) {
	// Devuelve una lista de los nodos accesibles desde el padre

	List<Integer> r = new ArrayList<Integer>();
	for(int i = 0; i < adyacencias.length; i++) {
	    if(adyacencias[padre][i] != INFINITO)
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
