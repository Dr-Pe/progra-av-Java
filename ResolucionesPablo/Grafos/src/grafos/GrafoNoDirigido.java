package grafos;

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

    public GrafoNoDirigido getMST() {
	GrafoMST mst = new GrafoMST(this);
	mst.kruskal();
	return mst;
    }

}
