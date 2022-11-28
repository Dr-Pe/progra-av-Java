package res;

import java.util.ArrayList;
import java.util.List;

import grafo.BFS;
import grafo.Grafo;

public class Resolucion {

    // IN
    private Grafo G;

    // OUT
    private boolean esArbol;
    private List<Integer> posiblesRaiz;
    private List<Integer> noCumplenRegla2;
    private List<Integer> fueraDeCamino;
    private boolean esConexo;

    public static void main(String[] args) {

	Archivo ar = new Archivo("caso6_fatiga_lineal");

	Resolucion r = ar.leerArchivo();

	r.resolver();
	ar.escribirArchivo(r);

    }

    public Resolucion(Grafo g) {
	G = g;
	esArbol = true;
	posiblesRaiz = new ArrayList<Integer>();
	noCumplenRegla2 = new ArrayList<Integer>();
	fueraDeCamino = new ArrayList<Integer>();
    }

    public void resolver() {
	if(G.orden == 1) {
	    posiblesRaiz.add(0);
	    return;
	}

	buscarPosiblesRaiz();    // O(V^2)
	if(posiblesRaiz.size() != 1)
	    esArbol = false;
	buscarNoCumplenRegla2(); // O(V^2)
	if(noCumplenRegla2.size() > 0)
	    esArbol = false;
	buscarFueraDeCamino();   // O(V^2)
	if(fueraDeCamino.size() > 0)
	    esArbol = false;
	esConexo();             // O((V^2) * logV)
    }

    public String generarOutputString() {
	String r = "";

	if(esArbol) {
	    r = "SI " + imprimirLista(posiblesRaiz);
	}
	else {
	    r = "NO\n";
	    r += imprimirLista(posiblesRaiz);
	    r += imprimirLista(noCumplenRegla2);
	    r += imprimirLista(fueraDeCamino);
	    r += esConexo ? "ES CONEXO" : "NO ES CONEXO";
	}

	return r;
    }

    private void buscarPosiblesRaiz() {
	for(int i = 0; i < G.orden; i++) {
	    if(G.aristasEntrantes(i) == 0) {
		posiblesRaiz.add(i);
	    }
	}
    }

    private void buscarNoCumplenRegla2() {
	for(int i = 0; i < G.orden; i++) {
	    if(G.aristasEntrantes(i) != 1)
		noCumplenRegla2.add(i);
	}
	if(posiblesRaiz.size() == 1)
	    noCumplenRegla2.remove(posiblesRaiz.get(0)); // Eliminamos la raíz, ella si puede
							 // incumplir la regla 2
    }

    private void buscarFueraDeCamino() {
	if(posiblesRaiz.size() != 1)
	    return;

	BFS bfs = new BFS(G, posiblesRaiz.get(0)); // O(V+A)
	List<Integer> enCamino = bfs.getEnCamino();
	for(int i = 0; i < G.orden; i++) {
	    if(!enCamino.contains(i))
		fueraDeCamino.add(i);
	}
    }

    private void esConexo() {
	esConexo = G.esConexo();
    }

    private static String imprimirLista(List<Integer> l) {
	if(l.size() == 0)
	    return "0\n";
	String r = "";
	for(Integer i : l)
	    r += (i + 1) + " ";
	return r + "\n";
    }

}
