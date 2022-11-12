package grafo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Deprecated
public class Grafo {

    // Grafo no-dirigido totamente conexo

    private int orden;
    private Vertice[] vertices;
    private Arista[][] ady;

    public Grafo(int orden) {
	this.orden = orden;
	this.vertices = new Vertice[orden];
	this.ady = new Arista[orden][orden];
    }

    public void agregarArista(Vertice vi, Vertice vf) {
	this.vertices[vi.getId()] = vi;
	this.vertices[vf.getId()] = vf;

	Arista nueva = new Arista(vi, vf);
	this.ady[vi.getId()][vf.getId()] = nueva;
	this.ady[vf.getId()][vi.getId()] = nueva;
    }

    // PRIMER PLANTEO
    public List<Vertice> busquedaBasadaEnBFS(int vi, int vf) {
	List<Vertice> r = new ArrayList<Vertice>();
	Queue<Integer> q = new ArrayDeque<Integer>();
	boolean[] visit = new boolean[orden];
	boolean saltoLargo = true;

	q.add(vi);
	visit[vi] = true;
	while(!q.isEmpty()) {
	    boolean pudoSaltar = false;
	    int v = q.remove();
	    r.add(vertices[v]);
	    if(v == vf)
		return r;
	    for(int j = orden - 1; j >= 0; j--) {
		if(ady[v][j].getPeso() <= 50 && !visit[j]) {
		    q.add(j);
		    visit[j] = true;
		    pudoSaltar = true;
		}
	    }
	    if(!pudoSaltar && saltoLargo) {
		for(int j = orden - 1; j >= 0; j--) {
		    if(ady[v][j].getPeso() <= 100 && !visit[j]) {
			q.add(j);
			visit[j] = true;
			pudoSaltar = true;
		    }
		}
	    }
	}

	return r;
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < orden; i++) {
	    for(int j = 0; j < orden; j++)
		r += String.format("%.3f", ady[i][j].getPeso()) + "   ";
	    r += "\n";
	}
	return r;
    }

}