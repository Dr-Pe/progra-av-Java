package grafos;

public class GrafoDirigido extends Grafo {

    public GrafoDirigido(int orden) {
	super(orden);
    }

    public GrafoDirigido(Integer[][] adyacencias) {
	super(adyacencias);
    }

    public void floydWarshall() {
	/*
	 * Calcula la menor distancia entre dos nodos para cada nodo de un grafo ponderado y
	 * dirigido
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

}
