package grafos;

import java.util.ArrayList;
import java.util.List;

public class GrafoNoDirigido extends Grafo {

    public GrafoNoDirigido(int orden) {
	super(orden);
    }

    public GrafoNoDirigido(Integer[][] adyacencias) {
	super(adyacencias.length);
	for(int i = 0; i < adyacencias.length; i++) {
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

    @Override
    public List<Arista> getAristas(int v) {
	// Devuelve lista de aristas desde v

	List<Arista> r = new ArrayList<Arista>();
	for(int j = v; j < orden; j++) {
	    if(this.adyacencias[v][j] != null)
		r.add(this.adyacencias[v][j]);
	}
	return r;
    }

}
