package grafo;

public class GrafoBosque {

    private final static Integer INFINITO = null;

    private Integer[][] adyacencias;
    private Integer[][] camino;

    public GrafoBosque(int c) {
	adyacencias = new Integer[c][c];
	camino = new Integer[c][c];
	for(int i = 0; i < c; i++) {
	    // Inicializa la diagonal con 0s
	    adyacencias[i][i] = 0;
	    camino[i][i] = 0;
	}
    }

    public void agregarSendero(int ci, int cf, int l) {
	adyacencias[ci][cf] = l;
	camino[ci][cf] = l;
    }

    public Integer peso(int ci, int cf) {
	return adyacencias[ci][cf];
    }

    public void floydWarshall() {
	for(int k = 0; k < camino.length; k++) {
	    for(int i = 0; k < camino.length; i++) {
		if(camino[i][k] != null) {
		    for(int j = 0; j < camino.length; j++)
			if(camino[k][j] != null)
			    camino[i][j] = Math.min(camino[i][j],
						    camino[i][k] + camino[k][j]);

		}
	    }
	}
    }

    @Override
    public String toString() {
	String r = "";
	for(int i = 0; i < adyacencias.length; i++) {
	    for(int j = 0; j < adyacencias.length; j++) {
		r += adyacencias[i][j] != INFINITO
					? String.format(" %3d ", adyacencias[i][j])
					: " inf ";
	    }
	    r += "\n\n";
	}
	return r;
    }
}
