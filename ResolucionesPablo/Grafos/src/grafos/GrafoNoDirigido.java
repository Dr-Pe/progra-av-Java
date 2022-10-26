package grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoNoDirigido extends Grafo {

    private GrafoNoDirigido mst; // Minimum Spanning Tree

    public GrafoNoDirigido(int orden) {
	super(orden);
    }

    public GrafoNoDirigido(Integer[][] adyacencias) {
	super(adyacencias.length);
	for(int i = 0; i < adyacencias.length; i++) {
	    super.agregarArista(i, i, 0);
	    for(int j = 0; j < adyacencias.length; j++) {
		if(adyacencias[i][j] != null)
		    this.agregarArista(i, j, adyacencias[i][j]);
	    }
	}
    }

    @Override
    public void agregarArista(int vi, int vf, int peso) {
	// Las agrega espejadas, asi que más que no-dirigido queda bidireccional
	super.agregarArista(vi, vf, peso);
	super.agregarArista(vf, vi, peso);
    }

    // TODO: IMPLEMENTAR PRIM, KRUSKAL

    public int prim() {
	/*
	 * Computa el MST (minimum spanning tree) en un GrafoNoDirigido completamente conexo y
	 * devuelve su peso total. También carga this.mst.
	 */

	this.mst = new GrafoNoDirigido(this.orden);

	int pesoTotal = 0;
	List<Integer> visitados = new ArrayList<Integer>();



	return pesoTotal;
    }



}
