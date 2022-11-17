package grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coloreo {

    private class Nodo implements Comparable<Nodo> {
	private int idx;
	private int grad;
	private int color;

	private Nodo(int i, int gr) {
	    idx = i;
	    grad = gr;
	    color = -1;
	}

	@Override
	public int compareTo(Nodo o) {
	    return this.grad - o.grad;
	}

    }

    private Nodo[] nodos;
    private Nodo[] nodosOrd;
    private Map<Integer, List<Nodo>> nodosXColor;

    public Coloreo(Grafo g) {
	nodos = new Nodo[g.orden];
	nodosXColor = new HashMap<Integer, List<Nodo>>();
	nodosOrd = new Nodo[g.orden];

	for(int i = 0; i < g.orden; i++) {
	    Nodo ni = new Nodo(i, g.vecinos(i).size());
	    nodos[i] = ni;
	    nodosOrd[i] = ni;
	}

	Arrays.sort(nodosOrd);

	for(int i = 0; i < g.orden; i++) {
	    Nodo n = nodosOrd[i];
	    int color = buscarColor(g.vecinos(n.idx));
	    n.color = color;
	    List<Nodo> aux = new ArrayList<Nodo>();
	    aux.add(n);
	    if(nodosXColor.putIfAbsent(color, aux) != null)
		nodosXColor.get(color).add(n);
	}
    }

    public int tamMaximoGrupo() {
	int maximo = 0;
	for(int color : nodosXColor.keySet()) {
	    int posible = nodosXColor.get(color).size();
	    if(posible > maximo)
		maximo = posible;
	}
	return maximo;
    }

    private int buscarColor(List<Integer> vec) {
	int color = 0;
	boolean colorAceptable;

	for(int i = 0; i < vec.size(); i++) {
	    colorAceptable = true;
	    for(Integer v : vec) {
		if(nodos[v].color == color) {
		    color++;
		    colorAceptable = false;
		    break;
		}
	    }
	    if(colorAceptable)
		return color;
	}
	return color;
    }

}
