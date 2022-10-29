package grafos;

public class GrafoNoDirigido extends Grafo {

    private GrafoNoDirigido mst; // Minimum Spanning Tree

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

    // TODO: IMPLEMENTAR KRUSKAL. DONE, PERO ANDA MAL PARA EL EJERCICIO "METRO"
    public int kruskal() {
	/*
	 * Computa el MST (minimum spanning tree) del GrafoNoDirigido, el cual carga en this.mst, y
	 * devuelve su peso total
	 */

	this.mst = new GrafoNoDirigido(this.orden);
	int pesoTotal = 0;
	boolean[] visitado = new boolean[orden];   // Si el nodo [v] ya fue visitado

	// 1. Ordena todas las aristas
	this.aristas.sort(null);

	// 2. Agrega aristas con menor peso que no creen ciclos hasta que todos los nodos sean
	// visitables
	for(Arista ar : this.aristas) {
	    if(!visitado[ar.getVf()]) {
		visitado[ar.getVi()] = true;
		visitado[ar.getVf()] = true;
		pesoTotal += ar.getPeso();
		this.mst.agregarArista(ar);
	    }
	}

	return pesoTotal;
    }

//    // TODO: Debería ser O(n^2) y creo que me quedó O(n^4) xd
//    public int prim() {
//	/*
//	 * Computa el MST (minimum spanning tree) en un GrafoNoDirigido completamente conexo y
//	 * devuelve su peso total. También carga this.mst.
//	 */
//
//	this.mst = new GrafoNoDirigido(this.orden);
//
//	int pesoTotal = 0;
//	List<Integer> visitados = new ArrayList<Integer>();
//
//	int nodoIni = 0;
//	visitados.add(nodoIni);
//	Integer[] menor = menorAristaNodoNoVisitado(nodoIni, visitados);
//
//	while(visitados.size() < orden) {
//	    visitados.add(menor[1]);
//	    this.mst.agregarArista(menor[0], menor[1], menor[2]);
//	    pesoTotal += menor[2];
//	    menor = null;
//	    for(Integer nodo : visitados) {
//		Integer[] posibleMenor = menorAristaNodoNoVisitado(nodo, visitados); // O(n^2)
//		if(menor == null || (posibleMenor != null && posibleMenor[2] < menor[2]))
//		    menor = posibleMenor;
//	    } // O(visitados x n x n) ~= O(n^3)
//	} // O(n^4)? Me quedó re ineficiente
//
//	return pesoTotal;
//    }
//
//    private Integer[] menorAristaNodoNoVisitado(int ni, List<Integer> vis) {
//	// Devuelve { nodoInicial, nodoFinal, pesoArista } del arista con menor peso entre ni y otro
//	// nodo. O(n^2) por culpa del List.contains().
//
//	Integer nodoFinal = null;
//	Integer menorPeso = null;
//
//	for(int nf = 0; nf < orden; nf++) {
//	    if(this.adyacencias[ni][nf] != null && !vis.contains(nf)) {
//		nodoFinal = nf;
//		menorPeso = this.adyacencias[ni][nf];
//		break;
//	    }
//	}
//
//	if(nodoFinal == null)
//	    return null;
//
//	for(int nf = nodoFinal; nf < orden; nf++) {
//	    if(this.adyacencias[ni][nf] != null && !vis.contains(nf)
//				    && this.adyacencias[ni][nf] < menorPeso) {
//		nodoFinal = nf;
//		menorPeso = this.adyacencias[ni][nf];
//	    }
//	}
//
//	return new Integer[] { ni, nodoFinal, menorPeso };
//    }
//
    public GrafoNoDirigido getMST() {
	if(this.mst == null)
	    this.kruskal();
	return this.mst;
    }

}
