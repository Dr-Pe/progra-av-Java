
import java.util.ArrayList;
import java.util.List;

public class Grafo {
	// Grafo no-dirigido

	private int orden;
	private Vertice[] vertices;
	private Integer[][] ady;

	public Grafo(List<Vertice> vert) {
		this.orden = vert.size();
		this.vertices = vert.toArray(new Vertice[0]);
		this.ady = new Integer[orden][orden];
		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++)
				agregarArista(i, j);
		}
		
	}

	private void agregarArista(int vi, int vf) {
		double dist = vertices[vi].distancia(vertices[vf]);

		if (vi == vf)
			ady[vi][vf] = 0;
		else if (dist <= 50)
			ady[vi][vf] = 1;
		else if (dist <= 100)
			ady[vi][vf] = 2;
		else
			ady[vi][vf] = Integer.MAX_VALUE;
	}

	public int[] distances(int root) {
		int[] r = new int[orden];
		for (int j = 0; j < orden; j++)
			r[j] = this.peso(root, j);
		return r;
	}

	public int peso(int i, int j) {
		return ady[i][j];
	}

	public int[] Dijkstra(int root) {
		int[] dist = this.distances(root);
		int[] pred = new int[orden];

		boolean[] visit = new boolean[orden]; // Vertices ya visitados, inicialmente ninguno

		// Inicializo vector de predecesores y distancias
		for (int i = 0; i < orden; i++) {
			if (this.peso(root, i) == Integer.MAX_VALUE)
				dist[i] = Integer.MAX_VALUE;
			else {
				dist[i] = this.peso(root, i);
				pred[i] = root;
			}

		}

		dist[root] = 0;
		visit[root] = true;

		int v = minDist(dist, visit);
		boolean saltoLargo = true;
		
		while (v != -1) {
			boolean salto = false;
			visit[v] = true;
			for (int w : this.neighbours(v)) {
				if (visit[w] == false && dist[w] >= this.peso(v, w) + dist[v]) {
					if(this.peso(v, w) <2) {
						dist[w] = this.peso(v, w) + dist[v];
						pred[w] = v;
						salto = true;
				
					}
					
				}
			}
			//permito que todos los nodos que no hayan podido saltar
			//puedan dar un unico salto largo, el cual es en el ultimo nodo disponible
			//que tenga un salto largo
			//nose porque funciona xd
			if(!salto && saltoLargo) {
				for (int w : this.neighbours(v)) {
					if (visit[w] == false && dist[w] >= this.peso(v, w) + dist[v]) {
						if(this.peso(v, w) >=2) {
							dist[w] = this.peso(v, w) + dist[v];
							pred[w] = v;
							//saltoLargo = false;
						}
						
					}
				}
			}

			v = minDist(dist, visit);
			
		}
		return pred;

	}

	public List<Integer> neighbours(int vertex) {
		List<Integer> r = new ArrayList<Integer>();
		for (int j = 0; j < orden; j++) {
			if (this.peso(vertex, j) != Integer.MAX_VALUE)
				r.add(j);
		}
		return r;
	}

	private int minDist(int[] dist, boolean[] visit) {
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < dist.length; i++) {
			if (visit[i] == false && dist[i] < min) {
				min = dist[i];
				idx = i;
			}
		}
		return idx;
	}

	@Override
	public String toString() {
		String r = "";
		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++) {
				r += peso(i, j) != Integer.MAX_VALUE ? String.format("%3d", peso(i, j)) : "inf";
				r += " ";
			}
			r += "\n";
		}
		return r;
	}
}
