package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private final static Integer INFINITO = null;

    private int orden;	// Cantidad de vértices o nodos
    private Integer[][] adyacencias;
    private Integer[][] distancias;

    public Grafo(int orden) {
	this.orden = orden;
	this.adyacencias = new Integer[orden][orden];
	this.distancias = new Integer[orden][orden];
    }

    public Grafo(Integer[][] adyacencias) {
	this.orden = adyacencias.length;
	this.adyacencias = adyacencias;
	this.distancias = new Integer[orden][orden];
	for(int i = 0; i < orden; i++) {
	    this.adyacencias[i][i] = 0;
	    for(int j = 0; j < orden; j++)
		distancias[i][j] = this.adyacencias[i][j];
	}
    }

    public void agregarArista(int vi, int vf, int peso) {
	this.adyacencias[vi][vf] = peso;
	this.distancias[vi][vf] = peso;
    }

    // IMPLEMENTAR FORD
    // IMPLEMENTAR PRIM, KRUSKAL

    public void floydWarshall() {
	/*
	 * Por ahora calcula matriz de distancias, no sé aún como calcular caminos
	 */

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
    }

    public String caminoToString() {
	String r = "";
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++) {
		r += distancias[i][j] != INFINITO
					? String.format(" %3d ", distancias[i][j])
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

    public Integer peso(int a, int b) {
	return this.adyacencias[a][b];
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

    public Integer[][] getDistancias() {
	return this.distancias;
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++) {
		r += adyacencias[i][j] != INFINITO
					? String.format(" %3d ", adyacencias[i][j])
					: " inf ";
	    }
	    r += "\n\n";
	}
	return r;
    }

}
