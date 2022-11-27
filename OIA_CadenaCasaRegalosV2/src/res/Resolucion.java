package res;

import java.util.List;
import java.util.Map;

import grafo.Coloreo;
import grafo.Grafo;

public class Resolucion {
	// IN
	private Grafo g;

	// OUT
	private Map<Integer, List<Integer>> coloreados;
	private int max;

	public static void main(String[] args) {
		Archivo arch = new Archivo("caso04_iteraciones");
		Resolucion r = arch.leerArchivo();
		r.resolver();

		arch.escribirArchivo(r);

	}

	public Resolucion(Grafo g) {
		this.g = g;
	}

	public void resolver() {
		Coloreo coloreo = new Coloreo(this.g, 1);

		coloreados = coloreo.getNodoXColor();

		max = 0;
		for (Integer c : coloreados.keySet()) {
			if (coloreados.get(c).size() > coloreados.get(max).size()) {
				max = c;
			}
		}

	}

	public String getResultado() {
		String r = this.coloreados.get(max).size() + "\n";
		List<Integer> lOrd = coloreados.get(max);
		lOrd.sort(null);
		for (Integer i : lOrd) {
			r += (i + 1) + " ";
		}
		return r;
	}

}
