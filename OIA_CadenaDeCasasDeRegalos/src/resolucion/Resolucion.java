package resolucion;

import java.util.List;
import java.util.Map;

public class Resolucion {
	private Grafo g;
	private int conjMax;
	private List<Integer> conj;

	public static void main(String[] args) {
		Archivo ar = new Archivo("caso_04_bipartito");
		Resolucion r = ar.leerArchivo();
		r.resolver();
		ar.escribirArchivo(r);

	}

	public Resolucion(Grafo g) {
		this.g = g;
	}

	public void resolver() {
		Coloreo c = new Coloreo(this.g);

		Map<Integer, List<Integer>> colores = c.getConjuntos();

		conjMax = 0;
		for (Integer color : colores.keySet()) {
			if (colores.get(color).size() > conjMax) {
				conjMax = colores.get(color).size();
				conj = colores.get(color);
			}
		}
		this.conj.sort(null);

	}

	public int getConjMax() {
		return this.conjMax;
	}

	public List<Integer> getConj() {
		return this.conj;
	}

}
