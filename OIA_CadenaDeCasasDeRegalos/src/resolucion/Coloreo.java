package resolucion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coloreo {
	private class Nodo implements Comparable<Nodo> {
		private int id;
		private int color;
		private int grado;

		public Nodo(int id, int grado) {
			this.id = id;
			this.grado = grado;
			this.color = -1;
		}

		@Override
		public int compareTo(Nodo o) {
			return this.grado - o.grado;
		}
	}

	private Nodo[] nodosOri;
	private Nodo[] nodosOrd;
	private Map<Integer, List<Nodo>> conjuntos;

	public Coloreo(Grafo g) {
		nodosOri = new Nodo[g.orden];
		nodosOrd = new Nodo[g.orden];
		conjuntos = new HashMap<Integer, List<Nodo>>();

		for (int i = 0; i < g.orden; i++) {
			Nodo nodo = new Nodo(i, g.vecinos(i).size());
			nodosOrd[i] = nodo;
			nodosOri[i] = nodo;
		}

		Arrays.sort(nodosOrd);

		for (int i = 0; i < nodosOrd.length; i++) {

			int color = buscarColor(nodosVecinos(g.vecinos(nodosOrd[i].id)));
			nodosOrd[i].color = color;

			ArrayList<Nodo> n = new ArrayList<Nodo>();
			n.add(nodosOrd[i]);
			if (conjuntos.putIfAbsent(color, n) != null) {
				conjuntos.get(color).add(nodosOrd[i]);
			}

		}
	}

	public List<Nodo> nodosVecinos(List<Integer> nodos) {
		List<Nodo> r = new ArrayList<Nodo>();
		for (Integer n : nodos) {
			r.add(nodosOri[n]);
		}
		return r;
	}

	public int buscarColor(List<Nodo> vecinos) {
		int color = 0;
		boolean colorAceptable = true;

		for (int i = 0; i < vecinos.size(); i++) {
			colorAceptable = true;
			for (Nodo ni : vecinos) {

				if (ni.color == color) {
					color++;
					colorAceptable = false;
					break;
				}
			}
			if (colorAceptable) {
				return color;
			}

		}

		return color;
	}

	public Map<Integer, List<Integer>> getConjuntos() {
		Map<Integer, List<Integer>> r = new HashMap<Integer, List<Integer>>();

		for (Integer c : conjuntos.keySet()) {
			List<Nodo> nodos = new ArrayList<Nodo>(conjuntos.get(c));
			List<Integer> ids = new ArrayList<Integer>();
			for (Nodo n : nodos) {
				ids.add(n.id);
			}
			r.put(c, ids);
		}

		return r;
	}

}
