
public class Dijkstra {

	private final static int MAX_PESO = 50;
	private final static int INF = MAX_PESO + 1;

	private int[] distancia;
	private int[] precedencia;

	public Dijkstra(Grafo G, int ni) {
		this.distancia = G.distancias(ni);
		this.precedencia = new int[(int) G.orden];

		boolean[] vis = new boolean[(int) G.orden];

		for (int i = 0; i < G.orden; i++) {
			if (distancia[i] != INF)
				this.precedencia[i] = ni;
		}

		int vx = minNoVisitado(distancia, vis);
		while (vx != -1) {
			vis[vx] = true;
			for (int wx : G.vecinos(vx)) {
				if (!vis[wx] && distancia[wx] > G.peso(vx, wx) + distancia[vx]) {
					distancia[wx] = G.peso(vx, wx) + distancia[vx];
					precedencia[wx] = vx;
				}
			}
			vx = minNoVisitado(distancia, vis);
		}

	}

	public int[] getDistancias() {
		return this.distancia;
	}

	public int[] getPrecedencias() {
		return this.precedencia;
	}

	private int minNoVisitado(int[] dis, boolean[] vis) {
		int min = INF;
		int i = -1;

		for (int j = 0; j < dis.length; j++) {
			if (!vis[j] && dis[j] < min) {
				min = dis[j];
				i = j;
			}
		}

		return i;
	}

}
