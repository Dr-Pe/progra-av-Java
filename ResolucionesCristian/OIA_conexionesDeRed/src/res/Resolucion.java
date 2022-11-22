package res;

import java.util.ArrayList;
import java.util.List;

import grafo.Arista;
import grafo.BFS;
import grafo.Grafo;

public class Resolucion {
	private List<String> pedidos;
	private List<Arista> pedidosDatos;
	private List<String> rta;
	private Grafo g;

	public static void main(String[] args) {

		Archivo arch = new Archivo("casoEnunciado");

		Resolucion r = arch.leerArchivo();
		r.resolver();
		arch.escribirArchito(r);
	}

	public Resolucion(List<String> pedidos, List<Arista> pedidosDatos, Grafo g) {
		this.pedidos = new ArrayList<String>();
		this.pedidosDatos = new ArrayList<Arista>();
		this.rta = new ArrayList<String>();

		this.pedidos = pedidos;
		this.pedidosDatos = pedidosDatos;
		this.g = g;
	}

	public void resolver() {
		BFS bfs = new BFS(this.g);
		for (int i = 0; i < pedidos.size(); i++) {
			char ped = pedidos.get(i).charAt(0);
			Arista ar = pedidosDatos.get(i);
			if (ped == 'P') {
				if (bfs.existeConexion(ar.getVi(), ar.getVf()))
					rta.add("S");
				else
					rta.add("N");
			} else {
				g.agregarArista(ar);
			}

		}

	}

	public List<String> getRta() {
		return this.rta;
	}
}
