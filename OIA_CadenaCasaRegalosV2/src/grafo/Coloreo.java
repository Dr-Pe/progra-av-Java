package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coloreo {

	private Map<Integer, List<Nodo>> nodosXColor;
	private List<Nodo> nodos;
	private List<Nodo> nodosOrd;
	private Grafo g;

	private class Nodo implements Comparable<Nodo> {
		private int color;
		private int id;
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

		@Override
		public String toString() {

			return this.id + " " + this.grado + " " + this.color;
		}
	}

	public Coloreo(Grafo gra, int iter) {
		this.g = gra;
		this.nodos = new ArrayList<Nodo>();
		this.nodosXColor = new HashMap<Integer, List<Nodo>>();
		this.nodosOrd = new ArrayList<Nodo>();

		for (int i = 0; i < g.orden; i++) {
			Nodo na = new Nodo(i, g.vecinos(i).size());
			nodos.add(na);
			nodosOrd.add(na);
		}

		for (int i = 0; i < iter; i++) {
			nodosOrd.sort(null);
			Map<Integer, List<Nodo>> coloreadosAct = coloreado();
			if (coloreadosAct.size() < nodosXColor.size() || nodosXColor.size() == 0)
				nodosXColor = coloreadosAct;

			Collections.sort(nodosOrd, new Comparator<Nodo>() {
				@Override
				public int compare(Nodo o1, Nodo o2) {
					return (int) Math.random() * 2 - 1;
				}
			});
		}
	}

	private Map<Integer, List<Nodo>> coloreado() {
		Map<Integer, List<Nodo>> coloreados = new HashMap<Integer, List<Nodo>>();
		for (int i = 0; i < nodos.size(); i++) {
			Nodo na = nodosOrd.get(i);
			int color = colorMinimo(g.vecinos(na.id));
			na.color = color;
			List<Nodo> lna = new ArrayList<Nodo>();
			lna.add(na);
			if (coloreados.putIfAbsent(color, lna) != null)
				coloreados.get(color).add(na);

		}

		return coloreados;

	}

	private int colorMinimo(List<Integer> vecinos) {
		int color = 0;
		boolean colorAceptable = true;

		for (int i = 0; i < vecinos.size(); i++) {
			for (Integer ns : vecinos) {

				Nodo nv = nodos.get(ns);
				if (nv.color == color) {
					colorAceptable = false;
					color++;
				}
			}
			if (colorAceptable)
				return color;
		}
		return color;
	}

	public Map<Integer, List<Integer>> getNodoXColor() {
		Map<Integer, List<Integer>> r = new HashMap<Integer, List<Integer>>();

		for (Integer c : nodosXColor.keySet()) {
			List<Integer> l = new ArrayList<Integer>();
			for (Nodo n : nodosXColor.get(c)) {
				l.add(n.id);
			}
			r.put(c, l);
		}

		return r;
	}

}
