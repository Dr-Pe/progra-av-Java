package res;

import java.util.ArrayList;
import java.util.List;

import grafo.Arista;
import grafo.Grafo;
import grafo.Kruskal;

public class Resolucion {
	// IN
	private Grafo g;
	private int F1;
	private int F2;
	private int F3;

	// OUT
	private boolean pudoF1;
	private boolean pudoF2;
	private boolean pudoF3;

	private List<Arista> noAristasF1;
	private List<Arista> noAristasF2;
	private List<Arista> noAristasF3;

	public static void main(String[] args) {

		Archivo arch = new Archivo("caso02_fatiga");
//		arch.crearArchivoFatiga();
//
		Resolucion r = arch.leerArchivo();
		r.resolver();

		arch.escribirArchivo(r);

	}

	public Resolucion(Grafo g, int f1, int f2, int f3) {
		this.g = g;
		this.F1 = f1;
		this.F2 = f2;
		this.F3 = f3;
		noAristasF1 = new ArrayList<Arista>();
		noAristasF2 = new ArrayList<Arista>();
		noAristasF3 = new ArrayList<Arista>();
	}

	public void resolver() {
		Kruskal K = new Kruskal(this.g);

		noAristasF1 = procesarAristas(K, F1);
		noAristasF2 = procesarAristas(K, F2);
		noAristasF3 = procesarAristas(K, F3);
		pudoF1 = noAristasF1 != null;
		pudoF2 = noAristasF2 != null;
		pudoF3 = noAristasF3 != null;
	}

	public List<Arista> procesarAristas(Kruskal K, int F) {
		int costoT = K.getCostoT();
		if (costoT > F) {
			return null;
		}

		List<Arista> noAristas = new ArrayList<Arista>();
		List<Arista> aristas = new ArrayList<Arista>(K.getMST().getAristas());
		List<Arista> sobras = new ArrayList<Arista>(K.getSobra());
		sobras.sort(null);
		while (costoT < F) {// O(A^2)
			Arista ar = buscarMayorArista(F - costoT, sobras);// O(A)
			if (ar == null)
				break;
			aristas.add(ar);
			costoT += ar.getPeso();
		}
		for (Arista ar : g.getAristas()) { // O(A^2)
			if (!aristas.contains(ar))
				noAristas.add(ar);
		}

		return noAristas;
	}

	public Arista buscarMayorArista(int PMAX, List<Arista> aristasOrd) {
		for (int i = aristasOrd.size() - 1; i >= 0; i--) {
			if (aristasOrd.get(i).getPeso() <= PMAX)
				return aristasOrd.get(i);
		}
		return null;
	}

	public List<Arista> getNoAristasF1() {
		return this.noAristasF1;
	}

	public List<Arista> getNoAristasF2() {
		return this.noAristasF2;
	}

	public List<Arista> getNoAristasF3() {
		return this.noAristasF3;
	}

	public boolean getPudoF1() {
		return this.pudoF1;
	}

	public boolean getPudoF2() {
		return this.pudoF2;
	}

	public boolean getPudoF3() {
		return this.pudoF3;
	}
}
