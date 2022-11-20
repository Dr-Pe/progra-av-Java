package grafo;

public class Arista {

	private int vi;
	private int vf;
	private int p;

	public Arista(int vi, int vf, int p) {
		this.vf = vf;
		this.vi = vi;
		this.p = p;

	}

	public int getVi() {
		return this.vi;
	}

	public int getVf() {
		return this.vf;
	}
}
