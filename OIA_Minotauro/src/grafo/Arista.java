package grafo;

public class Arista implements Comparable<Arista> {

    private int vi;
    private int vf;
    private int p;

    public Arista(int vi, int vf, int p) {
	this.vi = vi;
	this.vf = vf;
	this.p = p;
    }

    public int getVi() {
	return vi;
    }

    public int getVf() {
	return vf;
    }

    public int getPeso() {
	return p;
    }

    @Override
    public int compareTo(Arista o) {
	return this.p - o.p;
    }

    @Override
    public String toString() {
	return (vi + 1) + " " + (vf + 1) + " " + p;
    }

}
