package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColoreoRandom {
	/*	para grafo no dirigido
	 * 
	 * 	Complejidad: O(n^3);	ideal es n^2 pero nose.
	 * 
	 * 	PREPARACION
	 * agrupo por grado los nodos
	 * orderno aleatoriamente
	 * 
	 *  EJECUCION
	 * tomo primer nodo de la lista "ordenada", pregunto si esta pintado
	 * si esta pintando, salteo
	 * si no esta pintado, pregunto que color de los nodos adyacentes existen
	 * tomo el color minimo posible
	 * pinto
	 * hacer lo mismo para cada nodo
	 * 
	 */


	List<Integer[]> conjuntos;
	Map<Integer, ArrayList<Node>> coloreo;

	public ColoreoRandom(Graph g) {
		int color;
		ArrayList<Node> l = new ArrayList<Node>();

		Node[] nodes = g.getNodes();

		for (Node n : nodes) {
			if (n != null)
				l.add(n);
		}

		System.out.println(l);

		Collections.sort(l, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (int) Math.floor(Math.random()*(1-(-1)+1)+-1);
			}
		});
		System.out.println("ORDEN RANDOM:");
		System.out.println(l);
		
		coloreo = new HashMap<Integer, ArrayList<Node>>();
		for (int i = 0; i < l.size(); i++) {
			coloreo.put(i, new ArrayList<Node>());
		}

		// g.printNodes();

		for (int i = 0; i < l.size(); i++) {
			Node v = l.get(i);
			color = buscarColor(g.neighboursNode(v));
			coloreo.get(color).add(v);
			v.setColor(color);
		}

		System.out.println(coloreo.values());
		
	}

	// busco minimo color disponible
	public int buscarColor(List<Node> ady) {
		int color = 0;
		boolean colorAceptable;
		for (int i = 0; i < ady.size(); i++) {
			colorAceptable = true;
			for (Node n : ady) {
				if (n.getColor() == color) {
					color++;
					colorAceptable = false;
					break;
				}
			}
			if (colorAceptable == true) {
				return color;
			}
		}
		return color;
	}
}
