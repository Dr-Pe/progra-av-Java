package grafo;

public class GrafoBosque {

    private final static Integer INFINITO = null;

    private Integer[][] adyacencias;

    public GrafoBosque(int c) {
	adyacencias = new Integer[c][c];
    }

    public void agregarSendero(int ci, int cf, int l) {
	adyacencias[ci][cf] = l;
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
