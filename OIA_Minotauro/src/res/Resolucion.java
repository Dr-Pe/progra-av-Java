package res;

import grafo.Grafo;
import grafo.Kruskal;

public class Resolucion {

    // IN
    private Grafo G;

    // OUT
    private Grafo MST;

    public static void main(String[] args) {

	Archivo ar = new Archivo("caso4_fatiga_result_conocido");

//	ar.generarFatiga();

	Resolucion r = ar.leerArchivo();

	r.resolver();
	ar.escribirArchivo(r);

    }

    public Resolucion(Grafo G) {
	this.G = G;
    }

    public void resolver() {
	Kruskal kr = new Kruskal(G);
	MST = kr.getMST();
    }

    public Grafo getMST() {
	return MST;
    }

}