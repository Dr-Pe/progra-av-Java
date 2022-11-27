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
    private List<Integer> hijosDeDos;
    private List<Integer> inconexos;

    public static void main(String[] args) {

	Archivo ar = new Archivo("caso6_fatiga_circular");
//	ar.generarFatiga();

	Resolucion r = ar.leerArchivo();

	r.resolver();
	ar.escribirArchivo(r);

    }

    public Resolucion(Grafo g) {
	G = g;
	esArbol = true;
	posiblesRaiz = new ArrayList<Integer>();
	hijosDeDos = new ArrayList<Integer>();
	inconexos = new ArrayList<Integer>();
    }

    public void resolver() {
	if(G.orden == 1) {
	    posiblesRaiz.add(0);
	    return;
	}

	buscarPosiblesRaiz();
	if(posiblesRaiz.size() != 1)
	    esArbol = false;
	buscarHijosDeDos();
	if(hijosDeDos.size() > 0)
	    esArbol = false;
	buscarInconexos();
	if(inconexos.size() > 0)
	    esArbol = false;
    }

    public String getRespuesta() {
	String r = "";

	if(esArbol) {
	    r = "SI " + printArrayList(posiblesRaiz);
	}
	else {
	    r = "NO\n";
	    if(posiblesRaiz.size() == 0)
		r += "0\n";
	    else
		r += printArrayList(posiblesRaiz) + "\n";
	    if(hijosDeDos.size() == 0)
		r += "0\n";
	    else
		r += printArrayList(hijosDeDos) + "\n";
	    if(inconexos.size() == 0)
		r += "0\n";
	    else
		r += printArrayList(inconexos) + "\n";
	}

	return r;
    }

    private void buscarPosiblesRaiz() {
	for(int i = 0; i < G.orden; i++) {
	    if(G.aristasEntrantes(i) == 0 && G.aristasSalientes(i) > 0) {
		posiblesRaiz.add(i);
	    }
	}
    }

    private void buscarHijosDeDos() {
	for(int i = 0; i < G.orden; i++) {
	    if(G.aristasEntrantes(i) > 1) {
		hijosDeDos.add(i);
	    }
	}
    }

    private void buscarInconexos() {
	if(!esArbol)
	    return;

	BFS bfs = new BFS(G, posiblesRaiz.get(0));
	List<Integer> conexos = bfs.getConexos();
	for(int i = 0; i < G.orden; i++) {
	    if(!conexos.contains(i))
		inconexos.add(i);
	}
    }

    private String printArrayList(List<Integer> l) {
	String r = "";
	for(Integer i : l)
	    r += (i + 1) + " ";
	return r;
    }

}
