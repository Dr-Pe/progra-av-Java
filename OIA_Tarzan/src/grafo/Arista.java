package grafo;

public class Arista {

    private double peso;

    // PRIMER PLANTEO
    public Arista(Vertice vi, Vertice vf) {
	int x = vi.getX() - vf.getX();
	int y = vi.getY() - vf.getY();
	this.peso = Math.hypot(x, y);
    }

    public double getPeso() {
	return peso;
    }

}
